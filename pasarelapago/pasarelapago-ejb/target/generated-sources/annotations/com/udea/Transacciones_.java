package com.udea;

import com.udea.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-02-03T08:49:53")
@StaticMetamodel(Transacciones.class)
public class Transacciones_ { 

    public static volatile SingularAttribute<Transacciones, Clientes> cliente;
    public static volatile SingularAttribute<Transacciones, Date> tiempo;
    public static volatile SingularAttribute<Transacciones, Integer> valor;
    public static volatile SingularAttribute<Transacciones, Integer> id;

}