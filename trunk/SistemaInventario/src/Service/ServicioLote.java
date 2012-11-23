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
    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
                                   "user=inf282g1&password=anillo";
     private ArrayList<Lote> lotes = new ArrayList<Lote>() ;  

      private int getNextId(Connection c) throws SQLException{
        int nextId=0;
        PreparedStatement pstmt = c.prepareStatement("SELECT MAX(IDLOTE) FROM lote;");
        ResultSet rs =  pstmt.executeQuery();
         //4. Se evalúan los resultados
        if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                nextId = rs.getInt("max(idLote)")+1; 
            }  
        rs.close();
        return nextId;
    }

      public void agregarLote(Lote lt){
          
          int result =0;
          Connection conn = null;
          PreparedStatement pstmt = null;
         try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString ="{call Agregalote(?,?,?,?,?)}";
                   // "INSERT INTO lote(cantidad, fechaIngreso,fechaCaducidad,saldo,idArticulo) "
                    //+ "VALUES(?,?,?,?,?);";
            pstmt = conn.prepareCall(SQLString);
            //pstmt.setInt(1, getNextId(conn));
            pstmt.setInt(1,lt.getCantidad());
            pstmt.setDate(2,new java.sql.Date(lt.getFechaIngreso().getTime()) );
            pstmt.setDate(3, new java.sql.Date(lt.getFechaCaducidad().getTime()) );
            pstmt.setInt(4, lt.getSaldo());    
            pstmt.setInt(5, lt.getArticulo().getId());            
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
              String cadsql="Select * from lote where idLote= ?;"; 
              pstmt = conn.prepareStatement(cadsql);
              pstmt.setInt(1, getNextId(conn));
              //obteniendo resultados
              ResultSet rs=pstmt.executeQuery();
              while(rs.next())
              {
                  hallado=new Lote();
                  int idart=rs.getInt("idArticulo");
                  Articulo art=Main.servicioArticulo.buscarArticuloId(idart);
                  hallado.setId(rs.getInt("idLote"));
                  hallado.setCantidad(rs.getInt("cantidad"));
                  hallado.setArticulo(art);
                  hallado.setFechaCaducidad(rs.getDate("fechaCaducidad"));
                  hallado.setFechaIngreso(rs.getDate("fechaingreso"));
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
