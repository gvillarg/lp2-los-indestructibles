/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Almacen;
import Beans.Seccion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author enrique
 */
public class ServicioAlmacen {
    private ArrayList<Almacen> almacenes = new ArrayList<Almacen>();
    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" + "user=inf282g1&password=anillo";
    //private int nextId=1;


    public void agregarAlmacen(Almacen almacen){
         Connection conn = null;
        PreparedStatement pstmt = null;
        try
        {
             Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            //generar codigo de almacen
           // almacen.setId(dameid(conn));
            //3. Se ejecuta la sentencia SQL
            pstmt = conn.prepareStatement("insert into almacen values(?, ?, ?); ");
            pstmt.setInt(1, almacen.getId());
            pstmt.setString(2, almacen.getDireccion());
            pstmt.setInt(3, Integer.parseInt(almacen.getArea()) );
            pstmt.executeUpdate();
            //evaluando las areas
            ArrayList<Seccion>secciones=new ArrayList<Seccion>();
            System.out.println("Insertando las secciones "+secciones.size());
            for(Seccion s: secciones)
            {
                s.setIdalmacen(almacen.getId());
                System.out.println("almacen "+almacen.getId());
                Main.Main.servicioSeccion.agregarSeccion(s);
            }
            System.out.println("finalizando insercion");
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión
             try {if (conn != null) conn.close(); } 
             catch(Exception e){e.printStackTrace();}  
        }
        
    }
    
   /* private int dameid(Connection c) throws SQLException
    {
                PreparedStatement pstmt = c.prepareStatement("select max(idAlmacen) from almacen; ");
                ResultSet rs=pstmt.executeQuery();
                int r=rs.getInt("max(idAlmacen)");
                rs.close();
                return r+1;
    }*/
    public Almacen buscarAlmacenId (int id){
		for (int i=0; i<getAlmacenes().size(); i++)
		{
			if (getAlmacenes().get(i).getId() == id)
				return getAlmacenes().get(i);
		}

		return null;
	}
    public Almacen buscarAlmacenPos(int i){
		Almacen almacen=( i<getAlmacenes().size() && i>=0) ? getAlmacenes().get(i) : null;
		return almacen;
	}
    public void eliminaAlmacen (int id)
	{
		for (int i=0; i<getAlmacenes().size(); i++)
		{
			if(getAlmacenes().get(i).getId() == id)
			{
				getAlmacenes().remove(i);
				break;
			}
		}
	}
    public void eliminaAlmacen (Almacen almacen)
	{
            int id=almacen.getId();
            eliminaAlmacen(id);
	}
    public void editarAlmacen(Almacen buscado)
	{
		Almacen almacen=  buscarAlmacenId( buscado.getId()        );
		if(almacen!=null)
		{
			almacen.setId(            buscado.getId());
			almacen.setDireccion(           buscado.getDireccion());
			almacen.setArea(   buscado.getArea());
		}

	}

    /**
     * @return the almacenes
     */
    public ArrayList<Almacen> getAlmacenes() {
        
         Almacen almacen=null;
        almacenes=new ArrayList<Almacen>();
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
            pstmt = conn.prepareStatement("SELECT * FROM almacen; ");
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            while (rs.next()){
                int id = rs.getInt("idalmacen");
                String direccion = rs.getString("direccion");
                int area = rs.getInt("area");
                
                almacen= new Almacen();
                almacen.setId(id);
                almacen.setDireccion(direccion);
                almacen.setArea(String.format("%d",area));
                almacenes.add(almacen);
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
        return almacenes;    
    }

        public ArrayList<Almacen> getAlmacenes(String _query) {
        
         Almacen almacen=null;
        almacenes=new ArrayList<Almacen>();
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
            pstmt = conn.prepareStatement("SELECT * FROM almacen WHERE direccion LIKE ? ");
            pstmt.setString(1, "%"+_query+"%");
            rs =  pstmt.executeQuery();
            
            //4. Se evalúan los resultados
            while (rs.next()){
                int id = rs.getInt("idalmacen");
                String direccion = rs.getString("direccion");
                int area = rs.getInt("area");
                
                almacen= new Almacen();
                almacen.setId(id);
                almacen.setDireccion(direccion);
                almacen.setArea(String.format("%d",area));
                almacenes.add(almacen);
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
        return almacenes;    
    }

    
}
