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
public class HiloActualizaTabla extends Thread {
    FRMCliente frmCliente;
    boolean run;
    public HiloActualizaTabla(FRMCliente frmCliente){
        this.frmCliente=frmCliente;
    }
    @Override
    public void run(){
        run=true;
        System.out.println("HiloTablaCliente iniciado");
        while(run){
            try {
                sleep(6000);
                frmCliente.actualizarTabla();
            }catch (InterruptedException e) {
                System.out.println(e);
                close();
            }
        }
        System.out.println("HiloTablaCliente interrumpido");
    }
    public void close(){
        this.run=false;
    }
}
