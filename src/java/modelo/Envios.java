/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Envios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Envios.findAll", query = "SELECT e FROM Envios e")
    , @NamedQuery(name = "Envios.findById", query = "SELECT e FROM Envios e WHERE e.id = :id")
    , @NamedQuery(name = "Envios.findActivos", query = "SELECT e FROM Envios e WHERE e.status = 1") 
    , @NamedQuery(name = "Envios.findEliminados", query = "SELECT e FROM Envios e WHERE e.status = 0")    
    , @NamedQuery(name = "Envios.findByNumeroGuia", query = "SELECT e FROM Envios e WHERE e.numeroGuia = :numeroGuia")
    , @NamedQuery(name = "Envios.findByFechaEnvio", query = "SELECT e FROM Envios e WHERE e.fechaEnvio = :fechaEnvio")
    , @NamedQuery(name = "Envios.findByFechaRecepcion", query = "SELECT e FROM Envios e WHERE e.fechaRecepcion = :fechaRecepcion")
    , @NamedQuery(name = "Envios.findByStatus", query = "SELECT e FROM Envios e WHERE e.status = :status")})
public class Envios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "numero_guia")
    private Integer numeroGuia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_envio")
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_recepcion")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_venta", referencedColumnName = "id")
    @ManyToOne
    private Ventas idVenta;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    @ManyToOne
    private Usuarios idCliente;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id")
    @ManyToOne
    private Direcciones idDireccion;
    @JoinColumn(name = "id_paqueteria", referencedColumnName = "id")
    @ManyToOne
    private Paqueterias idPaqueteria;

    public Envios() {
    }

    public Envios(Integer id) {
        this.id = id;
    }

    public Envios(Integer id, Date fechaEnvio, Date fechaRecepcion, int status) {
        this.id = id;
        this.fechaEnvio = fechaEnvio;
        this.fechaRecepcion = fechaRecepcion;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroGuia() {
        return numeroGuia;
    }

    public void setNumeroGuia(Integer numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
    }

    public Usuarios getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuarios idCliente) {
        this.idCliente = idCliente;
    }

    public Direcciones getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direcciones idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Paqueterias getIdPaqueteria() {
        return idPaqueteria;
    }

    public void setIdPaqueteria(Paqueterias idPaqueteria) {
        this.idPaqueteria = idPaqueteria;
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
        if (!(object instanceof Envios)) {
            return false;
        }
        Envios other = (Envios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Envios[ id=" + id + " ]";
    }
    
}
