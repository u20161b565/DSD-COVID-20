package pe.upc.covid20.reporteciudadano.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class TrabajadorMunicipalidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String usuario;
    private String contrasena;
    private String tipoDocumento;
    private String numeroDocumento;
    private String primerNombre;
    private String secundoNombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String celular;
    private Boolean esActivo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "municipalidad_id", referencedColumnName = "id")
    private Municipalidad municipalidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reporte_id", referencedColumnName = "id")
    private Reporte reporte;

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSecundoNombre() {
        return secundoNombre;
    }

    public void setSecundoNombre(String secundoNombre) {
        this.secundoNombre = secundoNombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Municipalidad getMunicipalidad() {
        return municipalidad;
    }

    public void setMunicipalidad(Municipalidad municipalidad) {
        this.municipalidad = municipalidad;
    }

    public Boolean getEsActivo() {
        return esActivo;
    }

    public void setEsActivo(Boolean esActivo) {
        this.esActivo = esActivo;
    }

    public TrabajadorMunicipalidad(Long id, String usuario, String contrasena, String tipoDocumento, String numeroDocumento, String primerNombre, String secundoNombre, String apellidoPaterno, String apellidoMaterno, String correo, String celular, Boolean esActivo, Municipalidad municipalidad, Reporte reporte) {
        this.id = id;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.primerNombre = primerNombre;
        this.secundoNombre = secundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.celular = celular;
        this.esActivo = esActivo;
        this.municipalidad = municipalidad;
        this.reporte = reporte;
    }
}
