/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import javax.swing.table.AbstractTableModel;
import Beans.Cliente;
import java.util.ArrayList;
import Main.Main;
import Hilos.HiloCliente;
/**
 *
 * @author Guti
 */
public class FRMCliente extends javax.swing.JInternalFrame {    
    HiloCliente hiloActualizaCliente;
    private String [] NomCol={"Id","RUC","Razon Social","Pagina Web","Pais"};
    private Cliente cliente=null;
    private ArrayList<Cliente> clientes=Main.servicioCliente.getClientes();
    private ClienteTableModel clienteTableModel=new ClienteTableModel();
    public FRMCliente() {
        initComponents();
        initCmbPais();
        tblCliente.setModel(clienteTableModel);
        txtId.setText("");
        hiloActualizaCliente=new HiloCliente(this);
        hiloActualizaCliente.start();
    }
    public void actualizarTabla(){
        clientes=Main.servicioCliente.getClientes();
        clienteTableModel.fireTableChanged(null);
    }
    public void actualizarCampos(){
        if(cliente==null){
            txtId.setText("");
            txtRuc.setText("");
            txtRazonSocial.setText("");
            txtWebPage.setText("");
            cmbPais.setSelectedIndex(0);
            txtRubro.setText("");
            txtNombreContacto.setText("");
            txtTelefonoContacto.setText("");
            txtEmailContacto.setText("");
        }
        else {
            txtId.setText(""+cliente.getId());
            txtRuc.setText(""+cliente.getRuc());
            txtRazonSocial.setText(cliente.getRazonSocial());
            txtWebPage.setText(cliente.getWebPage());
            cmbPais.setSelectedIndex(cliente.getPais());
            txtRubro.setText(cliente.getRubro());
            txtNombreContacto.setText(cliente.getNombreContacto());
            txtTelefonoContacto.setText(""+cliente.getTelefonoContacto());
            txtEmailContacto.setText(cliente.getEmailContacto());
        }
    }
//    public int cerrarVentana(){
//        hiloActualizaCliente.interrupt();
//        this.dispose();
//        return 1;
//    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        txtTelefonoContacto = new javax.swing.JTextField();
        txtEmailContacto = new javax.swing.JTextField();
        txtRuc = new javax.swing.JTextField();
        txtRazonSocial = new javax.swing.JTextField();
        txtWebPage = new javax.swing.JTextField();
        txtRubro = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnNuevo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        btnMostrarTodo = new javax.swing.JButton();
        cmbPais = new javax.swing.JComboBox();

        setClosable(true);
        setResizable(true);
        setTitle("Cliente");
        setOpaque(true);

        jLabel1.setText("RUC");

        jLabel2.setText("Razón Social");

        jLabel3.setText("Web Page");

        jLabel4.setText("País");

        jLabel5.setText("Rubro");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del Contacto"));

        jLabel7.setText("Nombre");

        jLabel6.setText("Email");

        jLabel8.setText("Teléfono");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 61, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(12, 12, 12)
                        .add(txtEmailContacto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel8)
                            .add(jLabel7))
                        .add(18, 18, 18)
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtNombreContacto, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .add(txtTelefonoContacto))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtNombreContacto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel7))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtTelefonoContacto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel8))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtEmailContacto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel6))
                .add(19, 19, 19))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel9.setText("ID");

        txtId.setEditable(false);

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        btnMostrarTodo.setText("Mostrar Todo");
        btnMostrarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodoActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(jLabel2)
                            .add(jLabel3)
                            .add(jLabel4)
                            .add(jLabel5)
                            .add(jLabel9))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(txtRuc)
                            .add(txtRazonSocial)
                            .add(txtWebPage)
                            .add(txtRubro, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .add(txtId)
                            .add(cmbPais, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(43, 43, 43))))
            .add(jPanel1Layout.createSequentialGroup()
                .add(46, 46, 46)
                .add(btnNuevo)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnGuardar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnEliminar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnFiltrar)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(btnMostrarTodo)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .add(7, 7, 7)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel9)
                            .add(txtId, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel1)
                            .add(txtRuc, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel2)
                            .add(txtRazonSocial, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(txtWebPage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel4)
                            .add(cmbPais, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(12, 12, 12)
                        .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(txtRubro, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel5))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 30, Short.MAX_VALUE)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnNuevo)
                    .add(btnGuardar)
                    .add(btnEliminar)
                    .add(btnMostrarTodo)
                    .add(btnFiltrar))
                .add(18, 18, 18)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 223, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(16, 16, 16))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        cliente=null;
        actualizarCampos();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        cliente=clientes.get(tblCliente.getSelectedRow());
        actualizarCampos();
    }//GEN-LAST:event_tblClienteMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Cliente nuevo=new Cliente();
        nuevo.setRuc(Integer.parseInt(txtRuc.getText()));
        nuevo.setRazonSocial(txtRazonSocial.getText());
        nuevo.setWebPage(txtWebPage.getText());
        nuevo.setPais(cmbPais.getSelectedIndex());
        nuevo.setRubro(txtRubro.getText());
        nuevo.setNombreContacto(txtNombreContacto.getText());
        nuevo.setTelefonoContacto(Integer.parseInt(txtTelefonoContacto.getText()));
        nuevo.setEmailContacto(txtEmailContacto.getText());
        
        if (cliente==null){    
            Main.servicioCliente.agregarCliente(nuevo);
            cliente=null;
            actualizarCampos();
        }
        else {
            nuevo.setId(cliente.getId());            
            Main.servicioCliente.editarCliente(nuevo);
        }
        actualizarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Main.servicioCliente.eliminaCliente(cliente);
        actualizarTabla();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        
        //hiloActualizaCliente.close();
        //hiloActualizaCliente.interrupt();
        FrmFiltrarCliente frmFiltrarCliente=new FrmFiltrarCliente(null,true);
        frmFiltrarCliente.setPadre(this);       
        frmFiltrarCliente.setVisible(true);
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnMostrarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodoActionPerformed
        actualizarTabla();
        if(hiloActualizaCliente.isClosed()){
            //hiloActualizaCliente=new HiloActualizaTabla(this);
            hiloActualizaCliente.start();
        }
    }//GEN-LAST:event_btnMostrarTodoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMostrarTodo;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cmbPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtEmailContacto;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtRazonSocial;
    private javax.swing.JTextField txtRubro;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtTelefonoContacto;
    private javax.swing.JTextField txtWebPage;
    // End of variables declaration//GEN-END:variables

    /**
     * @param clientes the clientes to set
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    void recibirResultado(ArrayList<Cliente> lista) {
        setClientes(lista);
        clienteTableModel.fireTableChanged(null);  
    }

    private void initCmbPais() {
        for(int i=0;i<Main.pais.length;i++){
            cmbPais.addItem(Main.pais[i]);
        }        
    }

    class ClienteTableModel extends AbstractTableModel{

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public int getRowCount() {
            return clientes.size();
        }

        @Override
        public Object getValueAt(int row, int column) {
            Cliente cliente=clientes.get(row);
            switch(column){
                case (0): return cliente.getId();
                case (1): return cliente.getRuc();
                case (2): return cliente.getRazonSocial();
                case (3): return cliente.getWebPage();
                case (4): return Main.pais[cliente.getPais()];
//                case (5): return cliente.getRubro();
//                case (6): return cliente.getNombreContacto();
//                case (7): return cliente.getTelefonoContacto();
//                case (8): return cliente.getEmailContacto();
            }
            return null;
        }        
        public String getColumnName (int col){
            return NomCol[col];
        }
    }
}
