/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formulario;


import dao.DCliente;
import dao.DEntrada;
import dao.DProducto;
import dao.DSalida;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import modelado.Cliente;
import modelado.Producto;
import modelado.Usuario;

/**
 *
 * @author Noel
 */
public class JMovimiento extends javax.swing.JPanel {
//DProducto listaP = new DProducto();
//DEntrada listaE =new DEntrada();
//DSalida listaS = new DSalida();
//DCliente listaC = new DCliente();
private DProducto listaP;
private DEntrada listaE;
private DSalida listaS;
private DCliente listaC;        
private Date Fecha = new Date();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
String formattedDate = simpleDateFormat.format(Fecha);
java.sql.Date fechaSql = java.sql.Date.valueOf(formattedDate);
private Usuario user;

    /**
     * Creates new form JMovimiento
     */
    public JMovimiento() {
        initComponents();
       
    }
    
    public JMovimiento(Usuario user, DEntrada listaE, DSalida listaS, DProducto listaP, DCliente listaC) {
        initComponents();
        this.user=user;
        this.listaE= listaE;
        this.listaP=listaP;
        this.listaS= listaS;
        this.listaC=listaC;
        TfClienteP.setEnabled(false);
        TfClienteP.setText("Entradas no requieren Proveedor");
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
        jLabel1 = new javax.swing.JLabel();
        TfCodigoMover = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TfCantidadMover = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        btnMover = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        TfClienteP = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        combomovimiento = new javax.swing.JComboBox<>();
        btnCliente = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(236, 239, 244));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Codigo ");

        TfCodigoMover.setBackground(new java.awt.Color(236, 239, 244));
        TfCodigoMover.setBorder(null);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_search_30px.png"))); // NOI18N
        jLabel2.setText("Ver productos");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Entrada o salida del Inventario.");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad a mover:");

        TfCantidadMover.setBackground(new java.awt.Color(236, 239, 244));
        TfCantidadMover.setForeground(new java.awt.Color(0, 0, 0));
        TfCantidadMover.setBorder(null);

        btnMover.setText("Guardar");
        btnMover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoverActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID Cliente:");

        TfClienteP.setBackground(new java.awt.Color(236, 239, 244));
        TfClienteP.setForeground(new java.awt.Color(0, 0, 0));
        TfClienteP.setBorder(null);

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Tipo de movimiento:");

        combomovimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        combomovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Salida" }));
        combomovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomovimientoActionPerformed(evt);
            }
        });

        btnCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCliente.setForeground(new java.awt.Color(0, 0, 0));
        btnCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_search_client_30px_1.png"))); // NOI18N
        btnCliente.setText("Ver clientes");
        btnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClienteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jSeparator3)
                                        .addComponent(jSeparator1)
                                        .addComponent(TfCodigoMover)
                                        .addComponent(combomovimiento, 0, 307, Short.MAX_VALUE))
                                    .addComponent(TfClienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TfCantidadMover, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfCodigoMover)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combomovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TfClienteP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCliente))
                .addGap(2, 2, 2)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TfCantidadMover, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addGap(2, 2, 2)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMover, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(195, 195, 195))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoverActionPerformed
        // TODO add your handling code here:
        
        String codigo = TfCodigoMover.getText();
        int cantidad = Integer.parseInt(TfCantidadMover.getText());
        String eleccion = combomovimiento.getSelectedItem().toString();
        Producto p =listaP.obtenerProducto(codigo);
        
        //verifica que el producto exista
        if(p!=null){
            if(eleccion.equalsIgnoreCase("Entrada")){
                //verifica que cantidad a ingresar sea mayor que cero para evitar ingresar una entrada falsa
                if(cantidad>0){
                    listaP.editarProducto(p, cantidad);
                    listaE.agregarEntrada(fechaSql, p, cantidad, user);
                    JOptionPane.showMessageDialog(this, "Entrada exitosa");
                }else{
                    JOptionPane.showMessageDialog(this, "Introduce una cantidad mayor que cero");
                }
                    
                
            }else{
                //verifica cantidad a mover tiene que ser diferente de cero para no generar una salida falsa 
                if(cantidad>0){
                    //verifica si existe cantidad suficiente del producto a mover
                    if(p.getCantidad()>=cantidad){
                    int idCliente =Integer.parseInt(TfClienteP.getText());
                    Cliente c = listaC.obtenerCliente(idCliente);
                    //verifica si el cliente existe
                        if(c!=null){
                            listaS.agregarSalida(fechaSql, c, p, cantidad, user);
                            cantidad = -cantidad;
                            listaP.editarProducto(p, cantidad);
                            JOptionPane.showMessageDialog(this, "Salida Exitosa");
                        }else{
                            JOptionPane.showMessageDialog(this, "Cliente no existe");
                            TfClienteP.setText("");
                        }
                }else{
                    JOptionPane.showMessageDialog(this, "Producto insuficiente");
                    TfCantidadMover.setText("");
                }  
                }else{
                    JOptionPane.showMessageDialog(this, "Introduce una cantidad mayor que cero");
                }
         
            }
            TfCodigoMover.setText("");
            TfCantidadMover.setText("");
            TfClienteP.setText("");
        }else{
            JOptionPane.showMessageDialog(this, "Producto no existe en el inventario");
            TfCodigoMover.setText("");
            TfCantidadMover.setText("");
            TfClienteP.setText("");
        }
                       
            
    }//GEN-LAST:event_btnMoverActionPerformed

    private void btnClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClienteMouseClicked
        // TODO add your handling code here:
        FrmVerCliente gui = new FrmVerCliente(listaC);
        gui.setVisible(true);
    }//GEN-LAST:event_btnClienteMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        FrmVerProducto gui = new FrmVerProducto(listaP);
        gui.setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void combomovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomovimientoActionPerformed
        // TODO add your handling code here:
        if(combomovimiento.getSelectedItem().equals("Salida")){
            TfClienteP.setEnabled(true);
            TfClienteP.setText("");
        }else{
            TfClienteP.setEnabled(false);
            TfClienteP.setText("Entradas no requieren cliente/proveedor");
            
        }
    }//GEN-LAST:event_combomovimientoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TfCantidadMover;
    private javax.swing.JTextField TfClienteP;
    private javax.swing.JTextField TfCodigoMover;
    private javax.swing.JLabel btnCliente;
    private javax.swing.JButton btnMover;
    private javax.swing.JComboBox<String> combomovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
