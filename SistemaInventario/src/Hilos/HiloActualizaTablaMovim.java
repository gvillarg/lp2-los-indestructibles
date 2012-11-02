/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;
import Vistas.FRMListaMovimiento;
/**
 *
 * @author Enrique Carrion
 */
public class HiloActualizaTablaMovim extends Thread{
     FRMListaMovimiento frmMovimiento;
    private boolean run=false;
    public HiloActualizaTablaMovim(FRMListaMovimiento frmArticulo){
        this.frmMovimiento=frmArticulo;
    }
    @Override
    public void run(){
        run=true;
        System.out.println("HiloTablaCliente iniciado");
        while(run){
            try {
                sleep(1000);
                frmMovimiento.actualizarTabla();
                
            }catch (InterruptedException e) {
                System.out.println(e);
                close();
            }
        }
    }
    public void close(){
        this.run=false;
    }
    public boolean isClosed(){
        return !run;
    }
    
}
