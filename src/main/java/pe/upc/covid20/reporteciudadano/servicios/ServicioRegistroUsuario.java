package pe.upc.covid20.reporteciudadano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.covid20.reporteciudadano.repositorio.RepositorioCiudadano;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;

import java.util.List;

@Service
public class ServicioRegistroUsuario {
    @Autowired
    private RepositorioCiudadano repositorioCiudadano;

    public Ciudadano registrar(Ciudadano ciudadano){
        return repositorioCiudadano.save(ciudadano);
    }

    public List<Ciudadano> listar(){
        return repositorioCiudadano.findAll();
    }
}
