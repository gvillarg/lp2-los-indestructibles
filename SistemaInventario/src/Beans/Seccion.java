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
    private int tipoArticulo;
    private int lleno;  //si=1 y no=0
    private ArrayList<Lote> lotes = new ArrayList<Lote>();
    
    
    private int estado;
    private int tipoAlmacenamiento;
    
    
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
    public int getTipoArticulo() {
        return tipoArticulo;
    }

    /**
     * @param tipoArticulo the tipoArticulo to set
     */
    public void setTipoArticulo(int tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }

    /**
     * @return the lleno
     */
    public int isLleno() {
        return getLleno();
    }

    /**
     * @param lleno the lleno to set
     */
    public void setLleno(int lleno) {
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
        this.getLotes().add(lote);
    }

    /**
     * @return the lleno
     */
    public int getLleno() {
        return lleno;
    }

    /**
     * @param lotes the lotes to set
     */
    public void setLotes(ArrayList<Lote> lotes) {
        this.lotes = lotes;
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

    /**
     * @return the tipoAlmacenamiento
     */
    public int getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    /**
     * @param tipoAlmacenamiento the tipoAlmacenamiento to set
     */
    public void setTipoAlmacenamiento(int tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }
}
