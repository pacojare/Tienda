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
import modelo.Paqueterias;
import modelo.Paqueterias;

/**
 *
 * @author fjasso
 */
@Stateless
public class PaqueteriasFacade extends AbstractFacade<Paqueterias> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PaqueteriasFacade() {
        super(Paqueterias.class);
    }
    
    public List<Paqueterias> listaActivos(){
        Query consulta = em.createNamedQuery("Paqueterias.findActivos",Paqueterias.class);
        List<Paqueterias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Paqueterias> listaEliminados(){
        Query consulta = em.createNamedQuery("Paqueterias.findEliminados",Paqueterias.class);
        List<Paqueterias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
}
