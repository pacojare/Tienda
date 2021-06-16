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
import modelo.Tiposventa;
import modelo.Tiposventa;

/**
 *
 * @author fjasso
 */
@Stateless
public class TiposventaFacade extends AbstractFacade<Tiposventa> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposventaFacade() {
        super(Tiposventa.class);
    }
    
    public List<Tiposventa> listaActivos(){
        Query consulta = em.createNamedQuery("Tiposventa.findActivos",Tiposventa.class);
        List<Tiposventa> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Tiposventa> listaEliminados(){
        Query consulta = em.createNamedQuery("Tiposventa.findEliminados",Tiposventa.class);
        List<Tiposventa> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
