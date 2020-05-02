package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.covid20.reporteciudadano.entidades.Departamento;

public interface RepositorioDepartamento  extends JpaRepository<Departamento, Integer> {
}
