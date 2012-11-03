/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Beans.GuiaRemision;
import Beans.DetalleGuiaRemision;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

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
            //pstmt.setDate(2, );
            pstmt.setString(3,guiaRemision.getOrigen());
            pstmt.setString(4, guiaRemision.getDestino());
            pstmt.setFloat(5, guiaRemision.getTotal());
            pstmt.setInt(6, guiaRemision.getCliente().getId());
                    
            result =  pstmt.executeUpdate(); 
            if (result == 0)
                throw new Exception();
     
            System.out.println("conexion hecha: agregarGuiaRemision");
            DetalleGuiaRemision detalle=null;
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
		for (int i=0; i<getGuiasRemision().size(); i++)
		{
			if (getGuiasRemision().get(i).getId() == id) 
				return getGuiasRemision().get(i);
		}
	
		return null;		
	}
    public GuiaRemision buscarGuiaRemisionPos(int i){
		GuiaRemision guiaRemision=( i<getGuiasRemision().size() && i>=0) ? getGuiasRemision().get(i) : null;
		return guiaRemision;
	}
    public void eliminaGuiaRemision (int id)
	{
		for (int i=0; i<getGuiasRemision().size(); i++)
		{
			if(getGuiasRemision().get(i).getId() == id)
			{
				getGuiasRemision().remove(i);
				break;
			}
		}
	}
    public void eliminaGuiaRemision (GuiaRemision guiaRemision)
	{
            int id=guiaRemision.getId();
            eliminaGuiaRemision(id);
		/*for (int i=0; i<guiasRemision.size(); i++)
		{
			if(product.getId() == provicu.get(i).getId())
			{
				products.remove(i);
				break;
			}
		}*/
	}
    public void editarGuiaRemision(GuiaRemision buscado)
	{
		GuiaRemision guiaRemision=  buscarGuiaRemisionId( buscado.getId()        );
		if(guiaRemision!=null) 
		{
			guiaRemision.setId(            buscado.getId());
			guiaRemision.setCliente(           buscado.getCliente());
			guiaRemision.setFecha(   buscado.getFecha());
			guiaRemision.setTotal(       buscado.getTotal());
		}
		
	}

    /**
     * @return the guiasRemision
     */
    public ArrayList<GuiaRemision> getGuiasRemision() {
        return guiasRemision;
    }     
}
