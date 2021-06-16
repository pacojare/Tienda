package control;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import modelo.Usuarios;

/**
 *
 * @author fjasso
 */
@Named(value = "registro")
@SessionScoped
public class registro implements Serializable {

    @EJB
    private UsuariosFacade ejbFacade;

    private HttpServletRequest httpservlet;

    private String username;
    private String password;
    private String password2;
    private String nombre;
    private String email;
    private Usuarios selected;
    private modelo.Usuarios usu_autenticado;

    public Usuarios getUsu_autenticado() {
        return usu_autenticado;
    }

    public void setUsu_autenticado(Usuarios usu_autenticado) {
        this.usu_autenticado = usu_autenticado;
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
    }

    /**
     * Creates a new instance of registro
     */
    public registro() {
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        if (password.equals(password2)){
            
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Las contraseñas no coinciden", null));
        }         
        
    }

    public void Registro() throws IOException {
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usu_autenticado = ejbFacade.Acceder(username, password);
        if (usu_autenticado != null) {
            httpservlet.getSession().setAttribute("username", usu_autenticado.getUsername());
            httpservlet.getSession().setAttribute("nombre_com", usu_autenticado.getNombre() + " " + usu_autenticado.getApPat() + " " + usu_autenticado.getApMat());
            httpservlet.getSession().setAttribute("nivel_usu", usu_autenticado.getIdTipoUsu().getNivel());
            httpservlet.getSession().setAttribute("usuario", usu_autenticado);
            switch (usu_autenticado.getIdTipoUsu().getNivel()) {
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("admin.xhtml");
                    break;
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("empleado.xhtml");
                    break;
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("empleado.xhtml");
                    break;
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.xhtml");
                    break;
                case 5:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("invitado.xhtml");
                    break;
                default:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
                    break;

            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o Contraseña Incorrectos", null));
        }
    }

    

}
