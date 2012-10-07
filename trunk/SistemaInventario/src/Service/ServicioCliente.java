/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioCliente {
        private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    
    public void agregarCliente(Cliente cliente){
		getClientes().add(cliente);
	}
    public Cliente buscarClienteId (int id){
		for (int i=0; i<getClientes().size(); i++)
		{
			if (getClientes().get(i).getId() == id) 
				return getClientes().get(i);
		}
	
		return null;		
	}
    public Cliente buscarClientePos(int i){
		Cliente cliente=( i<getClientes().size() && i>=0) ? getClientes().get(i) : null;
		return cliente;
	}
    public void eliminaCliente (int id)
	{
		for (int i=0; i<getClientes().size(); i++)
		{
			if(getClientes().get(i).getId() == id)
			{
				getClientes().remove(i);
				break;
			}
		}
	}
    public void eliminaCliente (Cliente cliente)
	{
            int id=cliente.getId();
            eliminaCliente(id);
		/*for (int i=0; i<clientes.size(); i++)
		{
			if(product.getId() == provicu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarCliente(Cliente buscado)
	{
		Cliente cliente=  buscarClienteId( buscado.getId()        );
		if(cliente!=null) 
		{
			cliente.setId(            buscado.getId());
			cliente.setRuc(           buscado.getRuc());
			cliente.setRazonSocial(   buscado.getRazonSocial());
			cliente.setWebPage(       buscado.getWebPage());
		}
		
	}

    /**
     * @return the clientes
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    } 
}


