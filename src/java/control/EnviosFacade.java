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
import modelo.Envios;
import modelo.Envios;

/**
 *
 * @author fjasso
 */
@Stateless
public class EnviosFacade extends AbstractFacade<Envios> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EnviosFacade() {
        super(Envios.class);
    }
    
    public List<Envios> listaActivos(){
        Query consulta = em.createNamedQuery("Envios.findActivos",Envios.class);
        List<Envios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Envios> listaEliminados(){
        Query consulta = em.createNamedQuery("Envios.findEliminados",Envios.class);
        List<Envios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
