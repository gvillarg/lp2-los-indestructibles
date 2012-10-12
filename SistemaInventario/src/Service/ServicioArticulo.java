/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Articulo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Main.Main;

/**
 *
 * @author Guti
 */
public class ServicioArticulo {
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>() ;
//    private int nextId=1;
    private String connectionUrl = "jdbc:mysql://localhost:3306/LP222?" +
                                   "user=root&password=password";
    public int getNextId(){
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
            pstmt = conn.prepareStatement("SELECT MAX(IDARTICULO) FROM ARTICULO;");//WHERE TIPO=1;
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                id = rs.getInt("max(idarticulo)"); 
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
    public int agregarArticulo(Articulo articulo){
//                articulo.setId(getNextId());
//                articulo.setStockReservado(0);
//		getArticulos().add(articulo);
        
        
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
                    "INSERT INTO ARTICULO(idArticulo,nombre,descripcion, "
                    +"tipoArticulo,tipoAlmacenamiento,unidad,precio,stock,stockMinimo,stockReservado) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, getNextId());
            pstmt.setString(2, articulo.getNombre());
            pstmt.setString(3, articulo.getDescripcion());
            pstmt.setInt(4, articulo.getTipoArticulo());
            pstmt.setInt(5,articulo.getTipoAlmacenamiento());
            pstmt.setInt(6,articulo.getUnidad());
            pstmt.setFloat(7, articulo.getPrecio());
            pstmt.setInt(8,articulo.getStock());
            pstmt.setInt(9,articulo.getStockMinimo());
            pstmt.setInt(10,articulo.getStock());
                    
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
    public Articulo buscarArticuloId (int id){
//		for (int i=0; i<getArticulos().size(); i++)
//		{
//			if (getArticulos().get(i).getId() == id) 
//				return getArticulos().get(i);
//		}
//	
//		return null;	
        
        
        
        Articulo articulo=null;
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
            pstmt = conn.prepareStatement("SELECT * FROM Articulo WHERE IDARTICULO=?");//WHERE TIPO=1;
            pstmt.setInt(1, id);
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                String nombre = rs.getString("NOMBRE");
                String descripcion = rs.getString("DESCRIPCION");
                int tipoArticulo = rs.getInt("TIPOARTICULO");
                int tipoAlmacenamiento = rs.getInt("TIPOALMACENAMIENTO");
                int unidad = rs.getInt("UNIDAD"); 
                float precio=rs.getFloat("PRECIO");
                int stock=rs.getInt("STOCK");
                int stockMinimo=rs.getInt("STOCKMINIMO");
                int stockReservado=rs.getInt("STOCKRESERVADO");
                
                articulo= new Articulo();
                articulo.setId(id);
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setTipoArticulo(tipoArticulo);
                articulo.setTipoAlmacenamiento(tipoAlmacenamiento);
                articulo.setUnidad(unidad);
                articulo.setPrecio(precio);
                articulo.setStock(stock);
                articulo.setStockMinimo(stockMinimo);
                articulo.setStockReservado(stockReservado);
                
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
        return articulo; 
    }
    public Articulo buscarArticuloPos(int i){
		Articulo articulo=( i<articulos.size() && i>=0) ? articulos.get(i) : null;
		return articulo;
	}
    public int eliminaArticulo (int id)	{
//		for (int i=0; i<getArticulos().size(); i++)
//		{
//			if(getArticulos().get(i).getId() == id)
//			{
//				getArticulos().remove(i);
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
            String SQLString = "DELETE FROM ARTICULO WHERE IDARTICULO=? LIMIT 1;";
            
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
    public void eliminaArticulo (Articulo articulo)	{
            int id=articulo.getId();
            eliminaArticulo(id);
		/*for (int i=0; i<articulos.size(); i++)
		{
			if(product.getId() == articu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public int editarArticulo(Articulo articulo) {
        
////		Articulo encontrado=  buscarArticuloId( buscado.getId()        );
////		if(encontrado!=null)
////		{
////			encontrado.setNombre(buscado.getNombre());
////			encontrado.setDescripcion(buscado.getDescripcion());
////			encontrado.setPrecio(buscado.getPrecio());
////                        encontrado.setUnidad(buscado.getUnidad());
////			encontrado.setStock(buscado.getStock());
////                        encontrado.setStockMinimo(buscado.getStockMinimo());
////                        encontrado.setStockReservado(buscado.getStockReservado());
////		}   
            
            
            
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
                     " UPDATE ARTICULO "
                    +" SET nombre=?,descripcion=?,tipoArticulo=?,tipoAlmacenamiento=?,"
                    +"unidad=?,precio=?,stock=?,stockMinimo=?,stockReservado=?"
                    +" WHERE IDARTICULO=?;";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setString(1, articulo.getNombre());
            pstmt.setString(2, articulo.getDescripcion());
            pstmt.setInt(3, articulo.getTipoArticulo());
            pstmt.setInt(4,articulo.getTipoAlmacenamiento());
            pstmt.setInt(5,articulo.getUnidad());
            pstmt.setFloat(6, articulo.getPrecio());
            pstmt.setInt(7,articulo.getStock());
            pstmt.setInt(8,articulo.getStockMinimo());
            pstmt.setInt(9,articulo.getStockReservado());
            pstmt.setInt(10,articulo.getId());
                   
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
    public ArrayList<Articulo> getArticulos() {
//        return articulos;
        
        Articulo articulo=null;
        articulos=new ArrayList<Articulo>();
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
            pstmt = conn.prepareStatement("SELECT * FROM ARTICULO ");
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            while (rs.next()){
                int id = rs.getInt("IDARTICULO");
                String nombre = rs.getString("NOMBRE");
                String descripcion = rs.getString("DESCRIPCION");
                int tipoArticulo = rs.getInt("TIPOARTICULO");
                int tipoAlmacenamiento = rs.getInt("TIPOALMACENAMIENTO");
                int unidad = rs.getInt("UNIDAD"); 
                float precio=rs.getFloat("PRECIO");
                int stock=rs.getInt("STOCK");
                int stockMinimo=rs.getInt("STOCKMINIMO");
                int stockReservado=rs.getInt("STOCKRESERVADO");
                
                articulo= new Articulo();
                articulo.setId(id);
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setTipoArticulo(tipoArticulo);
                articulo.setTipoAlmacenamiento(tipoAlmacenamiento);
                articulo.setUnidad(unidad);
                articulo.setPrecio(precio);
                articulo.setStock(stock);
                articulo.setStockMinimo(stockMinimo);
                articulo.setStockReservado(stockReservado);
                
                articulos.add(articulo);
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
        return articulos;    
        
    }
    public ArrayList<Articulo> filtrarArticulos(String cadena,int tipoArt,int tipoAlm,int precioMin,int precioMax){
        ArrayList<Articulo> lista=new ArrayList();
        
//        for (int i=0;i<articulos.size();i++)
//            if((articulos.get(i).getNombre().contains(nombre))||(articulos.get(i).getDescripcion().contains(nombre)))
//                lista.add(articulos.get(i));         
//        
//        return lista;
//      
        int param=1;
        Articulo articulo=null;
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
            String SQLString="SELECT * FROM ARTICULO WHERE (NOMBRE LIKE ? "
                    +" OR DESCRIPCION like ? ) AND PRECIO>=? AND PRECIO<=? ";
            if(tipoArt!= Main.tipoArticulo.length)
                SQLString=SQLString.concat(" AND TIPOARTICULO=?");
            if(tipoAlm!= Main.tipoAlmacenamiento.length)
                SQLString=SQLString.concat(" AND TIPOALMACENAMIENTO=?");

            pstmt = conn.prepareStatement(SQLString);
            
            if (cadena!=null){
                pstmt.setString(param++,"%"+cadena+"%");
                pstmt.setString(param++,"%"+cadena+"%");
            }
            else{
                pstmt.setString(param++,"%");
                pstmt.setString(param++,"%");
            }
            pstmt.setInt(param++,precioMin);
            pstmt.setInt(param++,precioMax);
            if(tipoArt!= Main.tipoArticulo.length){
                pstmt.setInt(param++,tipoArt);
            }
            if(tipoAlm!=Main.tipoAlmacenamiento.length)
                pstmt.setInt(param++,tipoAlm);
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            while (rs.next()){
                int id = rs.getInt("IDARTICULO");
                String nombre = rs.getString("NOMBRE");
                String descripcion = rs.getString("DESCRIPCION");
                int tipoArticulo = rs.getInt("TIPOARTICULO");
                int tipoAlmacenamiento = rs.getInt("TIPOALMACENAMIENTO");
                int unidad = rs.getInt("UNIDAD"); 
                float precio=rs.getFloat("PRECIO");
                int stock=rs.getInt("STOCK");
                int stockMinimo=rs.getInt("STOCKMINIMO");
                int stockReservado=rs.getInt("STOCKRESERVADO");
                
                articulo= new Articulo();
                articulo.setId(id);
                articulo.setNombre(nombre);
                articulo.setDescripcion(descripcion);
                articulo.setTipoArticulo(tipoArticulo);
                articulo.setTipoAlmacenamiento(tipoAlmacenamiento);
                articulo.setUnidad(unidad);
                articulo.setPrecio(precio);
                articulo.setStock(stock);
                articulo.setStockMinimo(stockMinimo);
                articulo.setStockReservado(stockReservado);
                
                lista.add(articulo);
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
        return lista;    
        
        
    }
}
