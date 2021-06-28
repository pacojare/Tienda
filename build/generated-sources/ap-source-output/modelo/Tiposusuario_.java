package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T19:58:18")
@StaticMetamodel(Tiposusuario.class)
public class Tiposusuario_ { 

    public static volatile CollectionAttribute<Tiposusuario, Usuarios> usuariosCollection;
    public static volatile SingularAttribute<Tiposusuario, Integer> id;
    public static volatile SingularAttribute<Tiposusuario, String> nombre;
    public static volatile SingularAttribute<Tiposusuario, Integer> nivel;
    public static volatile SingularAttribute<Tiposusuario, Integer> status;

}