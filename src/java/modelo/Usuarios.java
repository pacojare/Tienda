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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author fjasso
 */
@Entity
@Table(name = "Usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")
    , @NamedQuery(name = "Usuarios.findById", query = "SELECT u FROM Usuarios u WHERE u.id = :id")
    , @NamedQuery(name = "Usuarios.Username", query = "SELECT u FROM Usuarios u WHERE u.username = :usu1")
    , @NamedQuery(name = "Usuarios.Email", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.Acceder", query = "SELECT u FROM Usuarios u WHERE u.username = :usu1 and u.password = :pass1")
    , @NamedQuery(name = "Usuarios.findActivos", query = "SELECT u FROM Usuarios u WHERE u.status = 1")
    , @NamedQuery(name = "Usuarios.findEliminados", query = "SELECT u FROM Usuarios u WHERE u.status = 0")    
    , @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuarios.findByApPat", query = "SELECT u FROM Usuarios u WHERE u.apPat = :apPat")
    , @NamedQuery(name = "Usuarios.findByApMat", query = "SELECT u FROM Usuarios u WHERE u.apMat = :apMat")
    , @NamedQuery(name = "Usuarios.findByRfc", query = "SELECT u FROM Usuarios u WHERE u.rfc = :rfc")
    , @NamedQuery(name = "Usuarios.findByCurp", query = "SELECT u FROM Usuarios u WHERE u.curp = :curp")
    , @NamedQuery(name = "Usuarios.findByEmail", query = "SELECT u FROM Usuarios u WHERE u.email = :email")
    , @NamedQuery(name = "Usuarios.findByTelefono", query = "SELECT u FROM Usuarios u WHERE u.telefono = :telefono")
    , @NamedQuery(name = "Usuarios.findByTelefonoTxt", query = "SELECT u FROM Usuarios u WHERE u.telefonoTxt = :telefonoTxt")
    , @NamedQuery(name = "Usuarios.findByFechaNaci", query = "SELECT u FROM Usuarios u WHERE u.fechaNaci = :fechaNaci")
    , @NamedQuery(name = "Usuarios.findByUsername", query = "SELECT u FROM Usuarios u WHERE u.username = :username")
    , @NamedQuery(name = "Usuarios.findByPassword", query = "SELECT u FROM Usuarios u WHERE u.password = :password")
    , @NamedQuery(name = "Usuarios.findByStatus", query = "SELECT u FROM Usuarios u WHERE u.status = :status")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //nombre
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "nombre")
    private String nombre;
    //ap_pat
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ap_pat")
    private String apPat;
    //ap_mat
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "ap_mat")
    private String apMat;
    //RFC
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "rfc")
    private String rfc;
    //Curp
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "curp")
    private String curp;
    //Correo
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email")
    private String email;
    //Telefono
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    //telefono_txt
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "telefono_txt")
    private String telefonoTxt;
    //fecha nacimiento
    @Column(name = "fecha_naci")
    @Temporal(TemporalType.DATE)
    private Date fechaNaci;
    //username
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "username")
    private String username;
    //password
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "password")
    private String password;
    //status
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    
    @OneToMany(mappedBy = "idCliente")
    private Collection<Servicios> serviciosCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Servicios> serviciosCollection1;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Envios> enviosCollection;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Ventas> ventasCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Ventas> ventasCollection1;
    @JoinColumn(name = "id_tipo_usu", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tiposusuario idTipoUsu;
    @OneToMany(mappedBy = "idUsuario")
    private Collection<Compras> comprasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario")
    private Collection<Direcciones> direccionesCollection;

    public Usuarios() {
    }

    public Usuarios(Integer id) {
        this.id = id;
    }

    public Usuarios(Integer id, String nombre, String apPat, String apMat, String rfc, String curp, String email, int telefono, String telefonoTxt, String username, String password, int status) {
        this.id = id;
        this.nombre = nombre;
        this.apPat = apPat;
        this.apMat = apMat;
        this.rfc = rfc;
        this.curp = curp;
        this.email = email;
        this.telefono = telefono;
        this.telefonoTxt = telefonoTxt;
        this.username = username;
        this.password = password;
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

    public String getApPat() {
        return apPat;
    }

    public void setApPat(String apPat) {
        this.apPat = apPat;
    }

    public String getApMat() {
        return apMat;
    }

    public void setApMat(String apMat) {
        this.apMat = apMat;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoTxt() {
        return telefonoTxt;
    }

    public void setTelefonoTxt(String telefonoTxt) {
        this.telefonoTxt = telefonoTxt;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public Collection<Servicios> getServiciosCollection() {
        return serviciosCollection;
    }

    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }

    @XmlTransient
    public Collection<Servicios> getServiciosCollection1() {
        return serviciosCollection1;
    }

    public void setServiciosCollection1(Collection<Servicios> serviciosCollection1) {
        this.serviciosCollection1 = serviciosCollection1;
    }

    @XmlTransient
    public Collection<Envios> getEnviosCollection() {
        return enviosCollection;
    }

    public void setEnviosCollection(Collection<Envios> enviosCollection) {
        this.enviosCollection = enviosCollection;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection() {
        return ventasCollection;
    }

    public void setVentasCollection(Collection<Ventas> ventasCollection) {
        this.ventasCollection = ventasCollection;
    }

    @XmlTransient
    public Collection<Ventas> getVentasCollection1() {
        return ventasCollection1;
    }

    public void setVentasCollection1(Collection<Ventas> ventasCollection1) {
        this.ventasCollection1 = ventasCollection1;
    }

    public Tiposusuario getIdTipoUsu() {
        return idTipoUsu;
    }

    public void setIdTipoUsu(Tiposusuario idTipoUsu) {
        this.idTipoUsu = idTipoUsu;
    }

    @XmlTransient
    public Collection<Compras> getComprasCollection() {
        return comprasCollection;
    }

    public void setComprasCollection(Collection<Compras> comprasCollection) {
        this.comprasCollection = comprasCollection;
    }

    @XmlTransient
    public Collection<Direcciones> getDireccionesCollection() {
        return direccionesCollection;
    }

    public void setDireccionesCollection(Collection<Direcciones> direccionesCollection) {
        this.direccionesCollection = direccionesCollection;
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
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " " + apPat + " " + apMat;
    }
    
}
