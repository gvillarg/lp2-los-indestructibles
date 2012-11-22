package Service;

import Beans.Usuario;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Guti
 */
public class ServicioUsuario {
    static private String connectionUrl ="jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
        "user=inf282g1&password=anillo";
    static public boolean AutentificarUsuario(String user,String pass){
        boolean resultado=false;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Driver driver=new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);            
            
            ps = conn.prepareStatement("SELECT * FROM usuarios "
                                +"WHERE usuario=? and contrasena=?;");
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            System.out.println("ServicioUsuario.AutentificarUsuario: conexion hecha");
            
            if(rs.next()){
                resultado=true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
             try{if(ps!=null) ps.close();}
             catch(Exception e){e.printStackTrace();}
             try{
                 if(conn!=null){
                   conn.close();
                   System.out.println("ServicioUsuario.AutentificarUsuario: conexion cerrada");
                 }
             }catch(Exception e){e.printStackTrace();}
        }                
        return resultado;
    }
    
/**
 *
 * @author andrés
 */
        public Usuario validate(String login,String password){
        
        Connection conn=null;
        Usuario usuario=null;
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            Driver driver=new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);            
            
            ps = conn.prepareStatement("SELECT * FROM usuarios "
                                +"WHERE usuario=? and contrasena=?;");
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            System.out.println("ServicioUsuario.AutentificarUsuario: conexion hecha");
            
            if(rs.next()){
                usuario = new Usuario();
                String name = rs.getString("NOMBRE");
                usuario.setName(name);
                usuario.setLogin(login); 
                
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("ServicioUsuario.AutentificarUsuario: conexion cerrada");
            try {rs.close();} catch(Exception e) {e.printStackTrace();}
            try{conn.close();} catch(Exception e) {e.printStackTrace();}
        }               
        return usuario;
    }
    
    
    
    
}
