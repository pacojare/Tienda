package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compras;
import modelo.Municipios;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(Proveedores.class)
public class Proveedores_ { 

    public static volatile SingularAttribute<Proveedores, String> contacto;
    public static volatile CollectionAttribute<Proveedores, Compras> comprasCollection;
    public static volatile SingularAttribute<Proveedores, String> direccion;
    public static volatile CollectionAttribute<Proveedores, Productos> productosCollection;
    public static volatile SingularAttribute<Proveedores, Municipios> idMunicipio;
    public static volatile SingularAttribute<Proveedores, String> nombre;
    public static volatile SingularAttribute<Proveedores, Integer> cp;
    public static volatile SingularAttribute<Proveedores, String> rfc;
    public static volatile SingularAttribute<Proveedores, String> colonia;
    public static volatile SingularAttribute<Proveedores, String> razonSocial;
    public static volatile SingularAttribute<Proveedores, Integer> id;
    public static volatile SingularAttribute<Proveedores, String> telefono;
    public static volatile SingularAttribute<Proveedores, String> email;
    public static volatile SingularAttribute<Proveedores, Integer> status;

}