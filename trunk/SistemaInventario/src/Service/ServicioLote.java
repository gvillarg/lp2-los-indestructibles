/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Lote;
import Beans.Articulo;
import java.util.ArrayList;
 /*
 * @author Enrique Carrion
 */
public class ServicioLote {
     private ArrayList<Lote> lotes = new ArrayList<Lote>() ;
      private int nextId=1;

      public int getNextId(){
        return nextId;
    }

      public void agregarLote(Lote lt){
                lt.setId(nextId++);
		lotes.add(lt);
    }

      public Lote buscarLoteId (int id){
		for (int i=0; i<lotes.size(); i++)
		{
			if (lotes.get(i).getId() == id)
				return lotes.get(i);
		}

		return null;
	}
    public Lote buscarLotePos(int i){
		Lote lt=( i<lotes.size() && i>=0) ? lotes.get(i) : null;
		return lt;
	}

    public void eliminaLote (int id)
	{
		for (int i=0; i<lotes.size(); i++)
		{
			if(lotes.get(i).getId() == id)
			{
				lotes.remove(i);
				break;
			}
		}
	}
    public void eliminaLote(Lote lt)
	{
            int id=lt.getId();
            eliminaLote(id);
	}

    public void editarLote(Lote buscado)
	{
		Lote encontrado=  buscarLoteId( buscado.getId()        );
		if(encontrado!=null)
		{
			encontrado.setFechaCaducidad(buscado.getFechaCaducidad());
			encontrado.setFechaIngreso(buscado.getFechaIngreso());
			encontrado.setCantidad(buscado.getCantidad());
                        encontrado.setArticulo(buscado.getArticulo());
			encontrado.setSeccion(buscado.getSeccion());
                        encontrado.setSaldo(buscado.getSaldo());
		}

	}
}
