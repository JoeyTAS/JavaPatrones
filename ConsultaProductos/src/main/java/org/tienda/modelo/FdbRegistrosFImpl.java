
package org.tienda.modelo;

import org.tienda.interfaces.IBoletasGen;
import org.tienda.interfaces.IConsultasF;
import org.tienda.interfaces.IFdb;
import org.tienda.interfaces.IRegistroClienteDB;
import org.tienda.interfaces.IRegistroF;


public class FdbRegistrosFImpl implements IFdb {

    @Override
    public IConsultasF getIContultasF() {
      return null;
    }

    @Override
    public IRegistroF getIRegistroF() {
        return new RegistroFImpl();
        
    }

    @Override
    public IRegistroClienteDB getIRegistroClienteDB() {
        return null;
    }
    @Override
    public IBoletasGen getIBoletasGen() {
        return null;
    }
}
