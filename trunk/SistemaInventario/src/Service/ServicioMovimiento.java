/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Movimiento;
import java.util.ArrayList;


/**
 *
 * @author Enrique Carrion
 */
public class ServicioMovimiento {
     private ArrayList<Movimiento> movims = new ArrayList<Movimiento>();

     public void agregarMovimiento(Movimiento mov){
		movims.add(mov);
	}
     public Movimiento buscarMovId (int id){

		for (int i=0; i<movims.size(); i++)
		{
			if (movims.get(i).getId() == id) //comparamos por id
				return movims.get(i);
		}
			return null;
	}

	//buscamos
	public Movimiento buscarMovPos(int i){
		Movimiento mov=( i<movims.size() && i>=0) ? movims.get(i) : null;
		return mov;
	}

        //eliminamos un pedido por su id
	public void eliminaMov (int id)
	{
		for (int i=0; i<movims.size(); i++)
		{
			if(movims.get(i).getId() == id)
			{
				movims.remove(i);
				break;
			}
		}
	}

	//eliminamos un pedido por Objeto
	public void eliminaMov (Movimiento mov)
	{
		for (int i=0; i<movims.size(); i++)
		{
			if(movims.get(i).getId() == mov.getId()    )
			{
				movims.remove(i);
				break;
			}
		}
	}

	public void editarMov(Movimiento mov)
	{
		Movimiento mhallado=buscarMovId(mov.getId());
		if(mhallado==null)
		{	return;
		}
		else
		{
			mhallado.setFecha(mov.getFecha());
			mhallado.setTipoPedido(mov.getTipoPedido());

		}

	}

        public ArrayList<Movimiento> getMovs() {
        return movims;
    }
}
