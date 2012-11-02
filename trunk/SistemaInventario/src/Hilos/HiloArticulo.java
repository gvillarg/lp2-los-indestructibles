/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Vistas.FrmFiltrarArticulo;

/**
 *
 * @author Guti
 */
public class HiloArticulo extends HiloActualizaTabla {
    FrmFiltrarArticulo frmFiltrarArticulo;
    public HiloArticulo(FrmFiltrarArticulo frmFiltrarArticulo){
        this.frmFiltrarArticulo=frmFiltrarArticulo;
    }
    @Override
    public void actualizarTabla() {
        if (frmFiltrarArticulo.isClosed())
            super.interrupt();
        else
            frmFiltrarArticulo.actualizarTabla();
    }
//    FrmFiltrarArticulo frmArticulo;
//    private boolean run=false;
//    public HiloActualizaTablaArticulo(FrmFiltrarArticulo frmArticulo){
//        this.frmArticulo=frmArticulo;
//    }
//    @Override
//    public void run(){
//        run=true;
//        System.out.println("HiloTablaCliente iniciado");
//        while(run){
//            try {
//                sleep(6000);
//                frmArticulo.actualizarTabla();
//                
//            }catch (InterruptedException e) {
//                System.out.println(e);
//                close();
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
}
