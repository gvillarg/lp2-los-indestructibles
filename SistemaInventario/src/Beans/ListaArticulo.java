/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ListaArticulo implements Serializable{
    private Articulo[] lista=null;

    public void agregar(Articulo a){
        if (lista==null){
            lista=new Articulo[1];
            lista[0]=a;
        }
        else{
            int i;
            Articulo[] temp=new Articulo[lista.length+1];
            for(i=0;i<lista.length;i++){
                temp[i]=lista[i];
            }
            temp[i]=a;
            lista=temp;
        }
    }
    /**
     * @return the lista
     */
    public Articulo[] getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(Articulo[] lista) {
        this.lista = lista;
    }
}
