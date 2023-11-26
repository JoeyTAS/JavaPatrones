
package org.tienda.factory;

import org.tienda.interfaces.IAccesoDB;
import org.tienda.modelo.ProductosDAO;


public class Factoria {
     public static IAccesoDB getFactoria(){
        return new ProductosDAO();
    }
    
}
  
