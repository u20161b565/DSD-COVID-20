package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Reporte;

import java.util.List;

public interface RepositorioReporte extends JpaRepository<Reporte, Integer> {

    @Query("SELECT r FROM Reporte r WHERE r.id = :id")
    List<Reporte> findByType(@Param("id") int id);

}