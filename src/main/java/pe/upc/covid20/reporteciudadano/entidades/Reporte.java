package pe.upc.covid20.reporteciudadano.entidades;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Reporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoReporte_id", referencedColumnName = "id")
    private TipoReporte tipoReporte;

    private String direccion;
    private int latitud;
    private int longitud;
    private String status;
    @Column(length = 5000)
    private String descripcion;
    private boolean notificacionPolicia;
    private boolean notificacionSerenazgo;
    private boolean notificacionBomberos;
    private boolean notificacionAmbulancia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distrito_id", referencedColumnName = "id")
    private Distrito distrito;

    @OneToMany(
            mappedBy = "reporte",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<Ciudadano> ciudadanos;

    @OneToMany(
            mappedBy = "reporte",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<TrabajadorMunicipalidad> trabajadorMunicipalidads;

    public boolean isNotificacionPolicia() {
        return notificacionPolicia;
    }

    public void setNotificacionPolicia(boolean notificacionPolicia) {
        this.notificacionPolicia = notificacionPolicia;
    }

    public boolean isNotificacionSerenazgo() {
        return notificacionSerenazgo;
    }

    public void setNotificacionSerenazgo(boolean notificacionSerenazgo) {
        this.notificacionSerenazgo = notificacionSerenazgo;
    }

    public boolean isNotificacionBomberos() {
        return notificacionBomberos;
    }

    public void setNotificacionBomberos(boolean notificacionBomberos) {
        this.notificacionBomberos = notificacionBomberos;
    }

    public boolean isNotificacionAmbulancia() {
        return notificacionAmbulancia;
    }

    public void setNotificacionAmbulancia(boolean notificacionAmbulancia) {
        this.notificacionAmbulancia = notificacionAmbulancia;
    }

    public Set<TrabajadorMunicipalidad> getTrabajadorMunicipalidads() {
        return trabajadorMunicipalidads;
    }

    public void setTrabajadorMunicipalidads(Set<TrabajadorMunicipalidad> trabajadorMunicipalidads) {
        this.trabajadorMunicipalidads = trabajadorMunicipalidads;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoReporte getTipoReporte() {
        return tipoReporte;
    }

    public void setTipoReporte(TipoReporte tipoReporte) {
        this.tipoReporte = tipoReporte;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getLatitud() {
        return latitud;
    }

    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public Set<Ciudadano> getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(Set<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public Reporte(int id, TipoReporte tipoReporte, String direccion, int latitud, int longitud, String status, String descripcion, boolean notificacionPolicia, boolean notificacionSerenazgo, boolean notificacionBomberos, boolean notificacionAmbulancia, Distrito distrito, Set<Ciudadano> ciudadanos, Set<TrabajadorMunicipalidad> trabajadorMunicipalidads) {
        this.id = id;
        this.tipoReporte = tipoReporte;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.status = status;
        this.descripcion = descripcion;
        this.notificacionPolicia = notificacionPolicia;
        this.notificacionSerenazgo = notificacionSerenazgo;
        this.notificacionBomberos = notificacionBomberos;
        this.notificacionAmbulancia = notificacionAmbulancia;
        this.distrito = distrito;
        this.ciudadanos = ciudadanos;
        this.trabajadorMunicipalidads = trabajadorMunicipalidads;
    }
}
