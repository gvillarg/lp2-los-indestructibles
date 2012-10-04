/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author Guti
 */
public abstract class Empresa {
    private int id;
    private int ruc;
    private String razonSocial;
    private String webPage;
    private String pais;
    private String rubro;
    private String nombreContacto;
    private int telefonoContacto;
    private String emailContacto;

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
     * @return the ruc
     */
    public int getRuc() {
        return ruc;
    }

    /**
     * @param ruc the ruc to set
     */
    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    /**
     * @return the razonSocial
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     * @param razonSocial the razonSocial to set
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     * @return the webPage
     */
    public String getWebPage() {
        return webPage;
    }

    /**
     * @param webPage the webPage to set
     */
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * @return the rubro
     */
    public String getRubro() {
        return rubro;
    }

    /**
     * @param rubro the rubro to set
     */
    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    /**
     * @return the nombreContacto
     */
    public String getNombreContacto() {
        return nombreContacto;
    }

    /**
     * @param nombreContacto the nombreContacto to set
     */
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    /**
     * @return the telefonoContacto
     */
    public int getTelefonoContacto() {
        return telefonoContacto;
    }

    /**
     * @param telefonoContacto the telefonoContacto to set
     */
    public void setTelefonoContacto(int telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    /**
     * @return the emailContacto
     */
    public String getEmailContacto() {
        return emailContacto;
    }

    /**
     * @param emailContacto the emailContacto to set
     */
    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }
}
