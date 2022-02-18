/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Clientes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebin
 */
@Local
public interface ClienteSessionBeanLocal {

    List<Clientes> getAllClientes();

    Clientes updateCliente(Clientes clientes);

    void newCliente(Clientes cliente);

    
}
