package pe.upc.covid20.reporteciudadano.entidades;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reporte implements Serializable {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TipoReporte_id", referencedColumnName = "id")
    private TipoReporte tipoReporte;

    private int tipo;
    private String direccion;
    @Column(length = 5000)
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    private Departamento departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "distrito_id", referencedColumnName = "id")
    private Distrito distrito;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provincia_id", referencedColumnName = "id")
    private Provincia provincia;


}
