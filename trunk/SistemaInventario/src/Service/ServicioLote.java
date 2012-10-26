/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Lote;
import Beans.Articulo;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.*;
import Main.Main;
import java.util.HashSet;
import java.util.Set;
 /*
 * @author Enrique Carrion
 */
public class ServicioLote {
    private String connectionUrl = "jdbc:mysql://localhost:3306/LP282g1?" +
                                   "user=lp282g1&password=anillo";
     private ArrayList<Lote> lotes = new ArrayList<Lote>() ;  

      private int getNextId(Connection c) throws SQLException{
        int nextId=0;
        PreparedStatement pstmt = c.prepareStatement("SELECT MAX(IDLOTE) FROM LOTE;");
        ResultSet rs =  pstmt.executeQuery();
         //4. Se evalúan los resultados
        if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                nextId = rs.getInt("max(idarticulo)"); 
            }  
        rs.close();
        return nextId;
    }

      public void agregarLote(Lote lt){
          
          /*lt.setId(nextId++);
		lotes.add(lt);*/
          int result =0;
          Connection conn = null;
          PreparedStatement pstmt = null;
         try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString =
                    "INSERT INTO LOTE(idlote,fingreso,fcaducidad,idarticulo,cantidad,saldo) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, getNextId(conn));
            pstmt.setDate(2, (java.sql.Date)lt.getFechaIngreso());
            pstmt.setDate(3, (java.sql.Date)lt.getFechaCaducidad());
            pstmt.setInt(4, lt.getArticulo().getId());
            pstmt.setInt(5,lt.getCantidad());
            pstmt.setInt(6, lt.getSaldo());                    
            result =  pstmt.executeUpdate();
            conn.close();
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
         
    }

      public Lote buscarLoteId (int id){
          Lote hallado=null;
          Connection conn = null;
          PreparedStatement pstmt = null;
          try
          {
              Driver myDriver = new com.mysql.jdbc.Driver();
              //2. Se abre la conexión
              conn = DriverManager.getConnection(connectionUrl);
              String cadsql="Select * from Lote where id= ?;"; 
              pstmt = conn.prepareStatement(cadsql);
              pstmt.setInt(1, getNextId(conn));
              //obteniendo resultados
              ResultSet rs=pstmt.executeQuery();
              while(rs.next())
              {
                  hallado=new Lote();
                  int idart=rs.getInt("idarticulo");
                  Articulo art=Main.servicioArticulo.buscarArticuloId(idart);
                  hallado.setId(rs.getInt("idlote"));
                  hallado.setCantidad(rs.getInt("cantidad"));
                  hallado.setArticulo(art);
                  hallado.setFechaCaducidad(rs.getDate("fcaducidad"));
                  hallado.setFechaIngreso(rs.getDate("fechaingeso"));
                  hallado.setSaldo(rs.getInt("saldo"));
              }
              conn.close();
          }
          catch(SQLException e)
          {
              e.printStackTrace();
              hallado=null;
          }
          return hallado;
	}
   /* public Lote buscarLotePos(int i){
		Lote lt=( i<lotes.size() && i>=0) ? lotes.get(i) : null;
		return lt;
	}

    public void eliminaLote (int id)
	{
		for (int i=0; i<lotes.size(); i++)
		{
			if(lotes.get(i).getId() == id)
			{
				lotes.remove(i);
				break;
			}
		}
	}
    public void eliminaLote(Lote lt)
	{
            int id=lt.getId();
            eliminaLote(id);
	}

    public void editarLote(Lote buscado)
	{
		Lote encontrado=  buscarLoteId( buscado.getId()        );
		if(encontrado!=null)
		{
			encontrado.setFechaCaducidad(buscado.getFechaCaducidad());
			encontrado.setFechaIngreso(buscado.getFechaIngreso());
			encontrado.setCantidad(buscado.getCantidad());
                        encontrado.setArticulo(buscado.getArticulo());
			encontrado.setSeccion(buscado.getSeccion());
                        encontrado.setSaldo(buscado.getSaldo());
		}

	}
        * */
}
