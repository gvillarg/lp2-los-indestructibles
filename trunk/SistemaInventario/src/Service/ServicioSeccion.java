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
    
    
    public ArrayList<Seccion> getSecciones() {
        Seccion seccion=null;
        secciones=new ArrayList<Seccion>();
        
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        try {
//            Driver myDriver = new com.mysql.jdbc.Driver();
//            conn = DriverManager.getConnection(connectionUrl);
//            pstmt = conn.prepareStatement("SELECT * FROM articulo; ");
//            rs =  pstmt.executeQuery();
//            System.out.println("conexion hecha: Select");
//            
//            while (rs.next()){
//                int id = rs.getInt("idArticulo");
//                String nombre = rs.getString("nombre");
//                String descripcion = rs.getString("descripcion");
//                int tipoArticulo = rs.getInt("tipoArticulo");
//                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
//                int unidad = rs.getInt("unidad"); 
//                float precio=rs.getFloat("precio");
//                int stock=rs.getInt("stock");
//                int stockMinimo=rs.getInt("stockMinimo");
//                int stockReservado=rs.getInt("stockReservado");
//                
//                articulo= new Articulo();
//                articulo.setId(id);
//                articulo.setNombre(nombre);
//                articulo.setDescripcion(descripcion);
//                articulo.setTipoArticulo(tipoArticulo);
//                articulo.setTipoAlmacenamiento(tipoAlmacenamiento);
//                articulo.setUnidad(unidad);
//                articulo.setPrecio(precio);
//                articulo.setStock(stock);
//                articulo.setStockMinimo(stockMinimo);
//                articulo.setStockReservado(stockReservado);
//                
//                articulos.add(articulo);
//            }            
//        } 
//        catch (Exception ex) {
//            ex.printStackTrace();
//        } 
//        finally {
//             //5. Se cierra la conexión
//             try {if (rs != null) rs.close(); } 
//             catch(Exception e){e.printStackTrace();}  
//        }
         return secciones;
    }
    
    
}
