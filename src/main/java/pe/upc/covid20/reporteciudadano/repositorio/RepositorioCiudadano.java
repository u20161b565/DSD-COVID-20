package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import java.util.List;

public interface RepositorioCiudadano extends JpaRepository<Ciudadano, Integer> {

    @Query("SELECT c FROM Ciudadano c WHERE c.numeroDocumento = :numeroDocumento")
    List<Ciudadano> findByType(@Param("numeroDocumento") Long numeroDocumento);

}
