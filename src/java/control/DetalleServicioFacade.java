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
import modelo.DetalleServicio;
import modelo.DetalleServicio;

/**
 *
 * @author fjasso
 */
@Stateless
public class DetalleServicioFacade extends AbstractFacade<DetalleServicio> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleServicioFacade() {
        super(DetalleServicio.class);
    }
    
    public List<DetalleServicio> listaActivos(){
        Query consulta = em.createNamedQuery("DetalleServicio.findActivos",DetalleServicio.class);
        List<DetalleServicio> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<DetalleServicio> listaEliminados(){
        Query consulta = em.createNamedQuery("DetalleServicio.findEliminados",DetalleServicio.class);
        List<DetalleServicio> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
}
