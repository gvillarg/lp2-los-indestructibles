package Vistas;

import Beans.GuiaRemision;

/**
 *
 * @author Guti
 */
public class FrmGuiaRemision extends javax.swing.JDialog {
    FrmFiltrarGuiaRemision padre;
    GuiaRemision guiaRemision;
    public FrmGuiaRemision(FrmFiltrarGuiaRemision padre,java.awt.Frame parent, boolean modal,GuiaRemision guiaRemision) {
        super(parent, modal);
        initComponents();
        this.padre=padre;
        this.guiaRemision=guiaRemision;
    }
    public String getTitle(){
        if (guiaRemision==null)
            return "Registrar nueva Guia de Remision";
        return "Guia de Remision No. "+guiaRemision.getId();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(getTitle());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
