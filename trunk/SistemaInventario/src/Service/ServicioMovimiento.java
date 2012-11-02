/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Service;
import Beans.Articulo;
import Beans.Movimiento;
import Beans.Pedido;
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
                  Pedido p=new Pedido();
                  p.setId(rs.getInt("pedido"));
                  hallado.setPedido(p);
                  /*
  `` 
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
 

        //eliminamos un pedido por su id
	public void eliminaMov (int id)
	{
		Movimiento m=this.buscarMovId(id);
                this.eliminaMov(m);
	}

	//eliminamos un pedido por Objeto
	public void eliminaMov (Movimiento mov)
	{
            Connection conn = null;
            PreparedStatement pstmt = null;
            try
            {
                Driver myDriver = new com.mysql.jdbc.Driver();
                conn = DriverManager.getConnection(connectionUrl);
                String cadsql="DELETE movimiento WHERE idMovimiento=?;";
                mov.setId(mov.getId());
                pstmt = conn.prepareStatement(cadsql);
                pstmt.setInt(1, mov.getId());
                pstmt.executeUpdate();
                /*dado que hay llave foranea y establecimos que la eliminacion sea en cascada
                se borrara los detalles de este movimiento en la tabla detalles*/
                conn.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
	}

        public void insertarMov(Movimiento mov)
        {
            //Inserto el movimiento
             Connection conn = null;
          PreparedStatement pstmt = null;
          try
          {
              Driver myDriver = new com.mysql.jdbc.Driver();
              conn = DriverManager.getConnection(connectionUrl);
              String cadsql="INSERT INTO movimiento values(?, ?, ?, ?, ?);";
              mov.setId(this.getNextId(conn));
              pstmt = conn.prepareStatement(cadsql);
              pstmt.setInt(1, mov.getId());
              pstmt.setDate(2,new java.sql.Date(mov.getFecha().getTime()) );
              pstmt.setInt(3, mov.getTipoMovimiento());
              pstmt.setInt(4, mov.getPedido().getId());
              pstmt.setInt(5, 1);
              pstmt.executeUpdate();
              //vel e caso de los detalles
              actualizardetalle(mov.getDetalle(),mov.getId() ,conn);
          }
          catch(Exception e){}
        }
        
        private void actualizardetalle(ArrayList<DetalleMovimiento> det, int idmov, Connection conex) throws SQLException
        {
            //primero elimino los detalles de este elemeneto
             String cadsql;
            PreparedStatement pstmt = null;
            cadsql="Delete detalle_movimiento Where idMovimiento=?;";
            pstmt = conex.prepareStatement(cadsql);
            pstmt.setInt(1, idmov);
            pstmt.executeUpdate();
            //una vez eliminado, procede con el insert
            cadsql="insert into detalle_movimiento (cantidad, idArticulo, idMovimiento) values(?, ?, ?);";
            pstmt=conex.prepareStatement(cadsql);
            for(DetalleMovimiento dm : det)
            {
                pstmt.setInt(1,dm.getCantidad());
                pstmt.setInt(2, dm.getArticulo().getId());
                pstmt.setInt(3, idmov);
                pstmt.executeUpdate();
            }
        }
        
	public void editarMov(Movimiento mov)
	{
            //procedo con la edicion
            Connection conn = null;
            PreparedStatement pstmt = null;
            try
            {
                Driver myDriver = new com.mysql.jdbc.Driver();
                conn = DriverManager.getConnection(connectionUrl);
                String cadsql="Update movimiento set fecha=?, tipoMovimiento=?, pedido=? WHERE idMovimiento=?;";
                pstmt=conn.prepareStatement(cadsql);
                pstmt.setDate(1,new java.sql.Date(mov.getFecha().getTime()) );
                pstmt.setInt(2, mov.getTipoMovimiento());
                pstmt.setInt(3, mov.getPedido().getId());
                pstmt.setInt(4, mov.getId());
                pstmt.executeUpdate();
                //ejecutamos la edicion de los detalles
                actualizardetalle(mov.getDetalle(),mov.getId() ,conn);
            }
            catch(Exception e){e.printStackTrace();}
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
                  Pedido p=new Pedido();
                  p.setId(rs.getInt("pedido"));
                  hallado.setPedido(p);
                  /*
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
