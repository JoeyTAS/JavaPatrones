
package org.tienda.entidad;


public class Cliente {
    private Integer IdCliente;
    private String Cnombre;
    private Integer Ccompras;
    private double pago;

    public Cliente() {
    }

    public Cliente(Integer IdCliente, String Cnombre, Integer Ccompras, double pago) {
        this.IdCliente = IdCliente;
        this.Cnombre = Cnombre;
        this.Ccompras = Ccompras;
        this.pago = pago;
    }

    public Integer getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Integer IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getCnombre() {
        return Cnombre;
    }

    public void setCnombre(String Cnombre) {
        this.Cnombre = Cnombre;
    }

    public Integer getCcompras() {
        return Ccompras;
    }

    public void setCcompras(Integer Ccompras) {
        this.Ccompras = Ccompras;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

  
    
    
}
