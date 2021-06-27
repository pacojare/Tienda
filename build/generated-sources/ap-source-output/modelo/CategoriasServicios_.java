package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.SeviciosOfrecidos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(CategoriasServicios.class)
public class CategoriasServicios_ { 

    public static volatile CollectionAttribute<CategoriasServicios, SeviciosOfrecidos> seviciosOfrecidosCollection;
    public static volatile SingularAttribute<CategoriasServicios, Integer> id;
    public static volatile SingularAttribute<CategoriasServicios, String> nombre;
    public static volatile SingularAttribute<CategoriasServicios, Integer> status;

}