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
import modelo.Entidades;
import modelo.Paises;

/**
 *
 * @author fjasso
 */
@Stateless
public class EntidadesFacade extends AbstractFacade<Entidades> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntidadesFacade() {
        super(Entidades.class);
    }
    
    public List<Entidades> listaActivos(){
        Query consulta = em.createNamedQuery("Entidades.findActivos",Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Entidades> listaEliminados(){
        Query consulta = em.createNamedQuery("Entidades.findEliminados",Entidades.class);
        List<Entidades> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Entidades> ObtenerEntidades(int id_pais){
        Query consulta = em.createNamedQuery("Entidades.findEntidades_x_pais", Entidades.class)
                .setParameter("id_p", id_pais);
        List<Entidades> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }
    
}
