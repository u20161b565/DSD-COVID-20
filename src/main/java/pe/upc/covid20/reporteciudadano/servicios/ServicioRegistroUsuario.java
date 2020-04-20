package pe.upc.covid20.reporteciudadano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.covid20.reporteciudadano.repositorio.RepositorioMunicipalidadCiudadano;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;

import java.util.List;

@Service
public class ServicioRegistroUsuario {
    @Autowired
    private RepositorioMunicipalidadCiudadano repositorioMunicipalidadCiudadano;

    public Ciudadano registrar(Ciudadano ciudadano){
        return repositorioMunicipalidadCiudadano.save(ciudadano);
    }

    public List<Ciudadano> listar(){
        return repositorioMunicipalidadCiudadano.findAll();
    }
}
