/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Guti
 */
public class Almacen implements Serializable {
    private int id;
    private String direccion;
    private String Area;
    private ArrayList<Seccion> secciones; //=new ArrayList <Seccion>();
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the Area
     */
    public String getArea() {
        return Area;
    }

    /**
     * @param Area the Area to set
     */
    public void setArea(String Area) {
        this.Area = Area;
    }

    /**
     * @return the secciones
     */
    public ArrayList<Seccion> getSecciones() {
        return secciones;
    }
    
    public void setSecciones(ArrayList<Seccion> secs) {
        this.secciones=secs;
        System.out.println("secciones en elemento almacen: "+secciones.size());
    }

    /**
     * @param secciones the secciones to set
     */
    //public void agregarSeccion(Seccion seccion) {
      //  this.secciones.add(seccion);
    //}
}
