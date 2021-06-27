package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.DetalleServicio;
import modelo.Tipospago;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(Servicios.class)
public class Servicios_ { 

    public static volatile SingularAttribute<Servicios, Double> total;
    public static volatile SingularAttribute<Servicios, Usuarios> idCliente;
    public static volatile SingularAttribute<Servicios, Tipospago> idTipoPago;
    public static volatile SingularAttribute<Servicios, Date> fechaInicio;
    public static volatile SingularAttribute<Servicios, Usuarios> idEmpleado;
    public static volatile SingularAttribute<Servicios, Integer> id;
    public static volatile CollectionAttribute<Servicios, DetalleServicio> detalleServicioCollection;
    public static volatile SingularAttribute<Servicios, Date> fechaFin;
    public static volatile SingularAttribute<Servicios, Integer> status;

}