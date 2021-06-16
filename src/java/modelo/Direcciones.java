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
@Table(name = "Direcciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Direcciones.findAll", query = "SELECT d FROM Direcciones d")
    , @NamedQuery(name = "Direcciones.findById", query = "SELECT d FROM Direcciones d WHERE d.id = :id")
    , @NamedQuery(name = "Direcciones.findActivos", query = "SELECT d FROM Direcciones d WHERE d.status = 1")
    , @NamedQuery(name = "Direcciones.findEliminados", query = "SELECT d FROM Direcciones d WHERE d.status = 0")    
    , @NamedQuery(name = "Direcciones.findByDireccion", query = "SELECT d FROM Direcciones d WHERE d.direccion = :direccion")
    , @NamedQuery(name = "Direcciones.findByColonia", query = "SELECT d FROM Direcciones d WHERE d.colonia = :colonia")
    , @NamedQuery(name = "Direcciones.findByCp", query = "SELECT d FROM Direcciones d WHERE d.cp = :cp")
    , @NamedQuery(name = "Direcciones.findByAlias", query = "SELECT d FROM Direcciones d WHERE d.alias = :alias")
    , @NamedQuery(name = "Direcciones.findByStatus", query = "SELECT d FROM Direcciones d WHERE d.status = :status")})
public class Direcciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cp")
    private int cp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "alias")
    private String alias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @OneToMany(mappedBy = "idDireccion")
    private Collection<Envios> enviosCollection;
    @JoinColumn(name = "id_pais", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Paises idPais;
    @JoinColumn(name = "id_entidad", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Entidades idEntidad;
    @JoinColumn(name = "id_municipio", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Municipios idMunicipio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuario;

    public Direcciones() {
    }

    public Direcciones(Integer id) {
        this.id = id;
    }

    public Direcciones(Integer id, String direccion, String colonia, int cp, String alias, int status) {
        this.id = id;
        this.direccion = direccion;
        this.colonia = colonia;
        this.cp = cp;
        this.alias = alias;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Envios> getEnviosCollection() {
        return enviosCollection;
    }

    public void setEnviosCollection(Collection<Envios> enviosCollection) {
        this.enviosCollection = enviosCollection;
    }

    public Paises getIdPais() {
        return idPais;
    }

    public void setIdPais(Paises idPais) {
        this.idPais = idPais;
    }

    public Entidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Entidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Municipios getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Municipios idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Usuarios getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuarios idUsuario) {
        this.idUsuario = idUsuario;
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
        if (!(object instanceof Direcciones)) {
            return false;
        }
        Direcciones other = (Direcciones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return alias +" "+ direccion +" "+ colonia;
    }
    
}
