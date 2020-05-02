package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;
import pe.upc.covid20.reporteciudadano.entidades.Provincia;

import java.util.List;

public interface RepositorioProvincia extends JpaRepository<Provincia, Integer> {

    @Query("SELECT p FROM Provincia p WHERE p.id = :id")
    List<Provincia> findByType(@Param("id") int id);

}
