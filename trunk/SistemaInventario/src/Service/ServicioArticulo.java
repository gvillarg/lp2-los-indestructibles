/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.Articulo;
import Beans.ListaArticulo;
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
    private String connectionUrl ="jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
"user=inf282g1&password=anillo";
//    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1"+"user=inf282g1&password=anillo";

    public int agregarArticulo(Articulo articulo){
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            System.out.println("conexion hecha: Select");

            String SQLString =
                    "INSERT INTO articulo(nombre,descripcion, "
                    +"tipoArticulo,tipoAlmacenamiento,unidad,precio,"
                    + "stock,stockMinimo) "
                    + "VALUES(?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setString(1, articulo.getNombre());
            pstmt.setString(2, articulo.getDescripcion());
            pstmt.setInt(3, articulo.getTipoArticulo());
            pstmt.setInt(4,articulo.getTipoAlmacenamiento());
            pstmt.setInt(5,articulo.getUnidad());
            pstmt.setFloat(6, articulo.getPrecio());
            pstmt.setInt(7,articulo.getStock());
            pstmt.setInt(8,articulo.getStockMinimo());
            result =  pstmt.executeUpdate();
            System.out.println("conexion hecha: Insert");

            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
             //5. Se cierra la conexión
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public Articulo buscarArticuloId (int id){
        Articulo articulo=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM articulo WHERE idArticulo=?");
            pstmt.setInt(1, id);
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");
            
            if (rs.next()){
                
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int tipoArticulo = rs.getInt("tipoArticulo");
                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
                int unidad = rs.getInt("unidad"); 
                float precio=rs.getFloat("precio");
                int stock=rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int stockReservado=rs.getInt("stockReservado");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return articulo; 
    }
    public Articulo buscarArticuloPos(int i){
		Articulo articulo=( i<articulos.size() && i>=0) ? articulos.get(i) : null;
		return articulo;
	}
    public int eliminaArticulo (int id)	{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int result=0;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString = "DELETE FROM articulo WHERE idArticulo=? LIMIT 1;";            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, id);                    
            result=pstmt.executeUpdate();
            System.out.println("conexion hecha: Delete");
            
            if (result==0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
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
    public void eliminaArticulo (Articulo articulo)	{
            int id=articulo.getId();
            eliminaArticulo(id);
	}
    public int editarArticulo(Articulo articulo) {int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString =
                     " UPDATE articulo "
                    +" SET nombre=?,descripcion=?,tipoArticulo=?,tipoAlmacenamiento=?,"
                    +"unidad=?,precio=?,stock=?,stockMinimo=?,stockReservado=?"
                    +" WHERE idArticulo=?;";
            
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
            System.out.println("conexion hecha: Update");
            
            if (result == 0){
                throw new Exception();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
             //5. Se cierra la conexión
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public ArrayList<Articulo> getArticulos() {
        Articulo articulo=null;
        articulos=new ArrayList<Articulo>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM articulo; ");
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");
            
            while (rs.next()){
                int id = rs.getInt("idArticulo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int tipoArticulo = rs.getInt("tipoArticulo");
                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
                int unidad = rs.getInt("unidad"); 
                float precio=rs.getFloat("precio");
                int stock=rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int stockReservado=rs.getInt("stockReservado");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return articulos;
    }
    public ListaArticulo getArticulosEnNivelCritico() {
        Articulo articulo=null;
        ListaArticulo lista=new ListaArticulo();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM articulo "
                    + "WHERE stock<stockMinimo*1.1 ;");
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: Select");

            while (rs.next()){
                int id = rs.getInt("idArticulo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int tipoArticulo = rs.getInt("tipoArticulo");
                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
                int unidad = rs.getInt("unidad"); 
                float precio=rs.getFloat("precio");
                int stock=rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int stockReservado=rs.getInt("stockReservado");
                
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
                
                lista.agregar(articulo);
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
    public ArrayList<Articulo> filtrarArticulos(String cadena,int tipoArt,int tipoAlm,int precioMin,int precioMax){
        ArrayList<Articulo> lista=new ArrayList();
        int param=1; //numero de parametros
        Articulo articulo=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString=   "SELECT * FROM articulo WHERE (nombre LIKE ? "
                                +" OR descripcion like ? ) AND precio>=? AND precio<=? ";
            if(tipoArt!= Main.tipoArticulo.length)
                SQLString=SQLString.concat(" AND tipoArticulo=?");
            if(tipoAlm!= Main.tipoAlmacenamiento.length)
                SQLString=SQLString.concat(" AND tipoAlmacenamiento=?");

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
            System.out.println("conexion hecha: Select");
            
            while (rs.next()){
                int id = rs.getInt("idArticulo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int tipoArticulo = rs.getInt("tipoArticulo");
                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
                int unidad = rs.getInt("unidad"); 
                float precio=rs.getFloat("precio");
                int stock=rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int stockReservado=rs.getInt("stockReservado");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        
        return lista;
        
    }
    public ArrayList<Articulo> filtrarArticulos2(int tipoArt,int tipoAlm){
        ArrayList<Articulo> lista=new ArrayList();
        int param=1; //numero de parametros
        Articulo articulo=null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString=   "SELECT * FROM articulo WHERE ";
            if(tipoArt!= Main.tipoArticulo.length)
                SQLString=SQLString.concat(" tipoArticulo=?");
            if(tipoAlm!= Main.tipoAlmacenamiento.length)
                SQLString=SQLString.concat(" AND tipoAlmacenamiento=?");

            pstmt = conn.prepareStatement(SQLString);
            
//            if (cadena!=null){
//                pstmt.setString(param++,"%"+cadena+"%");
//                pstmt.setString(param++,"%"+cadena+"%");
//            }
//            else{
//                pstmt.setString(param++,"%");
//                pstmt.setString(param++,"%");
//            }
//            pstmt.setInt(param++,precioMin);
//            pstmt.setInt(param++,precioMax);
            if(tipoArt!= Main.tipoArticulo.length){
                pstmt.setInt(param++,tipoArt);
            }
            if(tipoAlm!=Main.tipoAlmacenamiento.length)
                pstmt.setInt(param++,tipoAlm);
            rs =  pstmt.executeQuery();
            System.out.println("conexion hecha: filtrarArticulos2");
            
            while (rs.next()){
                int id = rs.getInt("idArticulo");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                int tipoArticulo = rs.getInt("tipoArticulo");
                int tipoAlmacenamiento = rs.getInt("tipoAlmacenamiento");
                int unidad = rs.getInt("unidad"); 
                float precio=rs.getFloat("precio");
                int stock=rs.getInt("stock");
                int stockMinimo=rs.getInt("stockMinimo");
                int stockReservado=rs.getInt("stockReservado");
                
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
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return lista;
    }
}
