package pe.upc.covid20.reporteciudadano.entidades;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Distrito implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private Boolean esActivo;

    @OneToMany(
            mappedBy = "distrito",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Municipalidad> municipalidades;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;

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

    public Set<Municipalidad> getMunicipalidades() {
        return municipalidades;
    }

    public void setMunicipalidades(Set<Municipalidad> municipalidades) {
        this.municipalidades = municipalidades;
    }

    /*
    public Provincia getProvincia() {
        return provincia;
    }
    */

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
        provincia.getDistritos().add(this);
    }

    @JsonProperty("provincia_id")
    public void setProvinciaId(Integer id) {
        Provincia provincia = new Provincia();
        provincia.setId(id);
        this.provincia = provincia;
    }

    public Distrito() {
    }

    public Distrito(int id, String nombre, Boolean esActivo, Set<Municipalidad> municipalidades, Provincia provincia) {
        this.id = id;
        this.nombre = nombre;
        this.esActivo = esActivo;
        this.municipalidades = municipalidades;
        this.provincia = provincia;
    }
}