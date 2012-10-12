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
import Vistas.FRMMain;
import Vistas.FRMMantenimiento;
import javax.swing.JInternalFrame;

/**
 *
 * @author Guti
 */
public class Main {
    public static String [] unidad={"Unidad","Metros","Metros cuadrados", 
                                    "Metros cúbicos", "Litros","Cajas"};
    public static String [] tipoArticulo={"Otro","Electronico","Alimenticio","Limpieza","Textil"};
    public static String [] tipoAlmacenamiento={"Otro","Frio","Fragil","Seco"};
    public static ServicioArticulo servicioArticulo = new ServicioArticulo();
    public static ServicioGuiaRemision servicioGuiaRemision = new ServicioGuiaRemision();
    public static ServicioKardex servicioKardex = new ServicioKardex();
    public static ServicioPedido servicioPedido = new ServicioPedido();
    public static ServicioProveedor servicioProveedor=  new ServicioProveedor();
    public static ServicioCliente servicioCliente = new ServicioCliente();
    public static ServicioLote servicioLote=new ServicioLote();
    public static ServicioMovimiento servicioMovimiento=new ServicioMovimiento();
    public static ServicioAlmacen servicioAlmacen=new ServicioAlmacen();
    private static FRMMain frmMain;//=new FRMMain();
    /**
     * @param args the command line arguments
     */
//    public static void agregarVentana(JInternalFrame ventana){
//        frmMain.agregarVentana(ventana);
//    }
    
    public static String unidades(int i){
        String unidad=null;
        switch(i){
            case 0: unidad="Kilogramos"; break;
            case 1: unidad="Cajas";break;
            case 2: unidad="Metros cuadrados";break;
            case 3: unidad="Metros";break;
        }
        return unidad;
    }
    
    public static void main(String[] args) {
        frmMain=new FRMMain();
        frmMain.setVisible(true);

    }
}
