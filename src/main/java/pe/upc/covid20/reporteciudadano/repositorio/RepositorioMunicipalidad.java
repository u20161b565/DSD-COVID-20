package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;
import pe.upc.covid20.reporteciudadano.entidades.Municipalidad;

import java.util.List;

public interface RepositorioMunicipalidad extends JpaRepository<Municipalidad, Integer> {

    @Query("SELECT m FROM Municipalidad m WHERE m.id = :id")
    List<Municipalidad> findByType(@Param("id") int id);

}
