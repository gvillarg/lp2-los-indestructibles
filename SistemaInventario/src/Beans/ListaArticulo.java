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
public class ListaArticulo {
    private ArrayList<Articulo> lista=new  ArrayList<Articulo>();

    /**
     * @return the lista
     */
    public ArrayList<Articulo> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(ArrayList<Articulo> lista) {
        this.lista = lista;
    }
}
