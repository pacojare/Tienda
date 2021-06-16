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
@Table(name = "Categorias_Servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriasServicios.findAll", query = "SELECT c FROM CategoriasServicios c")
    , @NamedQuery(name = "CategoriasServicios.findById", query = "SELECT c FROM CategoriasServicios c WHERE c.id = :id")
    , @NamedQuery(name = "CategoriasServicios.findActivos", query = "SELECT c FROM CategoriasServicios c WHERE c.status = 1")
    , @NamedQuery(name = "CategoriasServicios.findEliminados", query = "SELECT c FROM CategoriasServicios c WHERE c.status = 0")    
    , @NamedQuery(name = "CategoriasServicios.findByNombre", query = "SELECT c FROM CategoriasServicios c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CategoriasServicios.findByStatus", query = "SELECT c FROM CategoriasServicios c WHERE c.status = :status")})
public class CategoriasServicios implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoriaServicio")
    private Collection<SeviciosOfrecidos> seviciosOfrecidosCollection;

    public CategoriasServicios() {
    }

    public CategoriasServicios(Integer id) {
        this.id = id;
    }

    public CategoriasServicios(Integer id, String nombre, int status) {
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
    public Collection<SeviciosOfrecidos> getSeviciosOfrecidosCollection() {
        return seviciosOfrecidosCollection;
    }

    public void setSeviciosOfrecidosCollection(Collection<SeviciosOfrecidos> seviciosOfrecidosCollection) {
        this.seviciosOfrecidosCollection = seviciosOfrecidosCollection;
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
        if (!(object instanceof CategoriasServicios)) {
            return false;
        }
        CategoriasServicios other = (CategoriasServicios) object;
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
