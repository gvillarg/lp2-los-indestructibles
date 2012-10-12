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
            pstmt.setInt(4, Integer.parseInt(articulo.getTipoArticulo()));
            pstmt.setInt(5,Integer.parseInt(articulo.getTipoAlmacenamiento()));
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
		for (int i=0; i<getArticulos().size(); i++)
		{
			if (getArticulos().get(i).getId() == id) 
				return getArticulos().get(i);
		}
	
		return null;		
	}
    public Articulo buscarArticuloPos(int i){
		Articulo articulo=( i<articulos.size() && i>=0) ? articulos.get(i) : null;
		return articulo;
	}
    public void eliminaArticulo (int id)
	{
		for (int i=0; i<getArticulos().size(); i++)
		{
			if(getArticulos().get(i).getId() == id)
			{
				getArticulos().remove(i);
				break;
			}
		}
	}
    public void eliminaArticulo (Articulo articulo)
	{
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
    public void editarArticulo(Articulo buscado)
	{
		Articulo encontrado=  buscarArticuloId( buscado.getId()        );
		if(encontrado!=null)
		{
			encontrado.setNombre(buscado.getNombre());
			encontrado.setDescripcion(buscado.getDescripcion());
			encontrado.setPrecio(buscado.getPrecio());
                        encontrado.setUnidad(buscado.getUnidad());
			encontrado.setStock(buscado.getStock());
                        encontrado.setStockMinimo(buscado.getStockMinimo());
                        encontrado.setStockReservado(buscado.getStockReservado());
		}   
		
	}

    /**
     * @return the articulos
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }
    public ArrayList<Articulo> filtrarArticulos(String nombre){
        ArrayList<Articulo> lista=new ArrayList();
        
        for (int i=0;i<articulos.size();i++)
            if((articulos.get(i).getNombre().contains(nombre))||(articulos.get(i).getDescripcion().contains(nombre)))
                lista.add(articulos.get(i));         
        
        return lista;
    }
}
