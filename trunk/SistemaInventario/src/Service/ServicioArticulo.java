/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Articulo;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioArticulo {
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>() ;
    private int nextId=1;
    
    public int getNextId(){
        return nextId;
    }
    public void agregarArticulo(Articulo articulo){
                articulo.setId(nextId++);
                articulo.setStockReservado(0);
		getArticulos().add(articulo);
	}
    public Articulo buscarArticuloId (int id){
		for (int i=0; i<getArticulos().size(); i++)
		{
			if (getArticulos().get(i).getId() == id) 
				return getArticulos().get(i);
		}
	
		return null;		
	}
    public Articulo buscarArticuloPos(int i){
		Articulo articulo=( i<articulos.size() && i>=0) ? articulos.get(i) : null;
		return articulo;
	}
    public void eliminaArticulo (int id)
	{
		for (int i=0; i<getArticulos().size(); i++)
		{
			if(getArticulos().get(i).getId() == id)
			{
				getArticulos().remove(i);
				break;
			}
		}
	}
    public void eliminaArticulo (Articulo articulo)
	{
            int id=articulo.getId();
            eliminaArticulo(id);
		/*for (int i=0; i<articulos.size(); i++)
		{
			if(product.getId() == articu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarArticulo(Articulo buscado)
	{
		Articulo encontrado=  buscarArticuloId( buscado.getId()        );
		if(encontrado!=null)
		{
			encontrado.setNombre(buscado.getNombre());
			encontrado.setDescripcion(buscado.getDescripcion());
			encontrado.setPrecio(buscado.getPrecio());
                        encontrado.setUnidad(buscado.getUnidad());
			encontrado.setStock(buscado.getStock());
                        encontrado.setStockMinimo(buscado.getStockMinimo());
                        encontrado.setStockReservado(buscado.getStockReservado());
		}   
		
	}

    /**
     * @return the articulos
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    public ArrayList<Articulo> filtrarArticulos(String nombre){
        ArrayList<Articulo> lista=new ArrayList();
        
        for (int i=0;i<articulos.size();i++)
            if((articulos.get(i).getNombre().contains(nombre))||(articulos.get(i).getDescripcion().contains(nombre)))
                lista.add(articulos.get(i));         
        
        return lista;
    }
}
