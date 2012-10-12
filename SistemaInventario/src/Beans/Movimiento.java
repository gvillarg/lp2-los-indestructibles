/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Enrique Carrion
 */
public class Movimiento {
     private int id;
    private ArrayList<DetalleMovimiento> detalle=new ArrayList<DetalleMovimiento>();
    private Date fecha;
    private int tipoPedido;

     public int getId() {
        return id;
    }

     public void setId(int id) {
        this.id = id;
    }

     public ArrayList<DetalleMovimiento> getDetalle() {
        return detalle;
    }

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

    public int getTipoPedido()
    {
        return tipoPedido;
    }

    public void setTipoPedido(int v)
    {
        tipoPedido=v;
    }
}
