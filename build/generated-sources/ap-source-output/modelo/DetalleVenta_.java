package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Productos;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T19:58:18")
@StaticMetamodel(DetalleVenta.class)
public class DetalleVenta_ { 

    public static volatile SingularAttribute<DetalleVenta, Double> precioCompra;
    public static volatile SingularAttribute<DetalleVenta, Integer> id;
    public static volatile SingularAttribute<DetalleVenta, Integer> cantidad;
    public static volatile SingularAttribute<DetalleVenta, Productos> idProducto;
    public static volatile SingularAttribute<DetalleVenta, Double> precioVenta;
    public static volatile SingularAttribute<DetalleVenta, Integer> status;
    public static volatile SingularAttribute<DetalleVenta, Ventas> idVenta;

}