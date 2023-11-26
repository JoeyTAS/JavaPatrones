package org.tienda.modelo;


import java.util.Scanner;

import org.tienda.entidad.Cliente;
import org.tienda.factory.Factoria;
import org.tienda.interfaces.IAccesoDB;

import org.tienda.interfaces.IRegistroClienteDB;

public class RegistroClienteDBImpl implements IRegistroClienteDB {

    @Override
    public void RegistroClienteDB() {
        IAccesoDB factory = Factoria.getFactoria();

        System.out.println("*********** Registro de Cliente ***********");
        System.out.println("*******************************************");

        Scanner sc = new Scanner(System.in);
        // Obtener datos del usuario
        System.out.print("Ingrese nombre del cliente:");
        String nombreCliente = sc.nextLine();
        System.out.print("Ingrese número de compras:");

        int numeroCompras = sc.nextInt();
        System.out.println("");

        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setCnombre(nombreCliente);
        nuevoCliente.setCcompras(numeroCompras);

        factory.RegistrarClientes(nuevoCliente);

    }

}
