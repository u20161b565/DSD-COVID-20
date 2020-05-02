package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Departamento;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;

import java.util.List;

public interface RepositorioDistrito extends JpaRepository<Distrito, Integer> {

    @Query("SELECT d FROM Distrito d WHERE d.id = :id")
    List<Distrito> findByType(@Param("id") int id);

}
