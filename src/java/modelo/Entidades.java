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
@Table(name = "Entidades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entidades.findAll", query = "SELECT e FROM Entidades e")
    , @NamedQuery(name = "Entidades.findEntidades_x_pais", query = "SELECT e FROM Entidades e WHERE e.idPais.id = :id_p")
    , @NamedQuery(name = "Entidades.findActivos", query = "SELECT e FROM Entidades e WHERE e.status = 1")
    , @NamedQuery(name = "Entidades.findEliminados", query = "SELECT e FROM Entidades e WHERE e.status = 0")    
    , @NamedQuery(name = "Entidades.findById", query = "SELECT e FROM Entidades e WHERE e.id = :id")
    , @NamedQuery(name = "Entidades.findByNombre", query = "SELECT e FROM Entidades e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "Entidades.findByStatus", query = "SELECT e FROM Entidades e WHERE e.status = :status")})
public class Entidades implements Serializable {

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
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne
    private Paises idPais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidad")
    private Collection<Direcciones> direccionesCollection;
    @OneToMany(mappedBy = "idEntidad")
    private Collection<Municipios> municipiosCollection;

    public Entidades() {
    }

    public Entidades(Integer id) {
        this.id = id;
    }

    public Entidades(Integer id, String nombre, int status) {
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

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    @XmlTransient
    public Collection<Direcciones> getDireccionesCollection() {
        return direccionesCollection;
    }

    public void setDireccionesCollection(Collection<Direcciones> direccionesCollection) {
        this.direccionesCollection = direccionesCollection;
    }

    @XmlTransient
    public Collection<Municipios> getMunicipiosCollection() {
        return municipiosCollection;
    }

    public void setMunicipiosCollection(Collection<Municipios> municipiosCollection) {
        this.municipiosCollection = municipiosCollection;
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
        if (!(object instanceof Entidades)) {
            return false;
        }
        Entidades other = (Entidades) object;
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
