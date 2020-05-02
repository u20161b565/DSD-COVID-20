package pe.upc.covid20.reporteciudadano.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.entidades.Departamento;
import pe.upc.covid20.reporteciudadano.entidades.Provincia;
import pe.upc.covid20.reporteciudadano.servicios.ServicioRegistroUsuario;
import pe.upc.covid20.reporteciudadano.servicios.ServicioUbigeo;

import java.util.List;

@RestController
@RequestMapping("/api/ubigeo")
public class ServicioUbigeoREST {
    @Autowired
    private ServicioUbigeo servicioUbigeo;

    @GetMapping("/departamento")
    public List<Departamento> depaListar() {
        List<Departamento> result;
        try {
            result = servicioUbigeo.depaListar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo listar.");
        }
        return result;
    }

    @GetMapping("/departamento/{codigo}")
    public Departamento depaObtener(@PathVariable("codigo") Integer codigo) {
        Departamento result;
        try {
            result = servicioUbigeo.depaObtener(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo obtener");
        }
        return result;
    }

    @PostMapping("/departamento")
    public Departamento depaRegistrar(@RequestBody Departamento input) {
        Departamento result;
        try {
            result = servicioUbigeo.depaRegistrar(input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar");
        }
        return result;
    }

    @PostMapping("/departamento/{codigo}")
    public Departamento depaActualizar(@RequestBody Departamento input, @PathVariable("codigo") Integer codigo) {
        Departamento result;
        try {
            result = servicioUbigeo.depaActualizar(codigo, input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
        }
        return result;
    }

    @DeleteMapping("/departamento/{codigo}")
    public String depaEliminar(@PathVariable("codigo") Integer codigo) {
        String result;
        try {
            servicioUbigeo.depaEliminar(codigo);
            result = "OK";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
        }
        return result;
    }

    @GetMapping("/provincia")
    public List<Provincia> proListar() {
        List<Provincia> result;
        try {
            result = servicioUbigeo.proListar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo listar.");
        }
        return result;
    }

    @GetMapping("/provincia/{codigo}")
    public Provincia proObtener(@PathVariable("codigo") Integer codigo) {
        Provincia result;
        try {
            result = servicioUbigeo.proObtener(codigo);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo obtener");
        }
        return result;
    }

    @PostMapping("/provincia")
    public Provincia proRegistrar(@RequestBody Provincia input) {
        Provincia result;
        /*
        try {
         */
            System.out.println("Controller proRegistrar");
            System.out.println(input);
            result = servicioUbigeo.proRegistrar(input);
        /*} catch (Exception e) {


            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo registrar");
        }
        */
        return result;
    }

    @PostMapping("/provincia/{codigo}")
    public Provincia proActualizar(@RequestBody Provincia input, @PathVariable("codigo") Integer codigo) {
        Provincia result;
        try {
            result = servicioUbigeo.proActualizar(codigo, input);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
        }
        return result;
    }

    @DeleteMapping("/provincia/{codigo}")
    public String proEliminar(@PathVariable("codigo") Integer codigo) {
        String result;
        try {
            servicioUbigeo.proEliminar(codigo);
            result = "OK";
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actualizar");
        }
        return result;
    }
}
