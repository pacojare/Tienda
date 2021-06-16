/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Detalle_Servicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleServicio.findAll", query = "SELECT d FROM DetalleServicio d")
    , @NamedQuery(name = "DetalleServicio.findById", query = "SELECT d FROM DetalleServicio d WHERE d.id = :id")
    , @NamedQuery(name = "DetalleServicio.findActivos", query = "SELECT d FROM DetalleServicio d WHERE d.status = 1")
    , @NamedQuery(name = "DetalleServicio.findEliminados", query = "SELECT d FROM DetalleServicio d WHERE d.status = 0")    
    , @NamedQuery(name = "DetalleServicio.findByPrecio", query = "SELECT d FROM DetalleServicio d WHERE d.precio = :precio")
    , @NamedQuery(name = "DetalleServicio.findByStatus", query = "SELECT d FROM DetalleServicio d WHERE d.status = :status")})
public class DetalleServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    @ManyToOne
    private Servicios idServicio;
    @JoinColumn(name = "id_servicio_ofrecido", referencedColumnName = "id")
    @ManyToOne
    private SeviciosOfrecidos idServicioOfrecido;

    public DetalleServicio() {
    }

    public DetalleServicio(Integer id) {
        this.id = id;
    }

    public DetalleServicio(Integer id, double precio, int status) {
        this.id = id;
        this.precio = precio;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Servicios getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicios idServicio) {
        this.idServicio = idServicio;
    }

    public SeviciosOfrecidos getIdServicioOfrecido() {
        return idServicioOfrecido;
    }

    public void setIdServicioOfrecido(SeviciosOfrecidos idServicioOfrecido) {
        this.idServicioOfrecido = idServicioOfrecido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleServicio)) {
            return false;
        }
        DetalleServicio other = (DetalleServicio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.DetalleServicio[ id=" + id + " ]";
    }
    
}
