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
import modelo.Direcciones;
import modelo.Direcciones;

/**
 *
 * @author fjasso
 */
@Stateless
public class DireccionesFacade extends AbstractFacade<Direcciones> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionesFacade() {
        super(Direcciones.class);
    }
    
    public List<Direcciones> listaActivos(){
        Query consulta = em.createNamedQuery("Direcciones.findActivos",Direcciones.class);
        List<Direcciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Direcciones> listaEliminados(){
        Query consulta = em.createNamedQuery("Direcciones.findEliminados",Direcciones.class);
        List<Direcciones> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
}
