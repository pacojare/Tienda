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
import modelo.Categorias;
import modelo.Categorias;

/**
 *
 * @author fjasso
 */
@Stateless
public class CategoriasFacade extends AbstractFacade<Categorias> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasFacade() {
        super(Categorias.class);
    }
    
    public List<Categorias> listaActivos(){
        Query consulta = em.createNamedQuery("Categorias.findActivos",Categorias.class);
        List<Categorias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Categorias> listaEliminados(){
        Query consulta = em.createNamedQuery("Categorias.findEliminados",Categorias.class);
        List<Categorias> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
}
