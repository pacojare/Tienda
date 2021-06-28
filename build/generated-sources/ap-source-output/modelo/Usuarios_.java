package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Compras;
import modelo.Direcciones;
import modelo.Envios;
import modelo.Servicios;
import modelo.Tiposusuario;
import modelo.Ventas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-06-27T19:58:18")
@StaticMetamodel(Usuarios.class)
public class Usuarios_ { 

    public static volatile SingularAttribute<Usuarios, Date> fechaNaci;
    public static volatile CollectionAttribute<Usuarios, Compras> comprasCollection;
    public static volatile CollectionAttribute<Usuarios, Direcciones> direccionesCollection;
    public static volatile CollectionAttribute<Usuarios, Envios> enviosCollection;
    public static volatile CollectionAttribute<Usuarios, Ventas> ventasCollection;
    public static volatile SingularAttribute<Usuarios, String> telefonoTxt;
    public static volatile SingularAttribute<Usuarios, String> nombre;
    public static volatile CollectionAttribute<Usuarios, Servicios> serviciosCollection1;
    public static volatile SingularAttribute<Usuarios, String> rfc;
    public static volatile CollectionAttribute<Usuarios, Ventas> ventasCollection1;
    public static volatile SingularAttribute<Usuarios, String> password;
    public static volatile SingularAttribute<Usuarios, Tiposusuario> idTipoUsu;
    public static volatile SingularAttribute<Usuarios, Integer> id;
    public static volatile SingularAttribute<Usuarios, String> apMat;
    public static volatile SingularAttribute<Usuarios, Integer> telefono;
    public static volatile SingularAttribute<Usuarios, String> curp;
    public static volatile SingularAttribute<Usuarios, String> email;
    public static volatile CollectionAttribute<Usuarios, Servicios> serviciosCollection;
    public static volatile SingularAttribute<Usuarios, String> apPat;
    public static volatile SingularAttribute<Usuarios, String> username;
    public static volatile SingularAttribute<Usuarios, Integer> status;

}