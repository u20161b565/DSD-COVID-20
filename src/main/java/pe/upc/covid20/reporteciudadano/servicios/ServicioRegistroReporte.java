package pe.upc.covid20.reporteciudadano.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.covid20.reporteciudadano.repositorio.RepositorioReporte;
import pe.upc.covid20.reporteciudadano.entidades.Reporte;

import java.util.List;

@Service
public class ServicioRegistroReporte {
    @Autowired
    private RepositorioReporte repositorioReporte;

    public Reporte registrarReporte(Reporte reporte){
        return repositorioReporte.save(reporte);
    }

    public List<Reporte> listarReporte(){
        return repositorioReporte.findAll();
    }
}
