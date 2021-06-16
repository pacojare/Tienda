/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

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
@Named(value = "login")
@SessionScoped
public class login implements Serializable {

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


    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
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

    public Usuarios getUsu_autenticado() {
        return usu_autenticado;
    }

    public void setUsu_autenticado(Usuarios usu_autenticado) {
        this.usu_autenticado = usu_autenticado;
    }

    public login() {
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
    }

    public void Acesso() throws IOException {
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        usu_autenticado = ejbFacade.Acceder(username, password);
        if (usu_autenticado != null) {
            httpservlet.getSession().setAttribute("username", usu_autenticado.getUsername());
            httpservlet.getSession().setAttribute("nombre_com", usu_autenticado.getNombre() + " " + usu_autenticado.getApPat() + " " + usu_autenticado.getApMat());
            httpservlet.getSession().setAttribute("nivel_usu", usu_autenticado.getIdTipoUsu().getNivel());
            httpservlet.getSession().setAttribute("usuario", usu_autenticado);
            switch (usu_autenticado.getIdTipoUsu().getNivel()) {
                case 1:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("Administrador.xhtml");
                    break;
                case 2:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("Empleado.xhtml");
                    break;
                case 3:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("Empleado.xhtml");
                    break;
                case 4:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("Cliente.xhtml");
                    break;                
                default:
                    FacesContext.getCurrentInstance().getExternalContext().redirect("inicio.xhtml");
                    break;

            }

        }else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario o Contraseña Incorrectos",null ));
    }
    
    
    
    public void cerrarSesion(){
        try{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Tienda/faces/login.xhtml");
        }catch(Exception e){            
        }        
    }
    
    public void verificaSesionyNivel(int nivel) throws IOException{
        httpservlet = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Usuarios usu = (Usuarios) httpservlet.getSession().getAttribute("usuario");
        if(usu != null){
            if(usu.getIdTipoUsu().getNivel() > nivel)
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Tienda/faces/sin_permisos.xhtml");            
        }else{
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
            FacesContext.getCurrentInstance().getExternalContext().redirect("/Tienda/faces/login.xhtml");
             
        }
        
    }
}
