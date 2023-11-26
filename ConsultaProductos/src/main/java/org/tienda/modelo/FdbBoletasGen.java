/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.tienda.modelo;

import org.tienda.interfaces.IBoletasGen;
import org.tienda.interfaces.IConsultasF;
import org.tienda.interfaces.IFdb;
import org.tienda.interfaces.IRegistroClienteDB;
import org.tienda.interfaces.IRegistroF;

/**
 *
 * @author joel
 */
public class FdbBoletasGen implements IFdb {
    
     @Override
    public IConsultasF getIContultasF() {
        return new ConsultasFImpl();
        
        
    }

    @Override
    public IRegistroF getIRegistroF() {
        return null;
      
    }

    @Override
    public IRegistroClienteDB getIRegistroClienteDB() {
        return null;
    }

    @Override
    public IBoletasGen getIBoletasGen() {
        return new BoletasGenImpl();
    }
    
}
