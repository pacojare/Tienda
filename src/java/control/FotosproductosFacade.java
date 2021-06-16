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
import modelo.Fotosproductos;
import modelo.Fotosproductos;

/**
 *
 * @author fjasso
 */
@Stateless
public class FotosproductosFacade extends AbstractFacade<Fotosproductos> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FotosproductosFacade() {
        super(Fotosproductos.class);
    }
    
    public List<Fotosproductos> listaActivos(){
        Query consulta = em.createNamedQuery("Fotosproductos.findActivos",Fotosproductos.class);
        List<Fotosproductos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Fotosproductos> listaEliminados(){
        Query consulta = em.createNamedQuery("Fotosproductos.findEliminados",Fotosproductos.class);
        List<Fotosproductos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
