/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.Tarjetas;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sebin
 */
@Local
public interface TarjetaSessionBeanLocal {

    List<Tarjetas> getAllTarjetas();
    
}
