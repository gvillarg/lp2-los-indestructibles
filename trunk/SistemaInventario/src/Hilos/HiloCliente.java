/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Vistas.FRMCliente;

/**
 *
 * @author Guti
 */
public class HiloCliente extends HiloActualizaTabla {
    FRMCliente frmCliente;
//    private boolean run=false;
    public HiloCliente(FRMCliente frmCliente){
        this.frmCliente=frmCliente;
    }
//    @Override
//    public void run(){
//        run=true;
//        System.out.println("HiloTablaCliente iniciado");
//        while(run){
//            try {
//                sleep(6000);
//                frmCliente.actualizarTabla();
//                
//            }catch (InterruptedException e) {
//                System.out.println(e);
//                close();//run=false;
//            }
//        }
//        System.out.println("HiloTablaCliente terminado");
//    }
//    public void close(){
//        this.run=false;
//    }
//    public boolean isClosed(){
//        return !run;
//    }

    @Override
    public void actualizarTabla() {
        if (frmCliente.isClosed())
            super.interrupt();
        else
            frmCliente.actualizarTabla();
    }
}
