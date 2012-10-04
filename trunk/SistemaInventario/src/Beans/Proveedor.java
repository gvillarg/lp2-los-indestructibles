/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class Proveedor extends Empresa{
    private ArrayList<Articulo> articulos=new ArrayList<Articulo>();

    /**
     * @return the articulos
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * @param articulos the articulos to set
     */
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void agregarArticulo(Articulo articulo){
        articulos.add(articulo);
    }
}
