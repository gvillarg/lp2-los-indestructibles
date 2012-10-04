/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Guti
 */
public class Articulo {
    private int id;
    private String nombre;
    private String descripcion;
    private String tipoArticulo;
    private String tipoAlmacenamiento;
    private String unidad;
    private float precio;
    private int stock;
    private int stockMinimo;
    private int stockReservado;
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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the stockMinimo
     */
    public int getStockMinimo() {
        return stockMinimo;
    }

    /**
     * @param stockMinimo the stockMinimo to set
     */
    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    /**
     * @return the stockReservado
     */
    public int getStockReservado() {
        return stockReservado;
    }

    /**
     * @param stockReservado the stockReservado to set
     */
    public void setStockReservado(int stockReservado) {
        this.stockReservado = stockReservado;
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
     * @return the tipoAlmacenamiento
     */
    public String getTipoAlmacenamiento() {
        return tipoAlmacenamiento;
    }

    /**
     * @param tipoAlmacenamiento the tipoAlmacenamiento to set
     */
    public void setTipoAlmacenamiento(String tipoAlmacenamiento) {
        this.tipoAlmacenamiento = tipoAlmacenamiento;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
}
