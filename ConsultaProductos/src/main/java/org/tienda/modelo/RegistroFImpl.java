/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.tienda.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Scanner;
import org.tienda.conectar.CConectarDB;
import org.tienda.entidad.Cliente;
import org.tienda.factory.Factoria;
import org.tienda.interfaces.IAccesoDB;
import org.tienda.interfaces.IRegistroF;

/**
 *
 * @author joel
 */
public class RegistroFImpl implements IRegistroF {

    @Override
    public void RegistroDB() {
         Scanner sc = new Scanner(System.in);
        IAccesoDB factory = Factoria.getFactoria();
        List<Cliente> listaClientes = factory.ListarClientes();

        System.out.print("Ingrese ID del cliente: ");
        int idClienteBuscado = sc.nextInt();
        System.out.println("");
        boolean clienteEncontrado = false;

        try {
            for (Cliente cliente : listaClientes) {
                if (cliente.getIdCliente() == idClienteBuscado) {
                    System.out.println("ID          : " + cliente.getIdCliente());
                    System.out.println("NOMBRE      : " + cliente.getCnombre());
                    System.out.println("NRO COMPRAS : " + cliente.getCcompras());
                    System.out.println("***************************************************");

                    System.out.print("Cantidad de compras:");
                    int cantidadCompras = sc.nextInt();
                    System.out.println("");
                    // Actualizar el número de compras 
                    cliente.setCcompras(cliente.getCcompras() + cantidadCompras);

                    // Actualizar el número de compras en la base de datos
                    actualizarComprasBD(cliente.getIdCliente(), cliente.getCcompras());
                    System.out.println("Total de productos comprados: " + cliente.getCcompras());
           clienteEncontrado = true;
                    break; 
                }
            }

            if (!clienteEncontrado) {
                System.out.println("************** Cliente no encontrado **************");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private static void actualizarComprasBD(int idCliente, int nuevasCompras) {
        String sql = "UPDATE CLIENTESJL SET C_COMPRAS = ? WHERE ID_CLIENTES = ?";
        
        try (Connection conectar = CConectarDB.getConecion();
             PreparedStatement ps = conectar.prepareStatement(sql)) {

            ps.setInt(1, nuevasCompras);
            ps.setInt(2, idCliente);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}