
package org.tienda.entidad;


public class Productos {
    
    private Integer idProducto;
    private String pNombre;
    private Integer pStock;
    private double pPrecio;

    public Productos() {
    }

    public Productos(Integer idProducto, String pNombre, Integer pStock, double pPrecio) {
        this.idProducto = idProducto;
        this.pNombre = pNombre;
        this.pStock = pStock;
        this.pPrecio = pPrecio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public Integer getpStock() {
        return pStock;
    }

    public void setpStock(Integer pStock) {
        this.pStock = pStock;
    }

    public double getpPrecio() {
        return pPrecio;
    }

    public void setpPrecio(double pPrecio) {
        this.pPrecio = pPrecio;
    }

    
}
