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
public class Pedido {
    private int id;
    private Date fecha;
    private float total;
    private int estado; //0=pendiente,1=atendido,2=cancelado
    private Proveedor proveedor;
    private ArrayList<DetallePedido> detalle =new ArrayList <DetallePedido>(); 

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
     * @return the total
     */
    public float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(float total) {
        this.total = total;
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
     * @return the proveedor
     */
    public Proveedor getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    /**
     * @return the items
     */
    public ArrayList<DetallePedido> getDetalle() {
        return detalle;
    }
    public void agregarDetalle(DetallePedido detallePedido){
        detalle.add(detallePedido);
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(ArrayList<DetallePedido> detalle) {
        this.detalle = detalle;
    }
}
