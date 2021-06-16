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
import modelo.DetalleCompra;
import modelo.DetalleCompra;

/**
 *
 * @author fjasso
 */
@Stateless
public class DetalleCompraFacade extends AbstractFacade<DetalleCompra> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleCompraFacade() {
        super(DetalleCompra.class);
    }
    
    public List<DetalleCompra> listaActivos(){
        Query consulta = em.createNamedQuery("DetalleCompra.findActivos",DetalleCompra.class);
        List<DetalleCompra> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<DetalleCompra> listaEliminados(){
        Query consulta = em.createNamedQuery("DetalleCompra.findEliminados",DetalleCompra.class);
        List<DetalleCompra> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
