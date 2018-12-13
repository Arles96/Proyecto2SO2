/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

/**
 *
 * @author Harold Mendoza
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("BEANFS");
        this.setResizable(false); 
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
        b_ModificarNombre = new javax.swing.JButton();
        b_salvar = new javax.swing.JButton();
        labelNombre = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        b_Conectar = new javax.swing.JButton();
        b_Desconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        treeStructure = new javax.swing.JTree();
        b_CrearArchivo = new javax.swing.JButton();
        b_CrearDirectorio = new javax.swing.JButton();
        b_Borrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textFile = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 245, 245));

        jPanel2.setBackground(new java.awt.Color(71, 120, 197));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 60)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("B E A N F S");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 10, -1, 74));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/images/coffee-beans.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 10, -1, -1));

        b_ModificarNombre.setBackground(new java.awt.Color(71, 120, 197));
        b_ModificarNombre.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_ModificarNombre.setForeground(new java.awt.Color(255, 255, 255));
        b_ModificarNombre.setText("Modificar");
        b_ModificarNombre.setBorderPainted(false);
        b_ModificarNombre.setContentAreaFilled(false);
        b_ModificarNombre.setOpaque(true);

        b_salvar.setBackground(new java.awt.Color(71, 120, 197));
        b_salvar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        b_salvar.setForeground(new java.awt.Color(255, 255, 255));
        b_salvar.setText("Salvar");
        b_salvar.setBorderPainted(false);
        b_salvar.setContentAreaFilled(false);
        b_salvar.setOpaque(true);

        labelNombre.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        labelNombre.setForeground(new java.awt.Color(23, 35, 51));
        labelNombre.setText("Nombre Archivo");

        jPanel3.setBackground(new java.awt.Color(23, 35, 51));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        b_Conectar.setBackground(new java.awt.Color(71, 120, 197));
        b_Conectar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_Conectar.setForeground(new java.awt.Color(255, 255, 255));
        b_Conectar.setText("Conectar");
        b_Conectar.setBorderPainted(false);
        b_Conectar.setContentAreaFilled(false);
        b_Conectar.setMaximumSize(new java.awt.Dimension(137, 33));
        b_Conectar.setMinimumSize(new java.awt.Dimension(137, 33));
        b_Conectar.setOpaque(true);
        b_Conectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ConectarActionPerformed(evt);
            }
        });
        jPanel3.add(b_Conectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 200, -1));

        b_Desconectar.setBackground(new java.awt.Color(199, 73, 58));
        b_Desconectar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_Desconectar.setForeground(new java.awt.Color(255, 255, 255));
        b_Desconectar.setText("Desconectar");
        b_Desconectar.setBorderPainted(false);
        b_Desconectar.setContentAreaFilled(false);
        b_Desconectar.setOpaque(true);
        b_Desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DesconectarActionPerformed(evt);
            }
        });
        jPanel3.add(b_Desconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, -1));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeStructure.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(treeStructure);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 420, 310));

        b_CrearArchivo.setBackground(new java.awt.Color(104, 151, 117));
        b_CrearArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_CrearArchivo.setForeground(new java.awt.Color(255, 255, 255));
        b_CrearArchivo.setText("Crear Archivo");
        b_CrearArchivo.setContentAreaFilled(false);
        b_CrearArchivo.setOpaque(true);
        jPanel3.add(b_CrearArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 400, 50));

        b_CrearDirectorio.setBackground(new java.awt.Color(71, 120, 197));
        b_CrearDirectorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_CrearDirectorio.setForeground(new java.awt.Color(255, 255, 255));
        b_CrearDirectorio.setText("Crear Directorio");
        b_CrearDirectorio.setContentAreaFilled(false);
        b_CrearDirectorio.setOpaque(true);
        jPanel3.add(b_CrearDirectorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 400, 50));

        b_Borrar.setBackground(new java.awt.Color(199, 73, 58));
        b_Borrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_Borrar.setForeground(new java.awt.Color(255, 255, 255));
        b_Borrar.setText("Borrar");
        b_Borrar.setContentAreaFilled(false);
        b_Borrar.setOpaque(true);
        jPanel3.add(b_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 400, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/images/refresh-arrow.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, -1, -1));

        textFile.setColumns(20);
        textFile.setRows(5);
        jScrollPane2.setViewportView(textFile);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1061, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(labelNombre)
                                .addGap(32, 32, 32)
                                .addComponent(b_ModificarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(b_salvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_ModificarNombre)
                            .addComponent(labelNombre))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_DesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DesconectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_DesconectarActionPerformed

    private void b_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ConectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_ConectarActionPerformed

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
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_Borrar;
    private javax.swing.JButton b_Conectar;
    private javax.swing.JButton b_CrearArchivo;
    private javax.swing.JButton b_CrearDirectorio;
    private javax.swing.JButton b_Desconectar;
    private javax.swing.JButton b_ModificarNombre;
    private javax.swing.JButton b_salvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JTextArea textFile;
    private javax.swing.JTree treeStructure;
    // End of variables declaration//GEN-END:variables
}
