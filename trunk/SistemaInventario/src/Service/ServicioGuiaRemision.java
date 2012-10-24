/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.GuiaRemision;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioGuiaRemision {
    private ArrayList<GuiaRemision> guiasRemision = new ArrayList<GuiaRemision>();
     private String connectionUrl = "jdbc:mysql://localhost:3306/inf282g1?" + "user=inf282g1&password=anillo";
    //private int nextId=1;
    
    public void agregarGuiaRemision(GuiaRemision guiaRemision){
		getGuiasRemision().add(guiaRemision);
	}
    public GuiaRemision buscarGuiaRemisionId (int id){
		for (int i=0; i<getGuiasRemision().size(); i++)
		{
			if (getGuiasRemision().get(i).getId() == id) 
				return getGuiasRemision().get(i);
		}
	
		return null;		
	}
    public GuiaRemision buscarGuiaRemisionPos(int i){
		GuiaRemision guiaRemision=( i<getGuiasRemision().size() && i>=0) ? getGuiasRemision().get(i) : null;
		return guiaRemision;
	}
    public void eliminaGuiaRemision (int id)
	{
		for (int i=0; i<getGuiasRemision().size(); i++)
		{
			if(getGuiasRemision().get(i).getId() == id)
			{
				getGuiasRemision().remove(i);
				break;
			}
		}
	}
    public void eliminaGuiaRemision (GuiaRemision guiaRemision)
	{
            int id=guiaRemision.getId();
            eliminaGuiaRemision(id);
		/*for (int i=0; i<guiasRemision.size(); i++)
		{
			if(product.getId() == provicu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarGuiaRemision(GuiaRemision buscado)
	{
		GuiaRemision guiaRemision=  buscarGuiaRemisionId( buscado.getId()        );
		if(guiaRemision!=null) 
		{
			guiaRemision.setId(            buscado.getId());
			guiaRemision.setCliente(           buscado.getCliente());
			guiaRemision.setFecha(   buscado.getFecha());
			guiaRemision.setTotal(       buscado.getTotal());
		}
		
	}

    /**
     * @return the guiasRemision
     */
    public ArrayList<GuiaRemision> getGuiasRemision() {
        return guiasRemision;
    }     
}
