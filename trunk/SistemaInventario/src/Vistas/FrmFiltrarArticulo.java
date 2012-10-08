/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.table.AbstractTableModel;
import Main.Main;
import java.util.ArrayList;
import Beans.Articulo;
/**
 *
 * @author Guti
 */
public class FrmFiltrarArticulo extends javax.swing.JInternalFrame {    
    private ArrayList<Articulo> articulos=Main.servicioArticulo.getArticulos();
    class ArticuloTableModel extends AbstractTableModel{
        
        String [] nombreColumna = {"Código", "Nombre","Descripción", "Precio", "Stock", "Stock Mínimo", "Stock Reservado"};
        
        @Override
        public int getRowCount() {
            return articulos.size();
        }

        @Override
        public int getColumnCount() {
            return 7;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Articulo articulo=articulos.get(rowIndex);
            switch(columnIndex){
                case 0: return "" + articulo.getId();
                case 1: return articulo.getNombre();
                case 2: return articulo.getDescripcion();
                case 3: return "" + articulo.getPrecio();
                case 4: return "" + articulo.getStock();
                case 5: return "" + articulo.getStockMinimo();                    
                case 6: return "" + articulo.getStockReservado();
            }
            return null;
        }
        @Override
        public String getColumnName(int columna){
            return nombreColumna[columna];
        }
        
        
    }
   
    private ArticuloTableModel articuloTableModel=new ArticuloTableModel();
    private Articulo articuloSeleccionado=null;
    
    public void actualizarTabla(){
        articulos = Main.servicioArticulo.getArticulos();
        articuloTableModel.fireTableChanged(null);
    }
    
    public FrmFiltrarArticulo() {
        initComponents();
        tablaArticulos.setModel(articuloTableModel); 
        this.setClosable(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        txtFiltrarNombre = new javax.swing.JTextField();
        btnMostrar = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Articulos");

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista Articulos"));
        jPanel2.setLayout(new java.awt.BorderLayout());

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaArticulos.setMinimumSize(new java.awt.Dimension(60, 100));
        tablaArticulos.setShowVerticalLines(false);
        tablaArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaArticulosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaArticulos);

        jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnMostrar.setText("Mostrar Todo");
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 351, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(35, 35, 35)
                        .add(btnNuevo)
                        .add(18, 18, 18)
                        .add(btnEditar)
                        .add(18, 18, 18)
                        .add(btnEliminar))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(40, 40, 40)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(btnFiltrar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 127, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(btnMostrar))
                            .add(txtFiltrarNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 273, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(txtFiltrarNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnFiltrar)
                    .add(btnMostrar))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 284, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnNuevo)
                    .add(btnEditar)
                    .add(btnEliminar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (articuloSeleccionado!=null){
            Main.servicioArticulo.eliminaArticulo(articuloSeleccionado);
            actualizarTabla();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tablaArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaArticulosMouseClicked
        int i=tablaArticulos.getSelectedRow();
        articuloSeleccionado = Main.servicioArticulo.buscarArticuloPos(i);
    }//GEN-LAST:event_tablaArticulosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(articuloSeleccionado!=null){
            FrmArticulo frmArticulo=new FrmArticulo(articuloSeleccionado);
            Main.agregarVentana(frmArticulo);
            frmArticulo.setVisible(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        actualizarTabla();      
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        articulos=Main.servicioArticulo.filtrarArticulos(txtFiltrarNombre.getText().toString());
        articuloTableModel.fireTableChanged(null);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        FrmArticulo frmArticulo=new FrmArticulo(null);
        Main.agregarVentana(frmArticulo);
        frmArticulo.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFiltrarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFiltrarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFiltrarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFiltrarArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmFiltrarArticulo().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JTextField txtFiltrarNombre;
    // End of variables declaration//GEN-END:variables
}