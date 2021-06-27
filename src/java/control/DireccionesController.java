package control;

import modelo.Direcciones;
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
import modelo.Entidades;
import modelo.Municipios;

@Named("direccionesController")
@SessionScoped
public class DireccionesController implements Serializable {

    @EJB
    private control.DireccionesFacade ejbFacade;
    private List<Direcciones> items = null;
    private List<Direcciones> items2 = null;
    private Direcciones selected;
    
    private List<Entidades> listEntidades;
    private List<Municipios> listMunicipios;
    
    @EJB
    private control.EntidadesFacade ejbFacade_entidades;
    
    @EJB
    private control.MunicipiosFacade ejbFacade_municipios;

    public List<Entidades> getListEntidades() {
        return listEntidades;
    }

    public void setListEntidades(List<Entidades> listEntidades) {
        this.listEntidades = listEntidades;
    }

    public List<Municipios> getListMunicipios() {
        return listMunicipios;
    }

    public void setListMunicipios(List<Municipios> listMunicipios) {
        this.listMunicipios = listMunicipios;
    }
    

    public List<Direcciones> getItems2() {
        if (items2 == null) {
            items2 = ejbFacade.listaEliminados();
        }
        return items2;
    }

    public void setItems2(List<Direcciones> items2) {
        this.items2 = items2;
    }
    
    

    public DireccionesController() {
    }

    public Direcciones getSelected() {
        return selected;
    }

    public void setSelected(Direcciones selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DireccionesFacade getFacade() {
        return ejbFacade;
    }

    public Direcciones prepareCreate() {
        selected = new Direcciones();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DireccionesCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DireccionesUpdated"));
        items = null;
        items2 = null;
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DireccionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    
    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DireccionesDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;
            items2 = null;// Invalidate list of items to trigger re-query.
        }
    }

    public List<Direcciones> getItems() {
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
    
    public void ObtenerEntidades(AjaxBehaviorEvent event){
        System.out.println("ID_PAIS Entidad = "+ selected.getIdPais().getId());
        listEntidades = ejbFacade_entidades.ObtenerEntidades(selected.getIdPais().getId());  
        System.out.println("Hola" + listEntidades);
        listMunicipios = ejbFacade_municipios.ObtenerMunicipios(0);                
    }
    
    public void ObtenerEntidades2(AjaxBehaviorEvent event){
        System.out.println("ID_PAIS Entidad = "+ selected.getIdPais().getId());
        listEntidades = ejbFacade_entidades.ObtenerEntidades(selected.getIdPais().getId());  
        System.out.println("Hola" + listEntidades);                        
    }
    
    public void ObtenerMunicipios(AjaxBehaviorEvent event){
        System.out.println("ID_PAIS = "+ selected.getIdEntidad().getId());
        listMunicipios = ejbFacade_municipios.ObtenerMunicipios(selected.getIdEntidad().getId());        
    }

    public Direcciones getDirecciones(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Direcciones> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Direcciones> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Direcciones.class)
    public static class DireccionesControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DireccionesController controller = (DireccionesController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "direccionesController");
            return controller.getDirecciones(getKey(value));
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
            if (object instanceof Direcciones) {
                Direcciones o = (Direcciones) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Direcciones.class.getName()});
                return null;
            }
        }

    }

}
