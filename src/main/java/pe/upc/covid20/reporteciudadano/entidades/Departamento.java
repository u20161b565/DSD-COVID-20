package pe.upc.covid20.reporteciudadano.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Boolean esActivo;

    @OneToMany(
            mappedBy = "departamento",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Provincia> provincias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public Set<Provincia> getProvincias() {
        return provincias;
    }

    public void setProvincias(Set<Provincia> provincias) {
        this.provincias = provincias;
        for (Provincia provincia : provincias) {
            provincia.setDepartamento(this);
        }
    }
    public Departamento() {
        this.provincias = new HashSet<>();
    }
    public Departamento(int id, String nombre, Boolean esActivo) {
        this.id = id;
        this.nombre = nombre;
        this.esActivo = esActivo;
        this.provincias = provincias;
        this.provincias = new HashSet<>();
    }


}