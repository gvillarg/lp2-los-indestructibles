/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Proveedor;
import Beans.Proveedor;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioProveedor {
    private ArrayList<Proveedor> proveedores=new ArrayList<Proveedor>();
    
    public void agregarProveedor(Proveedor proveedor){
		getProveedores().add(proveedor);
	}
    public Proveedor buscarProveedorId (int id){
		for (int i=0; i<getProveedores().size(); i++)
		{
			if (getProveedores().get(i).getId() == id) 
				return getProveedores().get(i);
		}
	
		return null;		
	}
    public Proveedor buscarProveedorPos(int i){
		Proveedor proveedor=( i<getProveedores().size() && i>=0) ? getProveedores().get(i) : null;
		return proveedor;
	}
    public void eliminaProveedor (int id)
	{
		for (int i=0; i<getProveedores().size(); i++)
		{
			if(getProveedores().get(i).getId() == id)
			{
				getProveedores().remove(i);
				break;
			}
		}
	}
    public void eliminaProveedor (Proveedor proveedor)
	{
            int id=proveedor.getId();
            eliminaProveedor(id);
		/*for (int i=0; i<proveedores.size(); i++)
		{
			if(product.getId() == provicu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarProveedor(Proveedor buscado)
	{
		Proveedor proveedor=  buscarProveedorId( buscado.getId()        );
		if(proveedor!=null) 
		{
			proveedor.setId(            buscado.getId());
			proveedor.setRuc(           buscado.getRuc());
			proveedor.setRazonSocial(   buscado.getRazonSocial());
			proveedor.setWebPage(       buscado.getWebPage());
		}
		
	}

    /**
     * @return the proveedores
     */
    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    } 
}
