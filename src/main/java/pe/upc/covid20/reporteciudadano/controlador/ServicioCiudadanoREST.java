package pe.upc.covid20.reporteciudadano.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.servicios.ServicioCiudadano;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioCiudadanoREST {
    @Autowired
    private ServicioCiudadano servicioCiudadano;

    @GetMapping("/ciudadano")
    public List<Ciudadano> ciListar() {
        List<Ciudadano> result;
        try {
            result = servicioCiudadano.ciListar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo listar.");
        }
        return result;
    }

    @GetMapping("/ciudadano/{codigo}")
    public Ciudadano ciObtener(@PathVariable("codigo") Integer codigo) {
        Ciudadano result;
        try {
            result = servicioCiudadano.ciObtener(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo obtener");
        }
        return result;
    }

    @PostMapping("/ciudadano")
    public Ciudadano ciRegistrar(@RequestBody Ciudadano input) {
        Ciudadano result;
        try {
            result = servicioCiudadano.ciRegistrar(input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar");
        }
        return result;
    }

    @PostMapping("/ciudadano/{codigo}")
    public Ciudadano ciActualizar(@RequestBody Ciudadano input, @PathVariable("codigo") Integer codigo) {
        Ciudadano result;
        try {
            result = servicioCiudadano.ciActualizar(codigo, input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
        }
        return result;
    }

//    @DeleteMapping("/ciudadano/{codigo}")
//    public String ciEliminar(@PathVariable("codigo") Integer codigo) {
//        String result;
//        try {
//            servicioCiudadano.ciEliminar(codigo);
//            result = "OK";
//        } catch (Exception e) {
//            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
//        }
//        return result;
//    }
}
