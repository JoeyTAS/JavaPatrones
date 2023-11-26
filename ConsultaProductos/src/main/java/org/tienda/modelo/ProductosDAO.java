
package org.tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.tienda.conectar.CConectarDB;
import org.tienda.entidad.Boleta;
import org.tienda.entidad.Cliente;
import org.tienda.entidad.Productos;
import org.tienda.interfaces.IAccesoDB;


public class ProductosDAO implements IAccesoDB{
    PreparedStatement ps;
    ResultSet rs;
    int r;

   @Override
public List<Productos> ListarProductos() {
    String sql = "SELECT a.ID_PRODUCTO, a.P_NOMBRE, a.P_STOCK, a.P_PRECIO "
            + "FROM PRODUCTOSJL a";
    List<Productos> ListaProductos = new ArrayList<>();
    try {
        Connection conectar;
        conectar = CConectarDB.getConecion();
        
        ps = conectar.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Productos productos = new Productos();
            productos.setIdProducto(rs.getInt("ID_PRODUCTO"));
            productos.setpNombre(rs.getString("P_NOMBRE"));
            productos.setpPrecio(rs.getDouble("P_PRECIO"));
            productos.setpStock(rs.getInt("P_STOCK"));
        
            ListaProductos.add(productos);
        }
    } catch (Exception e) {
        e.printStackTrace(); 
    }
    return ListaProductos;
}

    @Override
    public List<Cliente> ListarClientes() {
         String sql = "SELECT a.ID_CLIENTES, a.C_NOMBRE, a.C_COMPRAS "
            + "FROM CLIENTESJL a" ;
    List<Cliente> ListarClientes = new ArrayList<>();
    try {
        Connection conectar;
        conectar = CConectarDB.getConecion();
      
        ps = conectar.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setIdCliente(rs.getInt("ID_CLIENTES"));
            cliente.setCnombre(rs.getString("C_NOMBRE"));
            cliente.setCcompras(rs.getInt("C_COMPRAS"));
           
            ListarClientes.add(cliente);
        }
    } catch (Exception e) {
        e.printStackTrace(); // Imprimir la traza de la excepción
    }
    return ListarClientes;
        
    }

    @Override
    public int RegistrarClientes(Cliente cliente) {
         String sql = "INSERT INTO CLIENTESJL (C_NOMBRE, C_COMPRAS)"
                + " VALUES (?,?) ";
        try {
            Connection conectar;
            conectar = CConectarDB.getConecion();
            ps = conectar.prepareStatement(sql);
            ps.setString(1, cliente.getCnombre());
            ps.setInt(2, cliente.getCcompras());
           
            r = ps.executeUpdate();
            conectar.commit();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public int RegistrarBoletas(Boleta boleta) {
      String sql = "INSERT INTO BOLETAS (ID_CLIENTEB, ID_PRODUCTOB, CANTIDAD, TOTAL)"
                + " VALUES (?,?,?,?) ";
        try {
            Connection conectar;
            conectar = CConectarDB.getConecion();
            ps = conectar.prepareStatement(sql);
            ps.setInt(1, boleta.getIdClienteb());
            ps.setInt(2, boleta.getIdProductob());
            ps.setInt(3, boleta.getCantidadb());
            ps.setDouble(4, boleta.getTotalb());
           
            r = ps.executeUpdate();
            conectar.commit();
        } catch (Exception e) {
        }
        return r;
    }
    
}
