/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicios.findAll", query = "SELECT s FROM Servicios s")
    , @NamedQuery(name = "Servicios.findById", query = "SELECT s FROM Servicios s WHERE s.id = :id")
    , @NamedQuery(name = "Servicios.findActivos", query = "SELECT s FROM Servicios s WHERE s.status = 1")
    , @NamedQuery(name = "Servicios.findEliminados", query = "SELECT s FROM Servicios s WHERE s.status = 0")    
    , @NamedQuery(name = "Servicios.findByFechaInicio", query = "SELECT s FROM Servicios s WHERE s.fechaInicio = :fechaInicio")
    , @NamedQuery(name = "Servicios.findByFechaFin", query = "SELECT s FROM Servicios s WHERE s.fechaFin = :fechaFin")
    , @NamedQuery(name = "Servicios.findByTotal", query = "SELECT s FROM Servicios s WHERE s.total = :total")
    , @NamedQuery(name = "Servicios.findByStatus", query = "SELECT s FROM Servicios s WHERE s.status = :status")})
public class Servicios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idCliente;
    
    @JoinColumn(name = "id_tipo_pago", referencedColumnName = "id")
    @ManyToOne
    private Tipospago idTipoPago;
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idEmpleado;
    @OneToMany(mappedBy = "idServicio")
    private Collection<DetalleServicio> detalleServicioCollection;

    public Servicios() {
    }

    public Servicios(Integer id) {
        this.id = id;
    }

    public Servicios(Integer id, Date fechaInicio, Date fechaFin, double total, int status) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.total = total;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Tipospago getIdTipoPago() {
        return idTipoPago;
    }

    public void setIdTipoPago(Tipospago idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuarios getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuarios idCliente) {
        this.idCliente = idCliente;
    }

    public Usuarios getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Usuarios idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @XmlTransient
    public Collection<DetalleServicio> getDetalleServicioCollection() {
        return detalleServicioCollection;
    }

    public void setDetalleServicioCollection(Collection<DetalleServicio> detalleServicioCollection) {
        this.detalleServicioCollection = detalleServicioCollection;
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
        if (!(object instanceof Servicios)) {
            return false;
        }
        Servicios other = (Servicios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + "-" + idCliente +"-"+ fechaInicio;
    }
    
}
