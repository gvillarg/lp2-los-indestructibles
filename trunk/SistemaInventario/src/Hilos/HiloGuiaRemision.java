/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Hilos;

import Vistas.FrmFiltrarGuiaRemision;

/**
 *
 * @author Guti
 */
public class HiloGuiaRemision extends HiloActualizaTabla{
    FrmFiltrarGuiaRemision frmFiltrarGuiaRemision=null;
    public HiloGuiaRemision(FrmFiltrarGuiaRemision frmFiltrarGuiaRemision) {
        this.frmFiltrarGuiaRemision=frmFiltrarGuiaRemision;
    }
    public void actualizarTabla() {
        if (frmFiltrarGuiaRemision.isClosed())
            super.interrupt();
        else
            frmFiltrarGuiaRemision.actualizarTabla();
    }    
}
