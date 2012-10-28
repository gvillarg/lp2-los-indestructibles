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
          
          int result =0;
          Connection conn = null;
          PreparedStatement pstmt = null;
         try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            //2. Se abre la conexión
            conn = DriverManager.getConnection(connectionUrl);
            //3. Se ejecuta la sentencia SQL
            String SQLString =
                    "INSERT INTO LOTE(idLote,cantidad, fechaIngreso,fechaCaducidad,saldo,idArticulo) "
                    + "VALUES(?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setInt(1, getNextId(conn));
            pstmt.setInt(2,lt.getCantidad());
            pstmt.setDate(3, (java.sql.Date)lt.getFechaIngreso());
            pstmt.setDate(4, (java.sql.Date)lt.getFechaCaducidad());
            pstmt.setInt(5, lt.getSaldo());    
            pstmt.setInt(6, lt.getArticulo().getId());               
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
              String cadsql="Select * from inf282g1.lote where id= ?;"; 
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
