package pe.upc.covid20.reporteciudadano.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.servicios.ServicioRegistroUsuario;
import pe.upc.covid20.reporteciudadano.entidades.Reporte;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.servicios.ServicioRegistroReporte;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioMunicipalidadREST {
    @Autowired
    private ServicioRegistroUsuario servicioRegistroUsuario;
    @Autowired
    private ServicioRegistroReporte servicioRegistroReporte;

    @PostMapping("/ciudadano")
    public Ciudadano registrar(@RequestBody Ciudadano ciudadano){
        Ciudadano c;
        try {
            System.out.print(ciudadano.getDni());
            c = servicioRegistroUsuario.registrar(ciudadano);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo guardar.");
        }
        return c;
    }

    @GetMapping("/ciudadano")
    public List<Ciudadano> listar() {
        List<Ciudadano> l;
        try {
            l = servicioRegistroUsuario.listar();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo listar.");
        }
        return l;
    }

    @PostMapping("/reporte")
    public Reporte registrar(@RequestBody Reporte reporte){
        Reporte r;
        try {
            System.out.print(reporte);
            r = servicioRegistroReporte.registrarReporte(reporte);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo guardar.");
        }
        return r;
    }

    @GetMapping("/reporte")
    public List<Reporte> listarReporte() {
        List<Reporte> l;
        try {
            l = servicioRegistroReporte.listarReporte();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo listar.");
        }
        return l;
    }
}
