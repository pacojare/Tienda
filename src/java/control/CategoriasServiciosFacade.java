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
import modelo.CategoriasServicios;
import modelo.CategoriasServicios;

/**
 *
 * @author fjasso
 */
@Stateless
public class CategoriasServiciosFacade extends AbstractFacade<CategoriasServicios> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriasServiciosFacade() {
        super(CategoriasServicios.class);
    }
    
    public List<CategoriasServicios> listaActivos(){
        Query consulta = em.createNamedQuery("CategoriasServicios.findActivos",CategoriasServicios.class);
        List<CategoriasServicios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<CategoriasServicios> listaEliminados(){
        Query consulta = em.createNamedQuery("CategoriasServicios.findEliminados",CategoriasServicios.class);
        List<CategoriasServicios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
