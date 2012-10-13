/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

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
    private double pesoTotal;
    private double total;
    private Cliente cliente;
    private DetalleGuiaRemision detalle;

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
     * @return the pesoTotal
     */
    public double getPesoTotal() {
        return pesoTotal;
    }

    /**
     * @param pesoTotal the pesoTotal to set
     */
    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
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
    public DetalleGuiaRemision getDetalle() {
        return detalle;
    }

    /**
     * @param detalle the detalle to set
     */
    public void setDetalle(DetalleGuiaRemision detalle) {
        this.detalle = detalle;
    }


}
