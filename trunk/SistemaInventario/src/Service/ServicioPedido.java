/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioPedido {
    private ArrayList<Pedido> pedidos=new ArrayList<Pedido>();
    
    public void agregarPedido(Pedido pedido){
		pedidos.add(pedido);
	}

    //buscamos un pedido por su id
	public Pedido buscarPedidoId (int id){
		
		for (int i=0; i<pedidos.size(); i++)
		{
			if (pedidos.get(i).getId() == id) //comparamos por id
				return pedidos.get(i);
		}
			return null;		
	}
	
	//buscamos 
	public Pedido buscarPedidoPos(int i){
		Pedido pedido=( i<pedidos.size() && i>=0) ? pedidos.get(i) : null;
		return pedido;
	}
	
	//eliminamos un pedido por su id
	public void eliminarPedido (int id)
	{
		for (int i=0; i<pedidos.size(); i++)
		{
			if(pedidos.get(i).getId() == id)
			{
				pedidos.remove(i);
				break;
			}
		}
	}
	
	//eliminamos un pedido por Objeto
	public void eliminarPedido (Pedido pedido)
	{
		for (int i=0; i<pedidos.size(); i++)
		{
			if(pedidos.get(i).getId() == pedido.getId()    )
			{
				pedidos.remove(i);
				break;
			}
		}
	}
	
	public void editarPedido(Pedido _pedido)
	{
		Pedido pedido=buscarPedidoId(_pedido.getId());
		if(pedido==null)
		{	return;
		}
		else
		{
                    pedido.setId(   _pedido.getId());
                    pedido.setFecha(   _pedido.getFecha());
                    pedido.setTotal(    _pedido.getTotal());
                    pedido.setEstado(   _pedido.getEstado());
                    pedido.setProveedor(    _pedido.getProveedor());
                    pedido.setDetalle(  _pedido.getDetalle());
		}
		
	}
}
