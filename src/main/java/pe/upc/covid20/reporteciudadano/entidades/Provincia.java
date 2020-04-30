package pe.upc.covid20.reporteciudadano.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Provincia implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Boolean esActivo;

    @OneToMany(
            mappedBy = "provincia",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Distrito> distritos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    private Departamento departamento;

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

    public Set<Distrito> getDistritos() {
        return distritos;
    }

    public void setDistritos(Set<Distrito> distritos) {
        this.distritos = distritos;
        /*
        for (Distrito distrito : distritos) {
            distrito.setProvincia(this);
        }*/
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        // departamento.getProvincias().add(this);
    }
}