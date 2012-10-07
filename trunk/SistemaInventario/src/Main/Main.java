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
import Service.ServicioEmpresa;
import Vistas.FRMMain;
import Vistas.FRMMantenimiento;
import javax.swing.JInternalFrame;

/**
 *
 * @author Guti
 */
public class Main {
    
    public static ServicioArticulo servicioArticulo = new ServicioArticulo();
    public static ServicioGuiaRemision servicioGuiaRemision = new ServicioGuiaRemision();
    public static ServicioKardex servicioKardex = new ServicioKardex();
    public static ServicioPedido servicioPedido = new ServicioPedido();
    public static ServicioEmpresa servicioEmpresa=  new ServicioEmpresa();
    public static ServicioCliente servicioCliente = new ServicioCliente();
    private static FRMMain frmMain;//=new FRMMain();
    /**
     * @param args the command line arguments
     */
    public static void agregarVentana(JInternalFrame ventana){
        frmMain.agregarVentana(ventana);
    }
    
    public static void main(String[] args) {
        frmMain=new FRMMain();
        frmMain.setVisible(true);

    }
}
