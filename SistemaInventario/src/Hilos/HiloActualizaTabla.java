package Hilos;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;

/**
 *
 * @author Guti
 */
public abstract class HiloActualizaTabla extends Thread{
//    JInternalFrame ventana;
    private boolean run=false;
    public HiloActualizaTabla(){
    }
    @Override
    public void run(){
        run=true;
        System.out.println("HiloTablaCliente iniciado");
        while(run){
            try {
                sleep(6000);
                actualizarTabla();                
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

    public abstract void actualizarTabla();
}
