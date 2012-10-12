/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

/**
 *
 * @author Enrique Carrion
 */
public class DetalleMovimiento {
    private Articulo articulo;
    private int cantidad;

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

}
