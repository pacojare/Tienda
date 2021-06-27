package control;

import modelo.Usuarios;
import modelo.Tiposusuario;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.AjaxBehaviorEvent;
import org.apache.commons.codec.digest.DigestUtils;

@Named("usuariosController")
@SessionScoped
public class UsuariosController implements Serializable {

    @EJB
    private control.UsuariosFacade ejbFacade;
    @EJB
    private control.TiposusuarioFacade ejbFacade1;
    private List<Usuarios> items = null;
    private List<Usuarios> items2 = null;
    private Usuarios selected;
    private String mensaje;
    private String mensaje2;

    public String getMensaje2() {
        return mensaje2;
    }

    public void setMensaje2(String mensaje2) {
        this.mensaje2 = mensaje2;
    }
       

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public Tiposusuario getCliente() {

        Tiposusuario cliente = ejbFacade1.usuarioCliente();

        return cliente;
    }

    public List<Usuarios> getItems2() {
        if (items2 == null) {
            items2 = ejbFacade.listaEliminados();
        }
        return items2;
    }

    public void setItems2(List<Usuarios> items2) {
        this.items2 = items2;
    }

    
    
    public UsuariosController() {
        selected = new Usuarios();
    }

    public Usuarios getSelected() {
        return selected;
    }

    public void setSelected(Usuarios selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private UsuariosFacade getFacade() {
        return ejbFacade;
    }
    
    
    
    public void comprobarUsername(AjaxBehaviorEvent event){
        System.out.println("Nombre de usuario ingresado: " + selected.getUsername()); 
        if(ejbFacade.usernames(selected.getUsername()).equals("ok")){
            mensaje= " ";
        }else{            
            mensaje="El nombre de usuario ya existe";
        }
    }
    public void comprobarEmail(AjaxBehaviorEvent event){
        System.out.println("Email ingresado: " + selected.getEmail()); 
        if(ejbFacade.email(selected.getEmail()).equals("ok")){
            mensaje2= " ";
        }else{            
            mensaje2="El email ya fue registrado";
        }
    }

    public Usuarios prepareCreate() {
        selected = new Usuarios();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        
        String pass= selected.getPassword();
        String pass_encrip = DigestUtils.sha1Hex(pass);
        selected.setPassword(pass_encrip);
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void registroParcial() {
        selected.setStatus(1);
        selected.setRfc(" ");
        selected.setCurp(" ");
        selected.setTelefono(0);
        selected.setTelefonoTxt(" ");
        selected.setIdTipoUsu(getCliente());
        
        
        String pass= selected.getPassword();
        String pass_encrip = DigestUtils.sha1Hex(pass);
        selected.setPassword(pass_encrip);
        
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("UsuariosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    

    public void update() {
        String pass= selected.getPassword();
        String pass_encrip = DigestUtils.sha1Hex(pass);
        selected.setPassword(pass_encrip);
        
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuariosUpdated"));
        items = null;
        items2 = null;
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("UsuariosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    
            items2 = null;// Invalidate list of items to trigger re-query.
        }
    }

    public List<Usuarios> getItems() {
        if (items == null) {
            items = ejbFacade.listaActivos();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Usuarios getUsuarios(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Usuarios> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Usuarios> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Usuarios.class)
    public static class UsuariosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            UsuariosController controller = (UsuariosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "usuariosController");
            return controller.getUsuarios(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Usuarios) {
                Usuarios o = (Usuarios) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Usuarios.class.getName()});
                return null;
            }
        }

    }

}
