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
    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
                                    "user=inf282g1&password=anillo";
    private ArrayList<Cliente> clientes=new ArrayList<Cliente>();
    
    public int agregarCliente(Cliente cliente){
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString =
                    "INSERT INTO empresa "
                    + "(ruc,razonSocial,webPage,pais,rubro,nombreContacto,telefonoContacto,emailContacto,tipo) "
                    + "VALUES(?,?,?,?,?,?,?,?,0)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, cliente.getRuc());
            pstmt.setString(2, cliente.getRazonSocial());
            pstmt.setString(3, cliente.getWebPage());
            pstmt.setString(4,cliente.getPais());
            pstmt.setString(5,cliente.getRubro());
            pstmt.setString(6, cliente.getNombreContacto());
            pstmt.setInt(7,cliente.getTelefonoContacto());
            pstmt.setString(8,cliente.getEmailContacto());            
                    
            result =  pstmt.executeUpdate();          
            System.out.println("conexion hecha: Insert");

            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión 
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public Cliente buscarClienteId (int id){
        Cliente cliente=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM empresa WHERE idEmpresa=? AND tipo=0");
            pstmt.setInt(1, id);
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");

            if (rs.next()){
                int ruc = rs.getInt("ruc");
                String razonSocial = rs.getString("razonSocial");
                String webPage = rs.getString("webPage");
                String pais = rs.getString("Pais");
                String rubro = rs.getString("Rubro"); 
                String nombreContacto=rs.getString("NombreContacto");
                int telefonoContacto=rs.getInt("telefonoContacto");
                String emailContacto=rs.getString("emailContacto");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return cliente;            
    }
    public Cliente buscarClientePos(int i){
        Cliente cliente=( i<getClientes().size() && i>=0) ? getClientes().get(i) : null;
        return cliente;
    }    
    public int eliminaCliente (int id)	{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString = "DELETE FROM empresa WHERE idEmpresa=? LIMIT 1;";            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, id);                    
            result=pstmt.executeUpdate();     
            System.out.println("conexion hecha: Delete");
            
            if (result==0)
                throw new Exception();            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;            
	}
    public void eliminaCliente (Cliente cliente){
            int id=cliente.getId();
            eliminaCliente(id);
    }
    public int editarCliente(Cliente cliente)	{
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString =
                     " UPDATE empresa "
                    +" SET ruc=?,razonSocial=?,webPage=?,pais=?,rubro=?,nombreContacto=?,telefonoContacto=?,emailContacto=?"
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
            System.out.println("conexion hecha: Update");

            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();  
        } 
        finally {
             //5. Se cierra la conexión
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;		
    }
    public ArrayList<Cliente> getClientes() {
        Cliente cliente=null;
        clientes=new ArrayList<Cliente>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM empresa WHERE tipo=0");
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");
            
            while (rs.next()){
                int id = rs.getInt("IdEmpresa");
                int ruc = rs.getInt("ruc");
                String razonSocial = rs.getString("razonSocial");
                String webPage = rs.getString("webPage");
                String pais = rs.getString("Pais");
                String rubro = rs.getString("Rubro"); 
                String nombreContacto=rs.getString("NombreContacto");
                int telefonoContacto=rs.getInt("telefonoContacto");
                String emailContacto=rs.getString("emailContacto");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return clientes;       
    } 
    public ArrayList<Cliente> filtrarClientes(String nombre, int ruc) {        
        ArrayList<Cliente> lista=new ArrayList<Cliente>();
        Cliente cliente=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            if (ruc==-1){
                pstmt = conn.prepareStatement("SELECT * FROM empresa WHERE RazonSocial LIKE ?"); 
            }
            else{
                pstmt = conn.prepareStatement("SELECT * FROM empresa WHERE RazonSocial LIKE ? AND RUC=? AND tipo=0;"); 
                pstmt.setInt(2,ruc);                
            }
                pstmt.setString(1,"%"+nombre+"%");           
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");
            
            while (rs.next()){
                int id = rs.getInt("IdEmpresa");
                ruc=rs.getInt("RUC");
                String razonSocial = rs.getString("razonSocial");
                String webPage = rs.getString("webPage");
                String pais = rs.getString("Pais");
                String rubro = rs.getString("Rubro"); 
                String nombreContacto=rs.getString("NombreContacto");
                int telefonoContacto=rs.getInt("telefonoContacto");
                String emailContacto=rs.getString("emailContacto");
                
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
                
                lista.add(cliente);
            }      
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return lista;
    }
}
