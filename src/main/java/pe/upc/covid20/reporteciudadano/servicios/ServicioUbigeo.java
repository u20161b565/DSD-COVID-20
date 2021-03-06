package pe.upc.covid20.reporteciudadano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.entidades.Departamento;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;
import pe.upc.covid20.reporteciudadano.entidades.Provincia;
import pe.upc.covid20.reporteciudadano.repositorio.*;

import java.util.List;

@Service
public class ServicioUbigeo {
    @Autowired
    private RepositorioDepartamento repositorioDepartamento;
    @Autowired
    private RepositorioProvincia repositorioProvincia;
    @Autowired
    private RepositorioDistrito repositorioDistrito;

    public List<Departamento> depaListar() {
        return repositorioDepartamento.findAll();
    }

    public Departamento depaObtener(Integer id) {
        return repositorioDepartamento.findById(id).get();
    }

    public Departamento depaRegistrar(Departamento data) {
        return repositorioDepartamento.save(data);
    }

    public Departamento depaActualizar(Integer codigo, Departamento data) {
        if (repositorioDepartamento.existsById(codigo)) {
            data.setId(codigo);
            return repositorioDepartamento.save(data);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actulizar.");
        }
    }

    public void depaEliminar(Integer codigo) {
        repositorioDepartamento.deleteById(codigo);
    }

    public List<Provincia> proListar() {
        return repositorioProvincia.findAll();
    }

    public Provincia proObtener(Integer id) {
        return repositorioProvincia.findById(id).get();
    }

    public Provincia proRegistrar(Provincia data) {
        return repositorioProvincia.save(data);
    }

    public Provincia proActualizar(Integer codigo, Provincia data) {
        if (repositorioProvincia.existsById(codigo)) {
            data.setId(codigo);
            return repositorioProvincia.save(data);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actulizar.");
        }
    }

    public void proEliminar(Integer codigo) {
        repositorioProvincia.deleteById(codigo);
    }

    public List<Distrito> disListar() {
        return repositorioDistrito.findAll();
    }

    public Distrito disObtener(Integer id) {
        return repositorioDistrito.findById(id).get();
    }

    public Distrito disRegistrar(Distrito data) {
        return repositorioDistrito.save(data);
    }

    public Distrito disActualizar(Integer codigo, Distrito data) {
        if (repositorioDistrito.existsById(codigo)) {
            data.setId(codigo);
            return repositorioDistrito.save(data);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "No se pudo actulizar.");
        }
    }

    public void disEliminar(Integer codigo) {
        repositorioDistrito.deleteById(codigo);
    }
}
