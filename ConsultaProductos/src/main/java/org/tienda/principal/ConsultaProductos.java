package org.tienda.principal;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import org.tienda.abstracfactory.AbstractFdb;
import org.tienda.entidad.Cliente;
import org.tienda.entidad.Productos;
import org.tienda.factory.Factoria;
import org.tienda.interfaces.IAccesoDB;
import org.tienda.interfaces.IBoletasGen;
import org.tienda.interfaces.IConsultasF;
import org.tienda.interfaces.IDescuento;
import org.tienda.interfaces.IFdb;
import org.tienda.interfaces.IRegistroClienteDB;
import org.tienda.interfaces.IRegistroF;
import org.tienda.modelo.BoletasGenImpl;


public class ConsultaProductos {

    public static void main(String[] args) {
        
        IFdb consultas = AbstractFdb.getAbstrasctIFdb(1);
        IConsultasF con = consultas.getIContultasF();
        IFdb registro = AbstractFdb.getAbstrasctIFdb(2);
        IRegistroF resf = registro.getIRegistroF();
        IFdb boletasgen = AbstractFdb.getAbstrasctIFdb(4);
        IBoletasGen bole = boletasgen.getIBoletasGen();

        Scanner sc = new Scanner(System.in);

        Scanner loga = new Scanner(System.in);

        while (true) {
            IAccesoDB factory = Factoria.getFactoria();
            List<Cliente> listaCliente = factory.ListarClientes();

            System.out.println("******** Bienvenido a Comercio SAC ********");
            System.out.println("Registrar Cliente  [1] \nRealizar Boleta    [2]");
            System.out.println("*******************************************");
            System.out.print("[OPC]: ");
            int logT = loga.nextInt();

            switch (logT) {
                case 1:
                    IFdb RegistroCliente = AbstractFdb.getAbstrasctIFdb(3);
                    IRegistroClienteDB rcdb = RegistroCliente.getIRegistroClienteDB();
                    rcdb.RegistroClienteDB();

                    listaCliente = factory.ListarClientes();

                    System.out.println(" *********** Generar ID Cliente ***********");
                    System.out.print("Nombres del Cliente : ");
                    String nombreBus = sc.nextLine();
                    System.out.println("*******************************************");

                    for (Cliente cliente : listaCliente) {
                        if (cliente.getCnombre().trim().equals(nombreBus)) {
                            System.out.println("ID DEL CLIENTE GENERADO : " + cliente.getIdCliente());
                            System.out.println("*******************************************");
                            break;
                        }
                    }
                    break;
                case 2:

                    con.ConsultasDB();
                    resf.RegistroDB();
                    bole.GenerarBoletas();
                    
                    

                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione 1 o 2");
                    break;
            }

        }
    }
}
