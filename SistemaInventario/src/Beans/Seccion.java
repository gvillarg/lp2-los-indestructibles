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
public class Seccion {
    private int id;
    private String tipoArticulo;
    private boolean lleno;  //si o no
    private ArrayList<Lote> lotes = new ArrayList<Lote>();
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }



    /**
     * @return the tipoArticulo
     */
    public String getTipoArticulo() {
        return tipoArticulo;
    }

    /**
     * @param tipoArticulo the tipoArticulo to set
     */
    public void setTipoArticulo(String tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    /**
     * @return the lleno
     */
    public boolean isLleno() {
        return lleno;
    }

    /**
     * @param lleno the lleno to set
     */
    public void setLleno(boolean lleno) {
        this.lleno = lleno;
    }

    /**
     * @return the lotes
     */
    public ArrayList<Lote> getLotes() {
        return lotes;
    }

    /**
     * @param lotes the lotes to set
     */
    public void agregarLote(Lote lote){
        this.lotes.add(lote);
    }
}
