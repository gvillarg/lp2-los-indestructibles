package Service;

import Beans.Articulo;
import Beans.Cliente;
import Beans.GuiaRemision;
import Beans.DetalleGuiaRemision;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import Main.Main;

/**
 *
 * @author Guti
 */
public class ServicioGuiaRemision {
    private ArrayList<GuiaRemision> guiasRemision = null;
    private String connectionUrl = "jdbc:mysql://quilla.lab.inf.pucp.edu.pe:3306/inf282g1?" +
                                    "user=inf282g1&password=anillo";
    public int agregarGuiaRemision(GuiaRemision guiaRemision){
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;        
        
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString =
                    "INSERT INTO guia_remision "
                    + "(motivoTranslado,fecha,origen,destino,transportista,total,idCliente) "
                    + "VALUES(?,?,?,?,?,?,?);";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setString(1, guiaRemision.getMotivoTranslado());
            pstmt.setDate(2,new java.sql.Date(guiaRemision.getFecha().getTime()));
            pstmt.setString(3,guiaRemision.getOrigen());
            pstmt.setString(4, guiaRemision.getDestino());
            pstmt.setFloat(5, guiaRemision.getTotal());
            pstmt.setInt(6, guiaRemision.getCliente().getId());
                    
            result =  pstmt.executeUpdate(); 
            if (result == 0)
                throw new Exception();
     
            System.out.println("conexion hecha: agregarGuiaRemision");
            DetalleGuiaRemision detalle;
            for(int i=0;i<guiaRemision.getDetalle().size();i++){
                detalle=guiaRemision.getDetalle().get(i);
                SQLString="INSERT INTO detalle_guia_remision "
                        + "(cantidad,idArticulo,idGuiaRemision) "
                        + "VALUES(?,?,?);";
                
                pstmt=conn.prepareStatement(SQLString);
                pstmt.setInt(1, detalle.getCantidad());
                pstmt.setInt(2,detalle.getArticulo().getId());
                pstmt.setInt(3, guiaRemision.getId());
                
                result = pstmt.executeUpdate();
                if (result==0)
                    throw new Exception();     
                System.out.println("conexion hecha: agregarDetalleGuiaRemision "+i);
            }
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión 
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public GuiaRemision buscarGuiaRemisionId (int id){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null,rs_detalle=null;
        GuiaRemision guia=new GuiaRemision();
        DetalleGuiaRemision detalle=null;
        try{
            Driver driver=new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            ps=conn.prepareStatement(
                      "SELECT * FROM guia_remision"
                    + "WHERE idGuia_Remision=?;");
            ps.setInt(1, id);
            rs=ps.executeQuery();
            System.out.println("conexion hecha: buscarGuiasRemision.guia_remision");
                
            while(rs.next()){
                String motivoTraslado=rs.getString("motivoTraslado");
                Date fecha=rs.getDate("fecha");
                String origen=rs.getString("origen");
                String destino=rs.getString("destino");
                String transportista=rs.getString("transportista");
                float total=rs.getFloat("total");
                int idCliente=rs.getInt("idCliente");
                Cliente cliente=Main.servicioCliente.buscarClienteId(idCliente);
                
                guia.setId(id);
                guia.setMotivoTranslado(motivoTraslado);
                guia.setFecha(fecha);
                guia.setOrigen(origen);
                guia.setDestino(destino);
                guia.setTransportista(transportista);
                guia.setTotal(total);
                guia.setCliente(cliente);
                
                ps=conn.prepareStatement(
                        "SELECT * FROM detalle_guia_remision"
                        + "WHERE idGuia_Remision=?");
                ps.setInt(1, id);
                rs_detalle=ps.executeQuery();
                
                while(rs_detalle.next()){
                    int idDetalleGuiaRemision=rs_detalle.getInt("idDetalleGuiaRemision");
                    int cantidad=rs_detalle.getInt("cantidad");
                    int idArticulo=rs_detalle.getInt("idArticulo");
                    Articulo articulo=Main.servicioArticulo.buscarArticuloId(idArticulo);
                    
                    detalle=new DetalleGuiaRemision();
                    detalle.setId(idDetalleGuiaRemision);
                    detalle.setCantidad(cantidad);
                    detalle.setArticulo(articulo);
                    guia.agregarDetalle(detalle);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             try {if (rs_detalle != null) rs_detalle.close(); } 
             catch(Exception e){e.printStackTrace();} 
             try {if (rs != null) rs.close(); } 
             catch(Exception e){e.printStackTrace();}  
             try{if(ps!=null) ps.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return guia;
    }
    public GuiaRemision buscarGuiaRemisionPos(int i){
        getGuiasRemision();
        GuiaRemision guiaRemision=( i<getGuiasRemision().size() && i>=0) ? getGuiasRemision().get(i) : null;
        return guiaRemision;
    }
    public int eliminaGuiaRemision (int id){
        int result=0;
        Connection conn=null;
        PreparedStatement ps=null;
        
        try{
            Driver driver=new com.mysql.jdbc.Driver();
            String SqlString="DELETE FROM detalle_guia_remision "
                            + "WHERE idGuia_Remision=?; "
                            + "DELETE FROM guia_remision "
                            + "WHERE idGuia_Remision=?;";
            ps=conn.prepareStatement(SqlString);
            ps.setInt(1,id);
            ps.setInt(2, id);
            result=ps.executeUpdate();
            if(result==0)
                throw new Exception();
            System.out.println("conexion hecha: eliminarGuiaRemision");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally{
            try{ps.close();}catch(Exception e){e.printStackTrace();}
            try{conn.close();}catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public void eliminaGuiaRemision (GuiaRemision guiaRemision)	{
            int id=guiaRemision.getId();
            eliminaGuiaRemision(id);
	}
    public int editarGuiaRemision(GuiaRemision guiaRemision){
        int result =0;
        Connection conn = null;
        PreparedStatement pstmt = null;        
        
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            String SQLString ="UPDATE guia_remision "
                    + "SET motivoTranslado=?,fecha=?,origen=?,destino=?,transportista=?,total=?,idCliente=? "
                    + "WHERE idEmpresa=?";
            
            pstmt = conn.prepareStatement(SQLString);
            pstmt.setString(1, guiaRemision.getMotivoTranslado());
            pstmt.setDate(2,new java.sql.Date(guiaRemision.getFecha().getTime()));
            pstmt.setString(3,guiaRemision.getOrigen());
            pstmt.setString(4, guiaRemision.getDestino());
            pstmt.setFloat(5, guiaRemision.getTotal());
            pstmt.setInt(6, guiaRemision.getCliente().getId());
            pstmt.setInt(7, guiaRemision.getId());
                    
            result =  pstmt.executeUpdate(); 
            if (result == 0)
                throw new Exception();
     
            System.out.println("conexion hecha: editarGuiaRemision");
            DetalleGuiaRemision detalle;
            for(int i=0;i<guiaRemision.getDetalle().size();i++){
                detalle=guiaRemision.getDetalle().get(i);
                SQLString="UPDATE detalle_guia_remision "
                        + "SET cantidad=?,idArticulo=?,idGuiaRemision=? "
                        + "WHERE id=?;";
                
                pstmt=conn.prepareStatement(SQLString);
                pstmt.setInt(1, detalle.getCantidad());
                pstmt.setInt(2,detalle.getArticulo().getId());
                pstmt.setInt(3, guiaRemision.getId());
                
                result = pstmt.executeUpdate();
                if (result==0)
                    throw new Exception();     
                System.out.println("conexion hecha: editarDetalleGuiaRemision "+i);
            }
                       
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             //5. Se cierra la conexión 
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return result;
    }
    public ArrayList<GuiaRemision> getGuiasRemision() {
        Cliente cliente=null;
        GuiaRemision guiaRemision=null;
        guiasRemision=new ArrayList<GuiaRemision>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs_guia = null, rs_detalle = null;
        try {
            Driver myDriver = new com.mysql.jdbc.Driver();
            conn = DriverManager.getConnection(connectionUrl);
            pstmt = conn.prepareStatement("SELECT * FROM guia_remision,empresa "
                    +"WHERE guia_remision.idCliente=empresa.idEmpresa AND empresa.tipo=0; ");
            rs_guia =  pstmt.executeQuery();
            System.out.println("conexion hecha: getGuiasRemision.guia_remision");
            
            while (rs_guia.next()){
                int idCliente=rs_guia.getInt("idEmpresa");
                int ruc=rs_guia.getInt("ruc");
                String razonSocial=rs_guia.getString("razonSocial");
                String webPage=rs_guia.getString("webPage");
                int pais=rs_guia.getInt("pais");
                String rubro=rs_guia.getString("rubro");
                String nombreC=rs_guia.getString("nombreContacto");
                int telefonoC=rs_guia.getInt("telefonoContacto");
                String emailC=rs_guia.getString("emailContacto");  
                
                cliente= new Cliente();
                cliente.setId(idCliente);
                cliente.setRuc(ruc);
                cliente.setRazonSocial(razonSocial);
                cliente.setWebPage(webPage);
                cliente.setPais(pais);
                cliente.setRubro(rubro);
                cliente.setNombreContacto(nombreC);
                cliente.setTelefonoContacto(telefonoC);
                cliente.setEmailContacto(emailC);
                
                int id = rs_guia.getInt("idGuia_Remision");
                String motivo = rs_guia.getString("motivoTraslado");
                Date fecha = rs_guia.getDate("fecha");
                String origen=rs_guia.getString("origen");
                String destino=rs_guia.getString("destino");
                String transportista=rs_guia.getString("transportista");
                float total=rs_guia.getFloat("total");    
                
                guiaRemision=new GuiaRemision();
                guiaRemision.setId(id);
                guiaRemision.setMotivoTranslado(motivo);
                guiaRemision.setFecha(fecha);
                guiaRemision.setOrigen(origen);
                guiaRemision.setDestino(destino);
                guiaRemision.setTransportista(transportista);
                guiaRemision.setTotal(total);
                guiaRemision.setCliente(cliente);
                
                
                DetalleGuiaRemision detalle=null;
                Articulo articulo=null;
                String SQLString="SELECT * FROM detalle_guia_remision,articulo "
                                + "WHERE idGuia_Remision=?;";
                pstmt=conn.prepareStatement(SQLString);
                pstmt.setInt(1,guiaRemision.getId());
                rs_detalle= pstmt.executeQuery();
                System.out.println("conexion hecha: getGuiasRemision.detalle_guia_remision");
                for(int i=0;i<guiaRemision.getDetalle().size();i++){
                    detalle=new DetalleGuiaRemision();
                    detalle.setId(rs_detalle.getInt("idDetalleGuiaRemision"));
                    articulo=Main.servicioArticulo.buscarArticuloId(rs_detalle.getInt("idArticulo"));
                    detalle.setArticulo(articulo);
                    detalle.setCantidad(rs_detalle.getInt("cantidad"));
                    guiaRemision.agregarDetalle(detalle);
                }
                guiasRemision.add(guiaRemision);
            }            
        } 
        catch (Exception ex) {
            ex.printStackTrace();
        } 
        finally {
             try {if (rs_detalle != null) rs_detalle.close(); } 
             catch(Exception e){e.printStackTrace();} 
             try {if (rs_guia != null) rs_guia.close(); } 
             catch(Exception e){e.printStackTrace();}  
             try{if(pstmt!=null) pstmt.close();}
             catch(Exception e){e.printStackTrace();}
             try{if(conn!=null) conn.close();}
             catch(Exception e){e.printStackTrace();}
        }
        return guiasRemision;   
    }     
}
