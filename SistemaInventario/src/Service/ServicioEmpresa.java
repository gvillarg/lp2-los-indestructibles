/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Empresa;
import Beans.Empresa;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class ServicioEmpresa {
    private ArrayList<Empresa> empresas=new ArrayList<Empresa>();
    
    public void agregarEmpresa(Empresa empresa){
		getEmpresas().add(empresa);
	}
    public Empresa buscarEmpresaId (int id){
		for (int i=0; i<getEmpresas().size(); i++)
		{
			if (getEmpresas().get(i).getId() == id) 
				return getEmpresas().get(i);
		}
	
		return null;		
	}
    public Empresa buscarEmpresaPos(int i){
		Empresa empresa=( i<getEmpresas().size() && i>=0) ? getEmpresas().get(i) : null;
		return empresa;
	}
    public void eliminaEmpresa (int id)
	{
		for (int i=0; i<getEmpresas().size(); i++)
		{
			if(getEmpresas().get(i).getId() == id)
			{
				getEmpresas().remove(i);
				break;
			}
		}
	}
    public void eliminaEmpresa (Empresa empresa)
	{
            int id=empresa.getId();
            eliminaEmpresa(id);
		/*for (int i=0; i<empresas.size(); i++)
		{
			if(product.getId() == provicu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarEmpresa(Empresa buscado)
	{
		Empresa empresa=  buscarEmpresaId( buscado.getId()        );
		if(empresa!=null) 
		{
			empresa.setId(            buscado.getId());
			empresa.setRuc(           buscado.getRuc());
			empresa.setRazonSocial(   buscado.getRazonSocial());
			empresa.setWebPage(       buscado.getWebPage());
		}
		
	}

    /**
     * @return the empresas
     */
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    } 
}
