package pe.upc.covid20.reporteciudadano.controlador;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Reporte;
import pe.upc.covid20.reporteciudadano.servicios.JmsProducerConsumer;

@RestController
@RequestMapping("/api")
public class JmsREST {
    @Autowired
    private JmsProducerConsumer jmsProducer;

    @PostMapping("/enviar/reporte")
    public String ciRegistrar(@RequestBody Reporte input) {
        String result;
        try {
            Gson gson = new Gson();
            String jsonInString = gson.toJson(input);
            jmsProducer.enviarRecibir(jsonInString);
            result = "Reporte recibido";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar");
        }
        return result;
    }

    @GetMapping("/enviar/{mensaje}")
    public String enviar(@PathVariable(value = "mensaje") String mensaje) {
        jmsProducer.enviarRecibir(mensaje);
        return "OK!";
    }


}
