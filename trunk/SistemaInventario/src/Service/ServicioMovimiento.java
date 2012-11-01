/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Articulo;
import Beans.Movimiento;
import Beans.DetalleMovimiento;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Enrique Carrion
 */
public class ServicioMovimiento {
     private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
                                   "user=inf282g1&password=anillo";
     private ServicioArticulo sart=new ServicioArticulo();
     
     public void agregarMovimiento(Movimiento mov){
		
	}
     
     private int getNextId(Connection c) throws SQLException{
        int nextId=0;
        PreparedStatement pstmt = c.prepareStatement("SELECT MAX(idMovimiento) FROM movimiento;");
        ResultSet rs =  pstmt.executeQuery();
         //4. Se evalúan los resultados
        if (rs.next()){
//                int id = rs.getInt("IdEmpresa");
                nextId = rs.getInt("max(idMovimiento)"); 
            }  
        rs.close();
        return nextId;
    }
     public Movimiento buscarMovId (int id){
         Movimiento hallado=null;
         Connection conn = null;
          PreparedStatement pstmt = null;
          try
          {
              Driver myDriver = new com.mysql.jdbc.Driver();
              conn = DriverManager.getConnection(connectionUrl);
              String cadsql="Select * from movimiento where idMovimiento= ?;";
              pstmt = conn.prepareStatement(cadsql);
              pstmt.setInt(1, getNextId(conn));
              //obteniendo resultados
              ResultSet rs=pstmt.executeQuery();
              while(rs.next())
              {
                  /*obtenido dato de movimiento, generar el movimiento. 
                  Será sólo una iteracion en caso de hallar movimiento*/
                  hallado=new Movimiento();
                  hallado.setId(rs.getInt("idMovimiento"));
                  hallado.setFecha(rs.getDate("fecha"));
                  hallado.setTipoMovimiento(rs.getInt("tipoMovimiento"));
                  /*
  `pedido` 
  `idGuia_Remision
                   */
                  this.buscadetalle(hallado, conn);
                  rs.close();
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

     private void buscadetalle(Movimiento mov, Connection cone) throws SQLException
     {
         //método encargado de dar detalles de movimiento
          PreparedStatement pstmt = null;
         ArrayList<DetalleMovimiento> detalles=new ArrayList<DetalleMovimiento>();
          String cadsql="Select * from detalle_movimiento where idMovimiento= ?;";
          pstmt = cone.prepareStatement(cadsql);
          pstmt.setInt(1, mov.getId());
          ResultSet rs=pstmt.executeQuery();
          //hallado detalle
          while(rs.next())
          {
            DetalleMovimiento dm=new DetalleMovimiento();
            dm.setCantidad(rs.getInt("cantidad"));
            Articulo art=sart.buscarArticuloId(rs.getInt("idArticulo"));
            dm.setArticulo(art);
            detalles.add(dm);
          }
          rs.close();
         mov.setDetalle(detalles);
     }
     
	//buscamos
	/*public Movimiento buscarMovPos(int i){
		Movimiento mov=( i<movims.size() && i>=0) ? movims.get(i) : null;
		return mov;
	}*/

        //eliminamos un pedido por su id
	public void eliminaMov (int id)
	{
		/*for (int i=0; i<movims.size(); i++)
		{
			if(movims.get(i).getId() == id)
			{
				movims.remove(i);
				break;
			}
		}*/
	}

	//eliminamos un pedido por Objeto
	public void eliminaMov (Movimiento mov)
	{
		/*for (int i=0; i<movims.size(); i++)
		{
			if(movims.get(i).getId() == mov.getId()    )
			{
				movims.remove(i);
				break;
			}
		}*/
	}

	public void editarMov(Movimiento mov)
	{
		/*Movimiento mhallado=buscarMovId(mov.getId());
		if(mhallado==null)
		{	return;
		}
		else
		{
			mhallado.setFecha(mov.getFecha());
			mhallado.setTipoPedido(mov.getTipoPedido());

		}*/

	}

        public ArrayList<Movimiento> getMovs() {
        //hallo todos los movimientosde que esten en la base de datos
        ArrayList<Movimiento> movims;
        Connection conn = null;
          PreparedStatement pstmt = null;
          try
          {
              Driver myDriver = new com.mysql.jdbc.Driver();
              conn = DriverManager.getConnection(connectionUrl);
              String cadsql="Select * from movimiento;";
              pstmt = conn.prepareStatement(cadsql);
              //obteniendo resultados
              ResultSet rs=pstmt.executeQuery();
              movims = new ArrayList<Movimiento>();
              while(rs.next())
              {
                  Movimiento hallado=new Movimiento();
                  hallado.setId(rs.getInt("idMovimiento"));
                  hallado.setFecha(rs.getDate("fecha"));
                  hallado.setTipoMovimiento(rs.getInt("tipoMovimiento"));
                  /*
  `pedido` 
  `idGuia_Remision
                   */
                  this.buscadetalle(hallado, conn);
                  rs.close();
              }
              conn.close();
          }
          catch(SQLException e)
          {
              e.printStackTrace();
              movims=null;
          }
          
          
        return movims;
    }
}
