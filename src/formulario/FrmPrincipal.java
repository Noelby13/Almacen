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
import dao.DUsuario;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelado.Cliente;
import modelado.Usuario;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author Noel
 */
public class FrmPrincipal extends javax.swing.JFrame {
private DProducto listaP = new DProducto();
private DEntrada listaE =new DEntrada();
private DSalida listaS = new DSalida();
private DCliente listaC = new DCliente();
private DUsuario listaU = new DUsuario();
Usuario user;

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    
    public FrmPrincipal(Usuario user){
        initComponents();
        this.user=user;
        TfUser.setText(user.getNombreUsuario());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfUser = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LDashboard = new javax.swing.JLabel();
        LProducto = new javax.swing.JLabel();
        LCliente = new javax.swing.JLabel();
        LUsuario = new javax.swing.JLabel();
        LMovimientos = new javax.swing.JLabel();
        LActualizarBD = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        LReportes1 = new javax.swing.JLabel();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(60, 141, 188));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/businessman.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 0, 90, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Almacen");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 14, -1, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/warehouse.png"))); // NOI18N
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 0, -1, -1));

        TfUser.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jPanel2.add(TfUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 18, 136, 46));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        jPanel3.setBackground(new java.awt.Color(34, 45, 49));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LDashboard.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LDashboard.setForeground(new java.awt.Color(255, 255, 255));
        LDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_dashboard_40px_1.png"))); // NOI18N
        LDashboard.setText("DASHBOARD");
        LDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LDashboardMousePressed(evt);
            }
        });
        jPanel3.add(LDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 210, -1));

        LProducto.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LProducto.setForeground(new java.awt.Color(255, 255, 255));
        LProducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_box_40px.png"))); // NOI18N
        LProducto.setText("PRODUCTO");
        LProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LProductoMousePressed(evt);
            }
        });
        jPanel3.add(LProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 156, 210, -1));

        LCliente.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LCliente.setForeground(new java.awt.Color(255, 255, 255));
        LCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_businessman_40px.png"))); // NOI18N
        LCliente.setText("CLIENTE");
        LCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LClienteMousePressed(evt);
            }
        });
        jPanel3.add(LCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 208, 210, -1));

        LUsuario.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_user_40px.png"))); // NOI18N
        LUsuario.setText("USUARIO");
        LUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LUsuarioMousePressed(evt);
            }
        });
        jPanel3.add(LUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 266, 210, -1));

        LMovimientos.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LMovimientos.setForeground(new java.awt.Color(255, 255, 255));
        LMovimientos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LMovimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_shopping_cart_40px.png"))); // NOI18N
        LMovimientos.setText("MOVIMIENTOS");
        LMovimientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LMovimientos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LMovimientosMousePressed(evt);
            }
        });
        jPanel3.add(LMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 98, 210, -1));

        LActualizarBD.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LActualizarBD.setForeground(new java.awt.Color(255, 255, 255));
        LActualizarBD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LActualizarBD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_cloud_backup_restore_40px.png"))); // NOI18N
        LActualizarBD.setText("ACTUALIZAR");
        LActualizarBD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LActualizarBD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LActualizarBDMousePressed(evt);
            }
        });
        jPanel3.add(LActualizarBD, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 210, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Versión 1.0");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 528, -1, -1));

        LReportes1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        LReportes1.setForeground(new java.awt.Color(255, 255, 255));
        LReportes1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LReportes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/FrmIconosNuevos/icons8_pdf_40px.png"))); // NOI18N
        LReportes1.setText("REPORTES");
        LReportes1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LReportes1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LReportes1MousePressed(evt);
            }
        });
        jPanel3.add(LReportes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 210, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 550));

        content.setBackground(new java.awt.Color(236, 239, 244));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        jPanel1.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 750, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 976, 659);
    }// </editor-fold>//GEN-END:initComponents

    private void showPanel (JPanel p){
        p.setSize(700, 550);
        
        content.removeAll();
        content.add(p,new AbsoluteConstraints(0,0,-1,-1));
        content.revalidate();
        content.repaint();
        
    }
    
    private void LProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LProductoMousePressed
        // TODO add your handling code here:
        JProducto producto = new JProducto();
        showPanel(producto);
        
        
    }//GEN-LAST:event_LProductoMousePressed

    private void LDashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LDashboardMousePressed
        // TODO add your handling code here:
        JDashboard db = new JDashboard();
        showPanel(db);
    }//GEN-LAST:event_LDashboardMousePressed

    private void LMovimientosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LMovimientosMousePressed
        // TODO add your handling code here:
        JMovimiento mov = new JMovimiento(user);
        showPanel(mov);
        
    }//GEN-LAST:event_LMovimientosMousePressed

    private void LClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LClienteMousePressed
        // TODO add your handling code here:
        JCliente cliente = new JCliente();
        showPanel(cliente);
    }//GEN-LAST:event_LClienteMousePressed

    private void LUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LUsuarioMousePressed
        // TODO add your handling code here:
        JUsuario usuario = new JUsuario();
        showPanel(usuario);
    }//GEN-LAST:event_LUsuarioMousePressed

    private void LActualizarBDMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LActualizarBDMousePressed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, listaP.actualizarBD(),"Inventario",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, listaE.actualizarBD(),"Entrada",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, listaS.actualizarBD(),"Salida",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, listaC.actualizarBD(),"Clientes",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(this, listaU.actualizarBD(),"Usuarios",JOptionPane.INFORMATION_MESSAGE);
        
       
    }//GEN-LAST:event_LActualizarBDMousePressed

    private void LReportes1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LReportes1MousePressed
        // TODO add your handling code here:
        JReportes reporte = new JReportes();
        showPanel(reporte);
        
    }//GEN-LAST:event_LReportes1MousePressed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LActualizarBD;
    private javax.swing.JLabel LCliente;
    private javax.swing.JLabel LDashboard;
    private javax.swing.JLabel LMovimientos;
    private javax.swing.JLabel LProducto;
    private javax.swing.JLabel LReportes1;
    private javax.swing.JLabel LUsuario;
    private javax.swing.JLabel TfUser;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
