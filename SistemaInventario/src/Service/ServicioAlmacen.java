/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Almacen;
import java.util.ArrayList;

/**
 *
 * @author enrique
 */
public class ServicioAlmacen {
    private ArrayList<Almacen> almacenes = new ArrayList<Almacen>();
    private int nextId=1;


    public void agregarAlmacen(Almacen almacen){
        almacen.setId(nextId++);
        getAlmacenes().add(almacen);
    }
    public Almacen buscarAlmacenId (int id){
		for (int i=0; i<getAlmacenes().size(); i++)
		{
			if (getAlmacenes().get(i).getId() == id)
				return getAlmacenes().get(i);
		}

		return null;
	}
    public Almacen buscarAlmacenPos(int i){
		Almacen almacen=( i<getAlmacenes().size() && i>=0) ? getAlmacenes().get(i) : null;
		return almacen;
	}
    public void eliminaAlmacen (int id)
	{
		for (int i=0; i<getAlmacenes().size(); i++)
		{
			if(getAlmacenes().get(i).getId() == id)
			{
				getAlmacenes().remove(i);
				break;
			}
		}
	}
    public void eliminaAlmacen (Almacen almacen)
	{
            int id=almacen.getId();
            eliminaAlmacen(id);
	}
    public void editarAlmacen(Almacen buscado)
	{
		Almacen almacen=  buscarAlmacenId( buscado.getId()        );
		if(almacen!=null)
		{
			almacen.setId(            buscado.getId());
			almacen.setDireccion(           buscado.getDireccion());
			almacen.setArea(   buscado.getArea());
		}

	}

    /**
     * @return the almacenes
     */
    public ArrayList<Almacen> getAlmacenes() {
        return almacenes;
    }

}
