/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Vistas.FrmFiltrarSeccion;

/**
 *
 * @author tacbaran
 */
public class HiloActualizaTablaSeccion_ extends Thread {
    
    FrmFiltrarSeccion frmSeccion;
    private boolean run=false;
    
    
    public HiloActualizaTablaSeccion_(FrmFiltrarSeccion frmSeccion){
        this.frmSeccion=frmSeccion;
    }
    @Override
    public void run(){
        run=true;
        System.out.println("HiloTablaCliente iniciado");
        while(run){
            try {
                sleep(1000);
              //  frmSeccion.actualizarTabla();
                
            }catch (InterruptedException e) {
                System.out.println(e);
                close();
            }
        }
        System.out.println("HiloTablaCliente terminado");
    }
    public void close(){
        this.run=false;
    }
    public boolean isClosed(){
        return !run;
    }
    
}
