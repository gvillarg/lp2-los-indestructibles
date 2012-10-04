/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Guti
 */
public class Kardex {
    private int id;
    private ArrayList<DetalleKardex> detalle=new ArrayList<DetalleKardex>();
    private Date fecha;
    private int tipoTransaccion;
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
     * @return the detalle
     */
    public ArrayList<DetalleKardex> getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(ArrayList<DetalleKardex> detalle) {
        this.setDetalle(detalle);
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    /**
     * @return the tipoTransaccion
     */
    public int getTipoTransaccion() {
        return tipoTransaccion;
    }

    /**
     * @param tipoTransaccion the tipoTransaccion to set
     */
    public void setTipoTransaccion(int tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
}
