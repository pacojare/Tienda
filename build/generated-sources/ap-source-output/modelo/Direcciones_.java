package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Entidades;
import modelo.Envios;
import modelo.Municipios;
import modelo.Paises;
import modelo.Usuarios;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T15:34:56")
@StaticMetamodel(Direcciones.class)
public class Direcciones_ { 

    public static volatile SingularAttribute<Direcciones, Entidades> idEntidad;
    public static volatile SingularAttribute<Direcciones, Paises> idPais;
    public static volatile SingularAttribute<Direcciones, Usuarios> idUsuario;
    public static volatile SingularAttribute<Direcciones, String> direccion;
    public static volatile SingularAttribute<Direcciones, String> alias;
    public static volatile CollectionAttribute<Direcciones, Envios> enviosCollection;
    public static volatile SingularAttribute<Direcciones, Municipios> idMunicipio;
    public static volatile SingularAttribute<Direcciones, Integer> id;
    public static volatile SingularAttribute<Direcciones, Integer> cp;
    public static volatile SingularAttribute<Direcciones, String> colonia;
    public static volatile SingularAttribute<Direcciones, Integer> status;

}