/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Service.ServicioArticulo;
import Service.ServicioCliente;
import Service.ServicioGuiaRemision;
import Service.ServicioKardex;
import Service.ServicioPedido;
import Service.ServicioProveedor;
import Service.ServicioLote;
import Service.ServicioMovimiento;
import Service.ServicioAlmacen;
import Service.ServicioSeccion;
import Vistas.FRMMain;
import Vistas.FRMMantenimiento;
import javax.swing.JInternalFrame;

/**
 *
 * @author Guti
 */
public class Main {
    public static String [] unidad={"Metros","Litros","Cajas","Kilogramos"};
    public static String [] tipoArticulo={"Otro","Electronico","Alimenticio","Limpieza","Textil"};
    public static String [] tipoAlmacenamiento={"Otro","Frio","Fragil","Seco"};
     public static String []  estadosSeccion={"Vacio","disponible","lleno"};
    public static String [] pais={"",""};
    public static ServicioArticulo servicioArticulo = new ServicioArticulo();
    public static ServicioGuiaRemision servicioGuiaRemision = new ServicioGuiaRemision();
    public static ServicioKardex servicioKardex = new ServicioKardex();
    public static ServicioPedido servicioPedido = new ServicioPedido();
    public static ServicioProveedor servicioProveedor=  new ServicioProveedor();
    public static ServicioCliente servicioCliente = new ServicioCliente();
    public static ServicioLote servicioLote=new ServicioLote();
    public static ServicioMovimiento servicioMovimiento=new ServicioMovimiento();
    public static ServicioAlmacen servicioAlmacen=new ServicioAlmacen();
     public static ServicioSeccion servicioSeccion=new ServicioSeccion();
    private static FRMMain frmMain;//=new FRMMain();
    /**
     * @param args the command line arguments
     */
//    public static void agregarVentana(JInternalFrame ventana){
//        frmMain.agregarVentana(ventana);
//    }
    
    
    public static void main(String[] args) {
        frmMain=new FRMMain();
        frmMain.setVisible(true);

    }
}
