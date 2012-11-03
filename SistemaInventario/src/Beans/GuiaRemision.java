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
public class GuiaRemision {
    private int id;
    private String motivoTranslado;
    private Date fecha;
    private String origen;
    private String destino;
    private String transportista;
    private float total;
    private Cliente cliente;
    private ArrayList<DetalleGuiaRemision> detalle=new ArrayList<DetalleGuiaRemision>();

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
     * @return the motivoTranslado
     */
    public String getMotivoTranslado() {
        return motivoTranslado;
    }

    /**
     * @param motivoTranslado the motivoTranslado to set
     */
    public void setMotivoTranslado(String motivoTranslado) {
        this.motivoTranslado = motivoTranslado;
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
     * @return the origen
     */
    public String getOrigen() {
        return origen;
    }

    /**
     * @param origen the origen to set
     */
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    /**
     * @return the destino
     */
    public String getDestino() {
        return destino;
    }

    /**
     * @param destino the destino to set
     */
    public void setDestino(String destino) {
        this.destino = destino;
    }

    /**
     * @return the transportista
     */
    public String getTransportista() {
        return transportista;
    }

    /**
     * @param transportista the transportista to set
     */
    public void setTransportista(String transportista) {
        this.transportista = transportista;
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
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the detalle
     */
    public ArrayList<DetalleGuiaRemision> getDetalle() {
        return detalle;
    }
    public void agregarDetalle(DetalleGuiaRemision detalle){
        this.detalle.add(detalle);
    }
}
