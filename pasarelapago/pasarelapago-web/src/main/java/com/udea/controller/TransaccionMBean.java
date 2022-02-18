/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.Transacciones;
import com.udea.session.ClienteSessionBeanLocal;
import com.udea.session.TarjetaSessionBeanLocal;
import com.udea.session.TransaccionSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author sebin
 */
@Named(value = "transaccionMBean")
@SessionScoped
public class TransaccionMBean implements Serializable {

    @EJB
    private TarjetaSessionBeanLocal tarjetaSessionBean;

    @EJB
    private ClienteSessionBeanLocal clienteSessionBean;

    @EJB
    private TransaccionSessionBeanLocal transaccionSessionBean;
    
    
    private Transacciones transaccion; //para mostrar, actualizar o insertar en el formulario
    private List<Transacciones> transacciones; //para visualizar en la tabla

    /**
     * Creates a new instance of TransaccionMBean
     */
    public TransaccionMBean() {
    }
    
        public List<Transacciones> getTransacciones() {
        if ((transacciones == null) || (transacciones.isEmpty())) {
            refresh();
        }
        return transacciones;
    }
//Retorna el detalle de cada cliente en el formulario.

    public Transacciones getDetails() {
        return transaccion;
    }

    public String showDetails(Transacciones t) {
        this.transaccion = t;
        return "DETAILS"; // Permite enlazar a CustomerDetails.xml
    }

    public String update() {
        System.out.println("###UPDATE###");
        transaccion = transaccionSessionBean.updateTransaccion(transaccion);
        return "SAVED"; // Para el caso navegacional
    }

    public String list() {
        System.out.println("###LIST###");
        return "LIST";
    }

    private void refresh() {
        transacciones = transaccionSessionBean.getAllTransacciones();
    }
    
    
}
