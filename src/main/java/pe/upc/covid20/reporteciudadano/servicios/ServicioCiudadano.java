package pe.upc.covid20.reporteciudadano.servicios;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.repositorio.RepositorioCiudadano;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.google.gson.Gson;


import java.util.List;


@Service
public class ServicioCiudadano {
    @Autowired
    private RepositorioCiudadano repositorioCiudadano;

    public List<Ciudadano> ciListar() {
        return repositorioCiudadano.findAll();
    }

    public Ciudadano ciObtener(Integer id) {
        return repositorioCiudadano.findById(id).get();
    }

    public Ciudadano ciRegistrar(Ciudadano data){
        System.out.println(data.getPrimerNombre());
        System.out.println(data.getSecundoNombre());
        System.out.println(data.getApellidoPaterno());
        System.out.println(data.getApellidoMaterno());

        if (data.getTipoDocumento().equalsIgnoreCase("DNI")) {
            try {
                OkHttpClient client = new OkHttpClient().newBuilder()
                        .build();
                Request request = new Request.Builder()
                        .url("https://api.aios.pe/validar/dni/" + data.getNumeroDocumento())
                        .method("GET", null)
                        .build();
                Response response = client.newCall(request).execute();

                JsonObject result = new JsonParser().parse(response.body().string()).getAsJsonObject();
                String estado = result.get("status").getAsString();
                if(estado.equalsIgnoreCase("OK")) {
                    String nameInput = (data.getApellidoPaterno() + " " +data.getApellidoMaterno() + ", " + data.getPrimerNombre() + " " +data.getSecundoNombre()).trim();
                    JsonObject resultOBJ = (JsonObject) result.get("data");
                    String nameAPI = (resultOBJ.get("apellido_paterno").getAsString() + " " + resultOBJ.get("apellido_materno").getAsString() + ", " + resultOBJ.get("primer_nombre").getAsString() + " " + resultOBJ.get("segundo_nombre").getAsString()).trim();

                    System.out.println(nameInput);
                    System.out.println(nameAPI);

                    if(!nameInput.equalsIgnoreCase(nameAPI))  {
                        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Sus nombres y apellidos deben ser iguales a su dni.");
                    }
                }
            } catch (Exception ex) {
                System.out.println("ERROR");
            }
        }
        data.setPrimerNombre(data.getPrimerNombre().toUpperCase());
        data.setSecundoNombre(data.getSecundoNombre().toUpperCase());
        data.setApellidoPaterno(data.getApellidoPaterno().toUpperCase());
        data.setApellidoMaterno(data.getApellidoMaterno().toUpperCase());
        return repositorioCiudadano.save(data);
    }

    public Ciudadano ciActualizar(Integer codigo, Ciudadano data){
        if (repositorioCiudadano.existsById(codigo)) {
            data.setId(codigo);
            return repositorioCiudadano.save(data);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actulizar.");
        }
    }

    public void ciEliminar(Integer codigo) {
        repositorioCiudadano.deleteById(codigo);
    }
}
