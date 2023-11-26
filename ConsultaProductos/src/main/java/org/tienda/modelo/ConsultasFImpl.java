package org.tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import org.tienda.conectar.CConectarDB;
import org.tienda.entidad.Productos;
import org.tienda.factory.Factoria;
import org.tienda.interfaces.IAccesoDB;
import org.tienda.interfaces.IConsultasF;

public class ConsultasFImpl implements IConsultasF {

    @Override
    public void ConsultasDB() {
        Scanner sc = new Scanner(System.in);
        IAccesoDB factory = Factoria.getFactoria();
        List<Productos> listaProductos = factory.ListarProductos();
        System.out.println("*******************************************");
        System.out.print("Ingrese Id del producto: ");
        int busquedaPro = sc.nextInt();
        System.out.println("*******************************************");
        boolean productoEncontrado = false;

        try {
            for (Productos producto : listaProductos) {
                if (producto.getIdProducto() == busquedaPro) {
                    System.out.println("ID          : " + producto.getIdProducto());
                    System.out.println("NOMBRE      : " + producto.getpNombre());
                    System.out.println("PRECIO      : " + producto.getpPrecio());
                    System.out.println("STOCK       : " + producto.getpStock());
                    System.out.println("*******************************************");

                    System.out.print("Cantidad del producto:");
                    int Ctn = sc.nextInt();
                    System.out.println("*******************************************");
                    // Verificar si hay suficiente stock
                    if (Ctn <= producto.getpStock()) {
                        // Actualizar el stock 
                        producto.setpStock(producto.getpStock() - Ctn);
                        double total = producto.getpPrecio() * Ctn;

                        // Actualizar el stock en la base de datos
                        actualizarStockBD(producto.getIdProducto(), producto.getpStock());
         
                        System.out.println("Total a pagar: " + total);
                        System.out.println("*******************************************");
                        productoEncontrado = true;
                        
                        
                    } else {
                        System.out.println("No hay suficiente stock para la cantidad solicitada.");
                        System.out.println("*******************************************");
                    }
                    
                }
            }

            if (!productoEncontrado) {
                System.out.println("Producto no encontrado.");
                System.out.println("*******************************************");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void actualizarStockBD(int idProducto, int nuevoStock) {
        String sql = "UPDATE PRODUCTOSJL SET P_STOCK = ? WHERE ID_PRODUCTO = ?";

        try (Connection conectar = CConectarDB.getConecion(); PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setInt(1, nuevoStock);
            ps.setInt(2, idProducto);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
