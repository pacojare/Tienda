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
import modelo.Municipios;
import modelo.Paises;

/**
 *
 * @author fjasso
 */
@Stateless
public class MunicipiosFacade extends AbstractFacade<Municipios> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MunicipiosFacade() {
        super(Municipios.class);
    }
    
    public List<Municipios> listaActivos(){
        Query consulta = em.createNamedQuery("Municipios.findActivos",Municipios.class);
        List<Municipios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Municipios> listaEliminados(){
        Query consulta = em.createNamedQuery("Municipios.findEliminados",Municipios.class);
        List<Municipios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    
    public List<Municipios> ObtenerMunicipios(int id_entidad){
        Query consulta = em.createNamedQuery("Municipios.findMunicipios_x_pais", Municipios.class)
                .setParameter("id_e", id_entidad);
        List<Municipios> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return lista;
        }else{
            return null;
        }
    }
}
