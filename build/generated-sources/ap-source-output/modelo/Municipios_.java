package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Direcciones;
import modelo.Entidades;
import modelo.Proveedores;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T19:58:18")
@StaticMetamodel(Municipios.class)
public class Municipios_ { 

    public static volatile SingularAttribute<Municipios, Entidades> idEntidad;
    public static volatile CollectionAttribute<Municipios, Direcciones> direccionesCollection;
    public static volatile CollectionAttribute<Municipios, Proveedores> proveedoresCollection;
    public static volatile SingularAttribute<Municipios, Integer> id;
    public static volatile SingularAttribute<Municipios, String> nombre;
    public static volatile SingularAttribute<Municipios, Integer> status;

}