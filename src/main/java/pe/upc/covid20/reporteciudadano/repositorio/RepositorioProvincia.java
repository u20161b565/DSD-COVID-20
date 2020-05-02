package pe.upc.covid20.reporteciudadano.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.covid20.reporteciudadano.entidades.Provincia;

public interface RepositorioProvincia extends JpaRepository<Provincia, Integer> {
}
