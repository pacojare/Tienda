package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Direcciones;
import modelo.Paqueterias;
import modelo.Usuarios;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(Envios.class)
public class Envios_ { 

    public static volatile SingularAttribute<Envios, Direcciones> idDireccion;
    public static volatile SingularAttribute<Envios, Integer> numeroGuia;
    public static volatile SingularAttribute<Envios, Date> fechaEnvio;
    public static volatile SingularAttribute<Envios, Usuarios> idCliente;
    public static volatile SingularAttribute<Envios, Paqueterias> idPaqueteria;
    public static volatile SingularAttribute<Envios, Integer> id;
    public static volatile SingularAttribute<Envios, Date> fechaRecepcion;
    public static volatile SingularAttribute<Envios, Integer> status;
    public static volatile SingularAttribute<Envios, Ventas> idVenta;

}