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
    private int tipoMovimiento;
    private Pedido pedido;
    

     public int getId() {
        return id;
    }

     public void setId(int id) {
        this.id = id;
    }
     
     public void setPedido(Pedido p)
     {
         pedido=p;
     }

     public Pedido getPedido()
     {
         return pedido;
     }
     
     public ArrayList<DetalleMovimiento> getDetalle() {
        return detalle;
    }

        public void setDetalle(ArrayList<DetalleMovimiento> detalle) {
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

    public int getTipoMovimiento()
    {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int v)
    {
        tipoMovimiento=v;
    }
}
