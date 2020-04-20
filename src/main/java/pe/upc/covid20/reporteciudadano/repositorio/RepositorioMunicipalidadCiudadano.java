package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import java.util.List;

public interface RepositorioMunicipalidadCiudadano extends JpaRepository<Ciudadano, Long> {

    @Query("SELECT c FROM Ciudadano c WHERE c.dni = :dni")
    List<Ciudadano> findByType(@Param("dni") Long dni);

}
