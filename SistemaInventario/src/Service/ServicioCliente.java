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
    private String connectionUrl = "jdbc:mysql://localhost:3306/LP222?" +
                                   "user=root&password=password";
//    private int nextId=1;
    private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    
    public int agregarCliente(Cliente cliente){
//        cliente.setId(nextId++);
//	getClientes().add(cliente);
        
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
//        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            //String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
              //                     "user=root&password=clave";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString =
                    "INSERT INTO EMPRESA(idEmpresa,ruc,razonSocial,webPage,pais,rubro,nombreContacto,telefonoContacto,email)"
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, getNextId());
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
//        } finally {
//             //5. Se cierra la conexión
//             try {if (rs != null) rs.close(); } 
//             catch(Exception e){e.printStackTrace();}  
        } 
        return result;
    }
    public Cliente buscarClienteId (int id){
//        for (int i=0; i<getClientes().size(); i++)
//        {
//                if (getClientes().get(i).getId() == id) 
//                        return getClientes().get(i);
//        }
//
//        return null;		
        
        
//        return clientes;
        
        Cliente cliente=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1. Se registra el driver de la BD
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
//            String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
//                                   "user=root&password=clave";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            pstmt = conn.prepareStatement("SELECT * FROM EMPRESA WHERE IDEMPRESA=?");//WHERE TIPO=1;
            pstmt.setInt(1, id);
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                int ruc = rs.getInt("ruc");
                String razonSocial = rs.getString("razonSocial");
                String webPage = rs.getString("webPage");
                String pais = rs.getString("Pais");
                String rubro = rs.getString("Rubro"); 
                String nombreContacto=rs.getString("NombreContacto");
                int telefonoContacto=rs.getInt("telefonoContacto");
                String emailContacto=rs.getString("email");
                
                cliente= new Cliente();
                cliente.setId(id);
                cliente.setRuc(ruc);
                cliente.setRazonSocial(razonSocial);
                cliente.setWebPage(webPage);
                cliente.setPais(pais);
                cliente.setRubro(rubro);
                cliente.setNombreContacto(nombreContacto);
                cliente.setTelefonoContacto(telefonoContacto);
                cliente.setEmailContacto(emailContacto);
                
                
            }            
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
        }
        return cliente;       
        
        
    }
    public Cliente buscarClientePos(int i){
        Cliente cliente=( i<getClientes().size() && i>=0) ? getClientes().get(i) : null;
        return cliente;
    }    
    public int eliminaCliente (int id)	{
//		for (int i=0; i<getClientes().size(); i++)
//		{
//			if(getClientes().get(i).getId() == id)
//			{
//				getClientes().remove(i);
//				break;
//			}
//		}
            
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            //String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
              //                     "user=root&password=clave";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString = "DELETE FROM EMPRESA WHERE IDEMPRESA=? LIMIT 1;";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, id);
                    
            result=pstmt.executeUpdate();
            
            //4. Se evalúan los resultados
            if (result==0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
//        } finally {
//             //5. Se cierra la conexión
//             try {if (rs != null) rs.close(); } 
//             catch(Exception e){e.printStackTrace();}  
//        } 
        return result;
            
            
	}
    public void eliminaCliente (Cliente cliente){
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
    public int editarCliente(Cliente cliente)	{
//		Cliente cliente=  buscarClienteId( buscado.getId()        );
//		if(cliente!=null) 
//		{
//			cliente.setId(            buscado.getId());
//			cliente.setRuc(           buscado.getRuc());
//			cliente.setRazonSocial(   buscado.getRazonSocial());
//			cliente.setWebPage(       buscado.getWebPage());
//		}
            
            
         int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
//        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            //String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
              //                     "user=root&password=clave";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString =
                     " UPDATE EMPRESA "
                    +" SET ruc=?,razonSocial=?,webPage=?,pais=?,rubro=?,nombreContacto=?,telefonoContacto=?,email=?"
                    +" WHERE IDEMPRESA=?;";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, cliente.getRuc());
            pstmt.setString(2, cliente.getRazonSocial());
            pstmt.setString(3, cliente.getWebPage());
            pstmt.setString(4,cliente.getPais());
            pstmt.setString(5,cliente.getRubro());
            pstmt.setString(6, cliente.getNombreContacto());
            pstmt.setInt(7,cliente.getTelefonoContacto());
            pstmt.setString(8,cliente.getEmailContacto());
            pstmt.setInt(9, cliente.getId());
                   
            result =  pstmt.executeUpdate();
            
            //4. Se evalúan los resultados
            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
//        } finally {
//             //5. Se cierra la conexión
//             try {if (rs != null) rs.close(); } 
//             catch(Exception e){e.printStackTrace();}  
        } 
        return result;
        
        
		
	}
    public ArrayList<Cliente> getClientes() {
//        return clientes;
        
        Cliente cliente=null;
        clientes=new ArrayList<Cliente>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1. Se registra el driver de la BD
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
//            String connectionUrl = "jdbc:mysql://127.0.0.1/base_sistemainventario?" +
//                                   "user=root";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            pstmt = conn.prepareStatement("SELECT * FROM EMPRESA ");//WHERE TIPO=1;
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            while (rs.next()){
                int id = rs.getInt("IdEmpresa");
                int ruc = rs.getInt("ruc");
                String razonSocial = rs.getString("razonSocial");
                String webPage = rs.getString("webPage");
                String pais = rs.getString("Pais");
                String rubro = rs.getString("Rubro"); 
                String nombreContacto=rs.getString("NombreContacto");
                int telefonoContacto=rs.getInt("telefonoContacto");
                String emailContacto=rs.getString("email");
                
                cliente= new Cliente();
                cliente.setId(id);
                cliente.setRuc(ruc);
                cliente.setRazonSocial(razonSocial);
                cliente.setWebPage(webPage);
                cliente.setPais(pais);
                cliente.setRubro(rubro);
                cliente.setNombreContacto(nombreContacto);
                cliente.setTelefonoContacto(telefonoContacto);
                cliente.setEmailContacto(emailContacto);
                
                clientes.add(cliente);
            }            
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
        }
        return clientes;       
    } 
    public int getNextId() {
//        return nextId;
        
        int id=0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            //1. Se registra el driver de la BD
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
//            String connectionUrl = "jdbc:mysql://127.0.0.1:3306/base_sistemainventario?" +
//                                   "user=root&password=clave";
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            pstmt = conn.prepareStatement("SELECT MAX(IDEMPRESA) FROM EMPRESA;");//WHERE TIPO=1;
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                id = rs.getInt("max(idempresa)"); 
            }  
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
        }
        return id+1;       
        
        
        
    }
}
