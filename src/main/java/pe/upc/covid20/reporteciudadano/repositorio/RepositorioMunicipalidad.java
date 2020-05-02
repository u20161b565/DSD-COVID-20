package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.covid20.reporteciudadano.entidades.Municipalidad;

public interface RepositorioMunicipalidad extends JpaRepository<Municipalidad, Integer> {
}
