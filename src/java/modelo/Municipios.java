/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Municipios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Municipios.findAll", query = "SELECT m FROM Municipios m")
    , @NamedQuery(name = "Municipios.findById", query = "SELECT m FROM Municipios m WHERE m.id = :id")
    , @NamedQuery(name = "Municipios.findMunicipios_x_pais", query = "SELECT e FROM Municipios e WHERE e.idEntidad.id = :id_e")
    , @NamedQuery(name = "Municipios.findActivos", query = "SELECT m FROM Municipios m WHERE m.status = 1")
    , @NamedQuery(name = "Municipios.findEliminados", query = "SELECT m FROM Municipios m WHERE m.status = 0")
    , @NamedQuery(name = "Municipios.findByNombre", query = "SELECT m FROM Municipios m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Municipios.findByStatus", query = "SELECT m FROM Municipios m WHERE m.status = :status")})
public class Municipios implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicipio")
    private Collection<Proveedores> proveedoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicipio")
    private Collection<Direcciones> direccionesCollection;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id")
    @ManyToOne
    private Entidades idEntidad;

    public Municipios() {
    }

    public Municipios(Integer id) {
        this.id = id;
    }

    public Municipios(Integer id, String nombre, int status) {
        this.id = id;
        this.nombre = nombre;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Proveedores> getProveedoresCollection() {
        return proveedoresCollection;
    }

    public void setProveedoresCollection(Collection<Proveedores> proveedoresCollection) {
        this.proveedoresCollection = proveedoresCollection;
    }

    @XmlTransient
    public Collection<Direcciones> getDireccionesCollection() {
        return direccionesCollection;
    }

    public void setDireccionesCollection(Collection<Direcciones> direccionesCollection) {
        this.direccionesCollection = direccionesCollection;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
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
        if (!(object instanceof Municipios)) {
            return false;
        }
        Municipios other = (Municipios) object;
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
