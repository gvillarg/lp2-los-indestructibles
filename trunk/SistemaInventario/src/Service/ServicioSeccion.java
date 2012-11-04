/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Almacen;
import Beans.Seccion;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author tacbaran
 */
public class ServicioSeccion {
  
    private ArrayList<Seccion> secciones = new ArrayList<Seccion>() ;
    private String connectionUrl ="jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
"user=inf282g1&password=anillo";
//    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1"+"user=inf282g1&password=anillo";

    
    
    public int agregarSeccion(Seccion seccion){
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("conexion hecha: Select");

            String SQLString =
                    "INSERT INTO seccion(tipoArticulo, "
                    +"tipoAlmacenamiento,estado,idAlmacen"
                    + ") "
                    + "VALUES(?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            
            pstmt.setInt(1, seccion.getTipoArticulo() );
            pstmt.setInt(2, seccion.getTipoAlmacenamiento());
            pstmt.setInt(3, seccion.getEstado());
            pstmt.setInt(4, 0);
            result =  pstmt.executeUpdate();
            System.out.println("conexion hecha: Insert");

            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    
    public ArrayList<Seccion> getSecciones(Almacen almac) {
       
        
       Connection conn = null;
       PreparedStatement pstmt = null;
       ResultSet rs = null;
       ArrayList<Seccion> secciones=null;
        try {
          Driver myDriver = new com.mysql.jdbc.Driver();
           conn = DriverManager.getConnection(connectionUrl);
           pstmt = conn.prepareStatement("SELECT * FROM seccion Where idAlmacen=?; ");
           pstmt.setInt(1, almac.getId());
           rs =  pstmt.executeQuery();
//            System.out.println("conexion hecha: Select");
//            
            while (rs.next()){
//                int id = rs.getInt("idSeccion");
                Seccion seccion=new Seccion();
                seccion.setId(rs.getInt("idSeccion"));
                seccion.setTipoArticulo(rs.getInt("tipoArticulo"));
                seccion.setTipoAlmacenamiento(rs.getInt("tipoAlmacenamiento"));
                seccion.setEstado(rs.getInt("estado"));
                secciones.add(seccion);
            }            
       } 
        catch (Exception ex) {
           ex.printStackTrace();
       } 
       finally {
            //5. Se cierra la conexión
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace(); secciones=null;}  
       }
         return secciones;
    }
    
    
}
