/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Sevicios_Ofrecidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SeviciosOfrecidos.findAll", query = "SELECT s FROM SeviciosOfrecidos s")
    , @NamedQuery(name = "SeviciosOfrecidos.findById", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.id = :id")
    , @NamedQuery(name = "SeviciosOfrecidos.findActivos", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.status = 1")
    , @NamedQuery(name = "SeviciosOfrecidos.findEliminados", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.status = 0")    
    , @NamedQuery(name = "SeviciosOfrecidos.findByNombre", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SeviciosOfrecidos.findByDescripcion", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.descripcion = :descripcion")
    , @NamedQuery(name = "SeviciosOfrecidos.findByPrecio", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.precio = :precio")
    , @NamedQuery(name = "SeviciosOfrecidos.findByStatus", query = "SELECT s FROM SeviciosOfrecidos s WHERE s.status = :status")})
public class SeviciosOfrecidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_categoria_servicio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CategoriasServicios idCategoriaServicio;
    @OneToMany(mappedBy = "idServicioOfrecido")
    private Collection<DetalleServicio> detalleServicioCollection;

    public SeviciosOfrecidos() {
    }

    public SeviciosOfrecidos(Integer id) {
        this.id = id;
    }

    public SeviciosOfrecidos(Integer id, String nombre, double precio, int status) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public CategoriasServicios getIdCategoriaServicio() {
        return idCategoriaServicio;
    }

    public void setIdCategoriaServicio(CategoriasServicios idCategoriaServicio) {
        this.idCategoriaServicio = idCategoriaServicio;
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
        if (!(object instanceof SeviciosOfrecidos)) {
            return false;
        }
        SeviciosOfrecidos other = (SeviciosOfrecidos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
