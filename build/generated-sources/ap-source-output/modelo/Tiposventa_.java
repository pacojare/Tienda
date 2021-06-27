package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(Tiposventa.class)
public class Tiposventa_ { 

    public static volatile CollectionAttribute<Tiposventa, Productos> productosCollection;
    public static volatile SingularAttribute<Tiposventa, Integer> id;
    public static volatile SingularAttribute<Tiposventa, String> nombre;
    public static volatile SingularAttribute<Tiposventa, Integer> status;

}