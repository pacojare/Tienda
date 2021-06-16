package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.CategoriasServicios;
import modelo.DetalleServicio;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-16T00:56:16")
@StaticMetamodel(SeviciosOfrecidos.class)
public class SeviciosOfrecidos_ { 

    public static volatile SingularAttribute<SeviciosOfrecidos, String> descripcion;
    public static volatile SingularAttribute<SeviciosOfrecidos, Double> precio;
    public static volatile SingularAttribute<SeviciosOfrecidos, CategoriasServicios> idCategoriaServicio;
    public static volatile SingularAttribute<SeviciosOfrecidos, Integer> id;
    public static volatile CollectionAttribute<SeviciosOfrecidos, DetalleServicio> detalleServicioCollection;
    public static volatile SingularAttribute<SeviciosOfrecidos, String> nombre;
    public static volatile SingularAttribute<SeviciosOfrecidos, Integer> status;

}