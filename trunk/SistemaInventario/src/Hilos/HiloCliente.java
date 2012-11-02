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
    public HiloCliente(FRMCliente frmCliente){
        this.frmCliente=frmCliente;
    }
    @Override
    public void actualizarTabla() {
        if (frmCliente.isClosed())
            super.interrupt();
        else
            frmCliente.actualizarTabla();
    }
}
