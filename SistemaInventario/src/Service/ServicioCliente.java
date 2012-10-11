/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Cliente;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Guti
 */
public class ServicioCliente {
        private int nextId=1;
        private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    
    public int agregarCliente(Cliente cliente){
//        cliente.setId(nextId++);
//	getClientes().add(cliente);
        
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
                                   "user=root&password=3306";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString =
                    "INSERT INTO EMPRESA(idEmpresa,ruc,razonSocial,webPage,pais,rubro,nombreContacto,telefonoContacto,email)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, cliente.getId());
            pstmt.setInt(2, cliente.getRuc());
            pstmt.setString(3, cliente.getRazonSocial());
            pstmt.setString(4, cliente.getWebPage());
            pstmt.setString(5,cliente.getPais());
            pstmt.setString(6,cliente.getRubro());
            pstmt.setString(7, cliente.getNombreContacto());
            pstmt.setInt(8,cliente.getTelefonoContacto());
            pstmt.setString(9,cliente.getEmailContacto());
                    
            result =  pstmt.executeUpdate();
            
            //4. Se evalúan los resultados
            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
        } 
        return result;
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

    /**
     * @return the nextId
     */
    public int getNextId() {
        return nextId;
    }
}
