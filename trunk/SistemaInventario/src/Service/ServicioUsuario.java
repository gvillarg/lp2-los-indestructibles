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
/**
 *
 * @author andrés
 */
        public Usuario AutentificarUsuario(String login,String password){
        
        Connection conn=null;
        Usuario usuario=null;
        
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(connectionUrl);            
            
            ps = conn.prepareStatement("SELECT * FROM usuarios "
                                +"WHERE usuario=? and contrasena=?;");
            ps.setString(1, login);
            ps.setString(2, password);
            rs = ps.executeQuery();
            System.out.println("ServicioUsuario.AutentificarUsuario: conexion hecha");
            
            if(rs.next()){
            	usuario=new Usuario();
                usuario.setId(rs.getInt("idusuarios"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setUsuario(rs.getString("usuario"));
                usuario.setPassword(rs.getString("contrasena"));
                usuario.setApellido(rs.getString("apellido"));
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("ServicioUsuario.AutentificarUsuario: conexion cerrada");
            try {rs.close();} catch(Exception e) {e.printStackTrace();}
            try {ps.close();} catch(Exception e) {e.printStackTrace();}
            try{conn.close();} catch(Exception e) {e.printStackTrace();}
        }               
        return usuario;
    }   
}
