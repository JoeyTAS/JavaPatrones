/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.tienda.modelo;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.tienda.entidad.Cliente;
import org.tienda.entidad.Productos;
import org.tienda.factory.Factoria;
import org.tienda.interfaces.IAccesoDB;
import org.tienda.interfaces.IBoletasGen;

/**
 *
 * @author joel
 */
public class BoletasGenImpl implements IBoletasGen {

    @Override
    public void GenerarBoletas() {
        Date Hoy = new Date();

        Scanner sc = new Scanner(System.in);
        IAccesoDB factory = Factoria.getFactoria();
        List<Cliente> listaClientes = factory.ListarClientes();
        List<Productos> listaProductos = factory.ListarProductos();
        System.out.println("*******************************************");
        System.out.println("          Generador de boleta");
        System.out.println("*******************************************");
        System.out.print("Ingrese su id: ");
        int idClienteBuscado = sc.nextInt();
        System.out.println("");
        Cliente clienteSeleccionado = null;

// Buscar el cliente por ID
        for (Cliente cliente : listaClientes) {
            if (cliente.getIdCliente() == idClienteBuscado) {
                clienteSeleccionado = cliente;
                break;
            }
        }

        if (clienteSeleccionado != null) {
            System.out.print("Ingrese id del producto: ");
            int busquedaPro = sc.nextInt();
            System.out.println("");
            Productos productoSeleccionado = null;

            // Buscar el producto por ID
            for (Productos producto : listaProductos) {
                if (producto.getIdProducto() == busquedaPro) {
                    productoSeleccionado = producto;
                    break;
                }
            }

            if (productoSeleccionado != null) {
                System.out.print("Cantidad de productos: ");
                int cant = sc.nextInt();
                System.out.println("");
                double subtotal = productoSeleccionado.getpPrecio() * cant;
                double igv = subtotal * 0.18;
                double totalPagar = subtotal + igv;
                System.out.println("*******************************************");
                System.out.println("         Boleta Venta Comercio SAC");
                System.out.println("*******************************************");
                System.out.println("Nombre: " + clienteSeleccionado.getCnombre() + " ID: " + clienteSeleccionado.getIdCliente());
                System.out.println("Descripción: " + productoSeleccionado.getpNombre() + " ID: " + productoSeleccionado.getIdProducto() + " Precio: " + productoSeleccionado.getpPrecio());
                System.out.println("SubTotal: " + subtotal + " IGV: 18% " + " Total Pagar: " + totalPagar);
                System.out.println("La fecha de hoy: " + (new java.sql.Date(Hoy.getTime())));
                System.out.println("*******************************************");
            } else {
                System.out.println("Producto no encontrado.");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }

    }

}
