package com.udea;

import com.udea.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-03T08:49:53")
@StaticMetamodel(Tarjetas.class)
public class Tarjetas_ { 

    public static volatile SingularAttribute<Tarjetas, String> numero;
    public static volatile SingularAttribute<Tarjetas, Integer> codigoSeguridad;
    public static volatile SingularAttribute<Tarjetas, Date> fechaVencimiento;
    public static volatile CollectionAttribute<Tarjetas, Clientes> clientesCollection;

}