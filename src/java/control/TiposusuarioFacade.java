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
import modelo.Paises;
import modelo.Tiposusuario;

/**
 *
 * @author fjasso
 */
@Stateless
public class TiposusuarioFacade extends AbstractFacade<Tiposusuario> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposusuarioFacade() {
        super(Tiposusuario.class);
    }
    
    public List<Tiposusuario> listaActivos(){
        Query consulta = em.createNamedQuery("Tiposusuario.findActivos",Tiposusuario.class);
        List<Tiposusuario> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
    public List<Tiposusuario> listaEliminados(){
        Query consulta = em.createNamedQuery("Tiposusuario.findEliminados",Tiposusuario.class);
        List<Tiposusuario> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;                
    }
    
}
