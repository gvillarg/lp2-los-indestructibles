/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Kardex;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioKardex {
    private ArrayList<Kardex> kardexs = new ArrayList<Kardex>();
    
    
    //agregamos un pedido por su id
	public void agregarKardex(Kardex kardex){
		getKardexs().add(kardex);
	}
	
	
	//buscamos un pedido por su id
	public Kardex buscarKardexId (int id){
		
		for (int i=0; i<getKardexs().size(); i++)
		{
			if (getKardexs().get(i).getId() == id) //comparamos por id
				return getKardexs().get(i);
		}
			return null;		
	}
	
	//buscamos 
	public Kardex buscarKardexPos(int i){
		Kardex kardex=( i<getKardexs().size() && i>=0) ? getKardexs().get(i) : null;
		return kardex;
	}
	
	//eliminamos un pedido por su id
	public void eliminaKardex (int id)
	{
		for (int i=0; i<getKardexs().size(); i++)
		{
			if(getKardexs().get(i).getId() == id)
			{
				getKardexs().remove(i);
				break;
			}
		}
	}
	
	//eliminamos un pedido por Objeto
	public void eliminaKardex (Kardex kardex)
	{
		for (int i=0; i<getKardexs().size(); i++)
		{
			if(getKardexs().get(i).getId() == kardex.getId()    )
			{
				getKardexs().remove(i);
				break;
			}
		}
	}
	
	public void editarKardex(Kardex _kardex)
	{
		Kardex kardex=buscarKardexId(_kardex.getId());
		if(kardex==null)
		{	return;
		}
		else
		{
			kardex.setFecha(    _kardex.getFecha()    );
			kardex.setDetalle(    _kardex.getDetalle()  );
			kardex.setTipoTransaccion(   _kardex.getTipoTransaccion() );	
			kardex.setId(   _kardex.getId() );
		}
		
	}

    /**
     * @return the kardexs
     */
    public ArrayList<Kardex> getKardexs() {
        return kardexs;
    }

    /**
     * @param kardexs the kardexs to set
     */
    public void setKardexs(ArrayList<Kardex> kardexs) {
        this.kardexs = kardexs;
    }
	
    
}
