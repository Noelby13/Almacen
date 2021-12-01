/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;

import dao.DEntrada;
import dao.DProducto;
import dao.DSalida;
import javax.swing.JOptionPane;
import modelado.Producto;

/**
 *
 * @author Noel
 */
public class JEliminarMov extends javax.swing.JPanel {
private DProducto listaP;
private DEntrada listaE;
private DSalida listaS;
    /**
     * Creates new form JEliminarMov
     */
    public JEliminarMov() {
        initComponents();
    }
    
    public JEliminarMov(DEntrada listaE, DSalida listaS, DProducto listaP) {
        this.listaE= listaE;
        this.listaP=listaP;
        this.listaS=listaS;
        initComponents();
        tablaMov.setModel(listaE.tablaEntrada());
        tablaMov.setDefaultEditor(Object.class, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backGround = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboEleccion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        TfId = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMov = new javax.swing.JTable();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jButton1 = new javax.swing.JButton();

        backGround.setBackground(new java.awt.Color(236, 239, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Eliminar Entradas o Salidas");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Tipo de movimiento:");

        comboEleccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida" }));
        comboEleccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEleccionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Introduce ID: ");

        TfId.setBackground(new java.awt.Color(236, 239, 244));
        TfId.setForeground(new java.awt.Color(0, 0, 0));
        TfId.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TfId.setBorder(null);

        tablaMov.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaMov.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMovMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMov);

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backGroundLayout = new javax.swing.GroupLayout(backGround);
        backGround.setLayout(backGroundLayout);
        backGroundLayout.setHorizontalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backGroundLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(backGroundLayout.createSequentialGroup()
                            .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TfId, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        backGroundLayout.setVerticalGroup(
            backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backGroundLayout.createSequentialGroup()
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboEleccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(backGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(backGroundLayout.createSequentialGroup()
                        .addComponent(TfId, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(TfId.getText());
        int cantidad;
        if(comboEleccion.getSelectedItem().toString().equals("Entrada")){
            
            cantidad = listaE.obtenerCantidadEntrada(id);
            cantidad = -cantidad;
            Producto P = listaE.obtenerProducto(id);
            listaP.editarProducto(P, cantidad);
            listaE.eliminarEntrada(id);
            //tabla no se actualiza hasta que se actualice la BD, esto se debe a que solo se realiza eliminacion logica.
            tablaMov.setModel(listaE.tablaEntrada());
            JOptionPane.showMessageDialog(this, "Entrada eliminada e Inventario actualizado, cambios se reflejaran despues de actualizar");
            TfId.setText("");
            
            
        }else{
            cantidad =listaS.obtenerCantidadSalida(id);
            Producto P = listaS.obtenerProducto(id);
            listaP.editarProducto(P, cantidad);
            listaS.eliminarSalida(id);
            JOptionPane.showMessageDialog(this, "Salida eliminada e Inventario actualizado");
            TfId.setText("");
            //tabla no se actualiza hasta que se actualice la BD, esto se debe a que solo se realiza eliminacion logica.
            tablaMov.setModel(listaS.tablaSalida());
        }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void comboEleccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEleccionActionPerformed
        // TODO add your handling code here:
        if(comboEleccion.getSelectedItem().toString().equals("Entrada")){
            tablaMov.setModel(listaE.tablaEntrada());
        }else{
            tablaMov.setModel(listaS.tablaSalida());
        }
    }//GEN-LAST:event_comboEleccionActionPerformed

    private void tablaMovMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMovMouseClicked
        // TODO add your handling code here:
       int fila = tablaMov.getSelectedRow();
       int id =(int) tablaMov.getValueAt(fila, 0);
       String ids = String.valueOf(id);
       TfId.setText(ids);
    }//GEN-LAST:event_tablaMovMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TfId;
    private javax.swing.JPanel backGround;
    private javax.swing.JComboBox<String> comboEleccion;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaMov;
    // End of variables declaration//GEN-END:variables
}
