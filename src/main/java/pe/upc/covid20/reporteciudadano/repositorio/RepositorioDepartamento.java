package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.covid20.reporteciudadano.entidades.Ciudadano;
import pe.upc.covid20.reporteciudadano.entidades.Departamento;

import java.util.List;

public interface RepositorioDepartamento extends JpaRepository<Departamento, Integer> {

    @Query("SELECT d FROM Departamento d WHERE d.id = :id")
    List<Departamento> findByType(@Param("id") int id);

}
