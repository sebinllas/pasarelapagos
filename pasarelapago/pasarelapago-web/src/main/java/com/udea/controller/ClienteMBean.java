/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.Clientes;
import com.udea.session.ClienteSessionBeanLocal;
import com.udea.session.TarjetaSessionBeanLocal;
import com.udea.session.TransaccionSessionBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

/**
 *
 * @author sebin
 */
@Named(value = "clienteMBean")
@SessionScoped
public class ClienteMBean implements Serializable {


    /**
     * @EJB private TransaccionSessionBeanLocal transaccionSessionBean;
     *
     * @EJB private TarjetaSessionBeanLocal tarjetaSessionBean;*
     */
    @EJB
    private com.udea.session.ClienteSessionBeanLocal clienteSessionBean;
    

    /**
     * Creates a new instance of ClienteMBean
     */
    private Clientes customer; //para mostrar, actualizar o insertar en el formulario
    private List<Clientes> customers; //para visualizar en la tabla

    //private Department department;
    @PostConstruct
    public void init() {
        customer = new Clientes();
    }

    public ClienteMBean() {
        this.init();
    }

    public List<Clientes> getCustomers() {
        if ((customers == null) || (customers.isEmpty())) {
            refresh();
        }
        return customers;
    }
//Retorna el detalle de cada cliente en el formulario.

    public Clientes getDetails() {
        if (customer == null) {
            return new Clientes();
        }
        return customer;
    }

    public String showDetails(Clientes customer) {
        this.customer = customer;
        return "DETAILS";
    }

    public String update() {
        System.out.println("###UPDATE###");
        customer = clienteSessionBean.updateCliente(customer);
        return "SAVED";
    }

    public String newCliente() {
        System.out.println("###NEW###");
        clienteSessionBean.newCliente(customer);
        return "INSERTED";
    }

    public String list() {
        System.out.println("###LIST###");
        return "LIST";
    }

    private void refresh() {
        customers = clienteSessionBean.getAllClientes();
    }

//Para cargar correctamente los combobox del formulario Details
    /**
     * public javax.faces.model.SelectItem[] getDiscountCodes() { SelectItem[]
     * options = null; List<DiscountCode> discountCodes =
     * discountCodeManager.getDiscountCodes(); if (discountCodes != null &&
     * discountCodes.size() > 0) { int i = 0; options = new
     * SelectItem[discountCodes.size()]; for (DiscountCode dc : discountCodes) {
     * options[i++] = new SelectItem(dc.getDiscountCode(), dc.getDiscountCode()
     * + " (" + dc.getRate() + "%)"); } } return options; }
     *
     * public javax.faces.model.SelectItem[] getZipCodes() { SelectItem[]
     * options = null; List<MicroMarket> zipCodes =
     * zipCodeManager.getZipCodes(); if (zipCodes != null && zipCodes.size() >
     * 0) { int i = 0; options = new SelectItem[zipCodes.size()]; for
     * (MicroMarket dc : zipCodes) { options[i++] = new
     * SelectItem(dc.getZipCode(), dc.getZipCode()); } } return options; }
     */
}
