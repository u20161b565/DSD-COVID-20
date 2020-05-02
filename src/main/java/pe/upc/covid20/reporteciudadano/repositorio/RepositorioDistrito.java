package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.covid20.reporteciudadano.entidades.Distrito;

public interface RepositorioDistrito extends JpaRepository<Distrito, Integer> {
}
