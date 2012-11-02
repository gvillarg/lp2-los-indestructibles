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
}
