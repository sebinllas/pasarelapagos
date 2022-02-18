/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Clientes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author sebin
 */
@Stateless
public class ClienteSessionBean implements ClienteSessionBeanLocal {

    @PersistenceContext(unitName = "com.udea_pasarelapago-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Clientes> getAllClientes() {
        Query query = em.createNamedQuery("Clientes.findAll");
        return query.getResultList();
    }

    @Override
    public Clientes updateCliente(Clientes cliente) {
        return em.merge(cliente);
    }

    @Override
    public void newCliente(Clientes cliente) {
        Query query = em.createNativeQuery("INSERT INTO clientes "
                + "(identificacion, nombre,email, telefono, direccion, "
                + "ciudad, tarjeta_credito) VALUES (:1,:2,:3,:4,:5,:5,:6)");
        query.setParameter("1", cliente.getIdentificacion());
        query.setParameter("2", cliente.getNombre());
        query.setParameter("3", cliente.getEmail());
        query.setParameter("4", cliente.getTelefono());
        query.setParameter("5", cliente.getDireccion());
        query.setParameter("6", cliente.getCiudad());
        query.setParameter("7", cliente.getTarjetaCredito());
        query.executeUpdate();
        System.out.println(cliente.toString());

    }

}
