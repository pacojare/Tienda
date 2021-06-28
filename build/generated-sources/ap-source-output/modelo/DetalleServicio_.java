package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Servicios;
import modelo.SeviciosOfrecidos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T19:58:18")
@StaticMetamodel(DetalleServicio.class)
public class DetalleServicio_ { 

    public static volatile SingularAttribute<DetalleServicio, SeviciosOfrecidos> idServicioOfrecido;
    public static volatile SingularAttribute<DetalleServicio, Double> precio;
    public static volatile SingularAttribute<DetalleServicio, Integer> id;
    public static volatile SingularAttribute<DetalleServicio, Servicios> idServicio;
    public static volatile SingularAttribute<DetalleServicio, Integer> status;

}