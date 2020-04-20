package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Reporte;
import java.util.List;

public interface RepositorioMunicipalidadReporte extends JpaRepository<Reporte, Long> {

    @Query("SELECT r FROM Reporte r WHERE r.codigo = :codigo")
    List<Reporte> findByType(@Param("codigo") Long codigo);

}