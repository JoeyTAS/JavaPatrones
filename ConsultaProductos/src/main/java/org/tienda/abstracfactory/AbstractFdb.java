
package org.tienda.abstracfactory;

import org.tienda.interfaces.IFdb;
import org.tienda.modelo.FdbBoletasGen;
import org.tienda.modelo.FdbConsultasImpl;
import org.tienda.modelo.FdbRegistroClienteDB;
import org.tienda.modelo.FdbRegistrosFImpl;

public class AbstractFdb {
    
      public static IFdb getAbstrasctIFdb(int con){
        if(con == 1){
         return new FdbConsultasImpl();
        }
         if(con == 2){
         return new FdbRegistrosFImpl();
        }
         if(con == 3 ){
             return new FdbRegistroClienteDB();
         
         }
         if(con == 4 ){
             return new FdbBoletasGen();
         
         }
         
        return null;
    }
    
}
