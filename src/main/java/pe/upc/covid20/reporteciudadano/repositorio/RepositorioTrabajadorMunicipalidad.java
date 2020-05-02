package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;
import pe.upc.covid20.reporteciudadano.entidades.TrabajadorMunicipalidad;

import java.util.List;

public interface RepositorioTrabajadorMunicipalidad extends JpaRepository<TrabajadorMunicipalidad, Long> {

    @Query("SELECT t FROM TrabajadorMunicipalidad t WHERE t.id = :id")
    List<TrabajadorMunicipalidad> findByType(@Param("id") int id);
}
