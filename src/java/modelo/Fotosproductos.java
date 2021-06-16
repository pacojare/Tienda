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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Fotos_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fotosproductos.findAll", query = "SELECT f FROM Fotosproductos f")
    , @NamedQuery(name = "Fotosproductos.findById", query = "SELECT f FROM Fotosproductos f WHERE f.id = :id")
    , @NamedQuery(name = "Fotosproductos.findActivos", query = "SELECT f FROM Fotosproductos f WHERE f.status = 1")
    , @NamedQuery(name = "Fotosproductos.findEliminados", query = "SELECT f FROM Fotosproductos f WHERE f.status = 0")    
    , @NamedQuery(name = "Fotosproductos.findByRuta", query = "SELECT f FROM Fotosproductos f WHERE f.ruta = :ruta")
    , @NamedQuery(name = "Fotosproductos.findByStatus", query = "SELECT f FROM Fotosproductos f WHERE f.status = :status")})
public class Fotosproductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ruta")
    private String ruta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    @ManyToOne
    private Productos idProducto;

    public Fotosproductos() {
    }

    public Fotosproductos(Integer id) {
        this.id = id;
    }

    public Fotosproductos(Integer id, String ruta, int status) {
        this.id = id;
        this.ruta = ruta;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
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
        if (!(object instanceof Fotosproductos)) {
            return false;
        }
        Fotosproductos other = (Fotosproductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ruta;
    }
    
}
