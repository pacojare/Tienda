package control;

import modelo.Fotosproductos;
import control.util.JsfUtil;
import control.util.JsfUtil.PersistAction;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.model.UploadedFile;

@Named("fotosproductosController")
@SessionScoped
public class FotosproductosController implements Serializable {

    @EJB
    private control.FotosproductosFacade ejbFacade;
    private List<Fotosproductos> items = null;
    private List<Fotosproductos> items2 = null;
    private Fotosproductos selected;

    private UploadedFile foto;
    private String aux;

    public UploadedFile getFoto() {
        return foto;
    }

    public void setFoto(UploadedFile foto) {
        this.foto = foto;
    }

    public String getAux() {
        return aux;
    }

    public void setAux(String aux) {
        this.aux = aux;
    }

    public List<Fotosproductos> getItems2() {
        if (items2 == null) {
            items2 = ejbFacade.listaEliminados();
        }
        return items2;
    }

    public void setItems2(List<Fotosproductos> items2) {
        this.items2 = items2;
    }

    public FotosproductosController() {
    }

    public Fotosproductos getSelected() {
        return selected;
    }

    public void setSelected(Fotosproductos selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private FotosproductosFacade getFacade() {
        return ejbFacade;
    }

    public Fotosproductos prepareCreate() {
        selected = new Fotosproductos();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        selected.setRuta(aux);
        selected.setStatus(1);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }
    //pasa subir y guardar el archivo en carpeta, pero la ruta en la BD

    public void AgregarFoto() {
        System.out.println("MIME TYPE " + getFoto().getContentType());
        System.out.println("TAMAÑO: " + getFoto().getSize());
        System.out.println("EXTENSIÓN PNG: " + getFoto().getFileName().endsWith(".png"));
        System.out.println("EXTENCIÓN JPG: " + getFoto().getFileName().endsWith(".jpg"));
        System.out.println("EXTENCIÓN PDF: " + getFoto().getFileName().endsWith(".pdf"));

        if (getFoto().getFileName().endsWith(".png") || getFoto().getFileName().endsWith(".jpg")
                || getFoto().getFileName().endsWith(".pdf")) {
            if (SubirArchivo()) {
                create();
                aux = "";
            } else {
                FacesMessage mensaje = new FacesMessage("No se pudo guardar el archivo.");
                FacesContext.getCurrentInstance().addMessage(null, mensaje);
            }
        } else {
            FacesMessage mensaje = new FacesMessage("El archivo NO es una imagen.");
            FacesContext.getCurrentInstance().addMessage(null, mensaje);
        }
    }

    public Boolean SubirArchivo() {
        try {
            if(getFoto().getFileName().endsWith(".png") || getFoto().getFileName().endsWith(".jpg")){
                aux = "resources/img_productos";                
            }
            if(getFoto().getFileName().endsWith(".pdf") ){
                aux = "resources/documentos";                
            }
            

            System.out.println("Ruta= " + aux);
            File archivo = new File(JsfUtil.getPath() + aux);
            if (!archivo.exists()) {
                archivo.mkdirs();
            }
            copiar_archivo(getFoto().getFileName(), getFoto().getInputstream());
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public void copiar_archivo(String nombre_archivo, InputStream in){
        
        try{
            aux = aux + "/" + nombre_archivo;
            System.out.println("se va a guardar");
            System.out.println("Ruta on: " + aux);
            System.out.println("Ruta real: " + JsfUtil.getPath() + aux);
            OutputStream out = new FileOutputStream(new File(JsfUtil.getPath() + aux));
            int read = 0;
            byte[] bytes = new byte[1024];
            while((read = in.read(bytes)) != -1){
                out.write(bytes, 0, read);
            }
            System.out.println("ya se guardo");
            aux = aux.substring(9);
            System.out.println("Ruta en la base: " + aux);
            in.close();
            out.flush();
            out.close();
        }catch(Exception e){
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("Error"));
            
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosUpdated"));
        items = null;
        items2 = null;
    }

    public void destroy() {
        selected.setStatus(0);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void restaurar() {
        selected.setStatus(1);
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("FotosproductosDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;
            items2 = null;// Invalidate list of items to trigger re-query.
        }
    }

    public List<Fotosproductos> getItems() {
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

    public Fotosproductos getFotosproductos(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Fotosproductos> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Fotosproductos> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Fotosproductos.class)
    public static class FotosproductosControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            FotosproductosController controller = (FotosproductosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "fotosproductosController");
            return controller.getFotosproductos(getKey(value));
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
            if (object instanceof Fotosproductos) {
                Fotosproductos o = (Fotosproductos) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Fotosproductos.class.getName()});
                return null;
            }
        }

    }

}
