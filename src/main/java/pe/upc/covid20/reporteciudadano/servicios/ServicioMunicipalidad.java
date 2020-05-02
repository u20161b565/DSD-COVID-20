package pe.upc.covid20.reporteciudadano.servicios;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.entidades.Municipalidad;
import pe.upc.covid20.reporteciudadano.entidades.Provincia;
import pe.upc.covid20.reporteciudadano.repositorio.*;

import java.util.List;

@Service
public class ServicioMunicipalidad {
    @Autowired
    private RepositorioDepartamento repositorioDepartamento;
    @Autowired
    private RepositorioProvincia repositorioProvincia;
    @Autowired
    private RepositorioDistrito repositorioDistrito;
    @Autowired
    private RepositorioMunicipalidad repositorioMunicipalidad;
    @Autowired
    private RepositorioCiudadano repositorioCiudadano;

    public Municipalidad proRegistrar(Municipalidad municipalidad) {
        return repositorioMunicipalidad.save(municipalidad);
    }

    public List<Municipalidad> proListar() {
        return repositorioMunicipalidad.findAll();
    }

    public Municipalidad proActualizar(Integer codigo, Municipalidad municipalidad) {
        if (repositorioMunicipalidad.existsById(codigo)) {
            municipalidad.setId(codigo);
            return repositorioMunicipalidad.save(municipalidad);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actulizar.");
        }
    }

    public void proEliminar(Integer codigo) {
        repositorioMunicipalidad.deleteById(codigo);
    }

    public Municipalidad proObtener(Integer id) {
        return repositorioMunicipalidad.findById(id).get();
    }
}
