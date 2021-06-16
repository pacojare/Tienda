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
import modelo.Servicios;
import modelo.Servicios;

/**
 *
 * @author fjasso
 */
@Stateless
public class ServiciosFacade extends AbstractFacade<Servicios> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciosFacade() {
        super(Servicios.class);
    }
    
    public List<Servicios> listaActivos(){
        Query consulta = em.createNamedQuery("Servicios.findActivos",Servicios.class);
        List<Servicios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Servicios> listaEliminados(){
        Query consulta = em.createNamedQuery("Servicios.findEliminados",Servicios.class);
        List<Servicios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
