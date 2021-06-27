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
import modelo.Usuarios;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author fjasso
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "TiendaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios Acceder(String usu, String pass){
        String pass_encrip = DigestUtils.sha1Hex(pass);
        Query consulta = em.createNamedQuery("Usuarios.Acceder",Usuarios.class)
                .setParameter("usu1", usu)
                .setParameter("pass1", pass_encrip);
        List<Usuarios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista.get(0);
        else
            return null;
            
    }
    
    public List<Usuarios> listaActivos(){
        Query consulta = em.createNamedQuery("Usuarios.findActivos",Usuarios.class);
        List<Usuarios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public List<Usuarios> listaEliminados(){
        Query consulta = em.createNamedQuery("Usuarios.findEliminados",Usuarios.class);
        List<Usuarios> lista = consulta.getResultList();
        if(!lista.isEmpty())
            return lista;
        else
            return null;
                
    }
    
    public String usernames(String usu){
        Query consulta =em.createNamedQuery("Usuarios.Username",Usuarios.class).setParameter("usu1", usu);
        List<Usuarios> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return "no";            
        }else{
            return "ok";
        }
    }
    public String email(String email){
        Query consulta =em.createNamedQuery("Usuarios.Email",Usuarios.class).setParameter("email", email);
        List<Usuarios> lista = consulta.getResultList();
        if(!lista.isEmpty()){
            return "no";            
        }else{
            return "ok";
        }
    }
    
}
