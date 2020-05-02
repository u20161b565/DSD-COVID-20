package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;
import pe.upc.covid20.reporteciudadano.entidades.TipoReporte;

import java.util.List;

public interface RepositorioTipoReporte extends JpaRepository<TipoReporte, Integer> {

    @Query("SELECT t FROM TipoReporte t WHERE t.id = :id")
    List<TipoReporte> findByType(@Param("id") int id);
}
