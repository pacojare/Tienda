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
import modelo.DetalleVenta;
import modelo.DetalleVenta;

/**
 *
 * @author fjasso
 */
@Stateless
public class DetalleVentaFacade extends AbstractFacade<DetalleVenta> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaFacade() {
        super(DetalleVenta.class);
    }
    
    public List<DetalleVenta> listaActivos(){
        Query consulta = em.createNamedQuery("DetalleVenta.findActivos",DetalleVenta.class);
        List<DetalleVenta> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<DetalleVenta> listaEliminados(){
        Query consulta = em.createNamedQuery("DetalleVenta.findEliminados",DetalleVenta.class);
        List<DetalleVenta> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
