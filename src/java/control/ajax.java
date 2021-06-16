/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.event.AjaxBehaviorEvent;
import modelo.Productos;

/**
 *
 * @author fjasso
 */
@Named(value = "ajax")
@SessionScoped
public class ajax implements Serializable {
    
    @EJB
    private control.ProductosFacade ejbFacade;
    
    private Productos idProducto;
    private int cantidad;
    private String mensaje;

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
        
    /**
     * Creates a new instance of ajax
     */
    public ajax() {
    }
    
    public void Incrementa(AjaxBehaviorEvent event){
        System.out.println("ID_PRODUCTO:" + idProducto.getId());
        System.out.println("Cantidad: " + cantidad);
        //Métodos a la base de datos
        if(ejbFacade.Incrementar(idProducto.getId(), cantidad).equals("ok")){
            mensaje = "Producto Incrementado Correctamente";            
        }else{
            mensaje = "Error al Incrementar";            
        }
        
    }
    
    public void Decrementa(AjaxBehaviorEvent event){
        System.out.println("ID_PRODUCTO:" + idProducto.getNombre());
        System.out.println("Cantidad: " + cantidad);
        //Métodos a la base de datos
        if(ejbFacade.Decrementar(idProducto.getId(), cantidad).equals("ok")){
            mensaje = "Producto Decrementado Correctamente";            
        }else{
            mensaje = "Error al Decrementar";            
        }        
    }
    
}
