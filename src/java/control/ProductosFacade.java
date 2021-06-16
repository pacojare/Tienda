/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Productos;

/**
 *
 * @author fjasso
 */
@Stateless
public class ProductosFacade extends AbstractFacade<Productos> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductosFacade() {
        super(Productos.class);
    }
    
    public List<Productos> listaActivos(){
        Query consulta = em.createNamedQuery("Productos.findActivos",Productos.class);
        List<Productos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Productos> listaEliminados(){
        Query consulta = em.createNamedQuery("Productos.findEliminados",Productos.class);
        List<Productos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public String Incrementar(int idprod, int cant){
        Query consulta = em.createNamedQuery("Productos.Incrementar", Productos.class)
                .setParameter("id_p", idprod)
                .setParameter("cant_p", cant);
        consulta.executeUpdate();
        return "ok";
    }
    
    public String Decrementar(int idprod, int cant){
        Query consulta = em.createNamedQuery("Productos.Decrementar", Productos.class)
                .setParameter("id_p", idprod)
                .setParameter("cant_p", cant);
        consulta.executeUpdate();
        return "ok";
    }
    
}
