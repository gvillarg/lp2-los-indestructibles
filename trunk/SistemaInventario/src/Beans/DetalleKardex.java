/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Guti
 */
public class DetalleKardex {
    private Articulo articulo;
    private int cantidad;
    private int estado; // 0=vendido,1=caducado,2=devuelto,3=entra a almacen
    private Pedido pedido;
    /**
     * @return the articulo
     */
    public Articulo getArticulo() {
        return articulo;
    }

    /**
     * @param articulo the articulo to set
     */
    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}
