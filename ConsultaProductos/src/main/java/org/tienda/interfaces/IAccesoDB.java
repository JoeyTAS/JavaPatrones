
package org.tienda.interfaces;

import java.util.List;
import org.tienda.entidad.Boleta;
import org.tienda.entidad.Cliente;
import org.tienda.entidad.Productos;


public interface IAccesoDB {
     public List<Productos> ListarProductos();
    public List<Cliente> ListarClientes();
    public int RegistrarClientes(Cliente cliente);
    public int RegistrarBoletas(Boleta boleta);

    
}
