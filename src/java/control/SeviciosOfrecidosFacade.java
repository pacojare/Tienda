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
import modelo.SeviciosOfrecidos;
import modelo.SeviciosOfrecidos;

/**
 *
 * @author fjasso
 */
@Stateless
public class SeviciosOfrecidosFacade extends AbstractFacade<SeviciosOfrecidos> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeviciosOfrecidosFacade() {
        super(SeviciosOfrecidos.class);
    }
    
    public List<SeviciosOfrecidos> listaActivos(){
        Query consulta = em.createNamedQuery("SeviciosOfrecidos.findActivos",SeviciosOfrecidos.class);
        List<SeviciosOfrecidos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<SeviciosOfrecidos> listaEliminados(){
        Query consulta = em.createNamedQuery("SeviciosOfrecidos.findEliminados",SeviciosOfrecidos.class);
        List<SeviciosOfrecidos> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
