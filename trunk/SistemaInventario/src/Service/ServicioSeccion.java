/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Articulo;
import Beans.Seccion;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author tacbaran
 */
public class ServicioSeccion {
  
    private ArrayList<Seccion> Seccion = new ArrayList<Seccion>() ;
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
}
