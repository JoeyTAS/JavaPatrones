
package org.tienda.entidad;

public class Boleta {
    
    private Integer idBoletasb;
    private Integer idClienteb;
    private Integer idProductob;
    private Integer cantidadb;
    private double totalb;

    public Boleta() {
    }

    public Boleta(Integer idBoletasb, Integer idClienteb, Integer idProductob, Integer cantidadb, double totalb) {
        this.idBoletasb = idBoletasb;
        this.idClienteb = idClienteb;
        this.idProductob = idProductob;
        this.cantidadb = cantidadb;
        this.totalb = totalb;
    }

    public Integer getIdBoletasb() {
        return idBoletasb;
    }

    public void setIdBoletasb(Integer idBoletasb) {
        this.idBoletasb = idBoletasb;
    }

    public Integer getIdClienteb() {
        return idClienteb;
    }

    public void setIdClienteb(Integer idClienteb) {
        this.idClienteb = idClienteb;
    }

    public Integer getIdProductob() {
        return idProductob;
    }

    public void setIdProductob(Integer idProductob) {
        this.idProductob = idProductob;
    }

    public Integer getCantidadb() {
        return cantidadb;
    }

    public void setCantidadb(Integer cantidadb) {
        this.cantidadb = cantidadb;
    }

    public double getTotalb() {
        return totalb;
    }

    public void setTotalb(double totalb) {
        this.totalb = totalb;
    }
    
    
}
