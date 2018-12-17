/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import connections.ClientInterface;
import connections.Connection;
import connections.DirectoryTreeClient;
import connections.Server;
import events.JtreeEvents;
import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import events.EventosBotonesCrear;

/**
 *
 * @author Harold Mendoza
 */
public class FramePrincipal extends javax.swing.JFrame {
    
    private Connection connection = new Connection();
    private final JtreeEvents jtreeEvents = new JtreeEvents();
    private final EventosBotonesCrear bCrearEvents = new EventosBotonesCrear();

    /**
     * Creates new form FramePrincipal
     */
    public FramePrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("BEANFS");
        this.setResizable(false); 
//        try {
//            connection = new Connection(8888);
//            jtreeEvents.refreshTree(connection.getServer(), treeStructure);
//        } catch (NotBoundException | RemoteException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(this, "Error de prueba de conexión");
//        }
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
        b_ModificarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ModificarNombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_ModificarNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_ModificarNombreMouseExited(evt);
            }
        });

        b_salvar.setBackground(new java.awt.Color(71, 120, 197));
        b_salvar.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        b_salvar.setForeground(new java.awt.Color(255, 255, 255));
        b_salvar.setText("Salvar");
        b_salvar.setBorderPainted(false);
        b_salvar.setContentAreaFilled(false);
        b_salvar.setOpaque(true);
        b_salvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_salvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_salvarMouseExited(evt);
            }
        });

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
        b_Conectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_ConectarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_ConectarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_ConectarMouseExited(evt);
            }
        });
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
        b_Desconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_DesconectarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_DesconectarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_DesconectarMouseExited(evt);
            }
        });
        b_Desconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_DesconectarActionPerformed(evt);
            }
        });
        jPanel3.add(b_Desconectar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 200, -1));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeStructure.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeStructure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                treeStructureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(treeStructure);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 470, 310));

        b_CrearArchivo.setBackground(new java.awt.Color(104, 160, 88));
        b_CrearArchivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_CrearArchivo.setForeground(new java.awt.Color(255, 255, 255));
        b_CrearArchivo.setText("Crear Archivo");
        b_CrearArchivo.setContentAreaFilled(false);
        b_CrearArchivo.setOpaque(true);
        b_CrearArchivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_CrearArchivoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_CrearArchivoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_CrearArchivoMouseExited(evt);
            }
        });
        jPanel3.add(b_CrearArchivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 470, 50));

        b_CrearDirectorio.setBackground(new java.awt.Color(71, 120, 197));
        b_CrearDirectorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_CrearDirectorio.setForeground(new java.awt.Color(255, 255, 255));
        b_CrearDirectorio.setText("Crear Directorio");
        b_CrearDirectorio.setContentAreaFilled(false);
        b_CrearDirectorio.setOpaque(true);
        b_CrearDirectorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_CrearDirectorioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_CrearDirectorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_CrearDirectorioMouseExited(evt);
            }
        });
        jPanel3.add(b_CrearDirectorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 470, 50));

        b_Borrar.setBackground(new java.awt.Color(199, 73, 58));
        b_Borrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        b_Borrar.setForeground(new java.awt.Color(255, 255, 255));
        b_Borrar.setText("Borrar");
        b_Borrar.setContentAreaFilled(false);
        b_Borrar.setOpaque(true);
        b_Borrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                b_BorrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                b_BorrarMouseExited(evt);
            }
        });
        jPanel3.add(b_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 470, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cliente/images/refresh-arrow.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
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
                        .addGap(6, 6, 6)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_ModificarNombre)
                            .addComponent(labelNombre))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2)
                        .addGap(14, 14, 14)
                        .addComponent(b_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    //Light Versions
    public void setColorBlue(JButton b){
       b.setBackground(new Color(71,120,197)); 
    }
    public void setColorRed(JButton b){
       b.setBackground(new Color(199,73,58)); 
    }
    
    public void setColorGreen(JButton b){
       b.setBackground(new Color(104,160,88)); 
    }
    //Dark Versions
    public void setColorBlueDark(JButton b){
       b.setBackground(new Color(71,105,179)); 
    }
    public void setColorRedDark(JButton b){
       b.setBackground(new Color(199,63,33)); 
    }
    public void setColorGreenDark(JButton b){
       b.setBackground(new Color(104,152,76)); 
    }
    
    
    
    private void b_DesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_DesconectarActionPerformed
        try {
            // TODO add your handling code here:
            connection.desconnect();
        } catch (RemoteException ex) {
            System.out.println("Error en logout");
        }
        treeStructure.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("root")));
        JOptionPane.showMessageDialog(this, "Se ha desconectado");
    }//GEN-LAST:event_b_DesconectarActionPerformed

    private void b_ConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ConectarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_ConectarActionPerformed

    private void b_salvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_salvarMouseEntered
        // TODO add your handling code here:
        setColorBlueDark(b_salvar);
    }//GEN-LAST:event_b_salvarMouseEntered

    private void b_salvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_salvarMouseExited
        // TODO add your handling code here:
        setColorBlue(b_salvar);
    }//GEN-LAST:event_b_salvarMouseExited

    private void b_ModificarNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ModificarNombreMouseEntered
        // TODO add your handling code here:
        setColorGreen(b_ModificarNombre);
    }//GEN-LAST:event_b_ModificarNombreMouseEntered

    private void b_ModificarNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ModificarNombreMouseExited
        // TODO add your handling code here:
        setColorBlue(b_ModificarNombre);
    }//GEN-LAST:event_b_ModificarNombreMouseExited

    private void b_CrearArchivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearArchivoMouseEntered
        // TODO add your handling code here:
        setColorGreenDark(b_CrearArchivo);
    }//GEN-LAST:event_b_CrearArchivoMouseEntered

    private void b_CrearArchivoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearArchivoMouseExited
        // TODO add your handling code here:
        setColorGreen(b_CrearArchivo);
    }//GEN-LAST:event_b_CrearArchivoMouseExited

    private void b_CrearDirectorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearDirectorioMouseEntered
        // TODO add your handling code here:
        setColorBlueDark(b_CrearDirectorio);
    }//GEN-LAST:event_b_CrearDirectorioMouseEntered

    private void b_CrearDirectorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearDirectorioMouseExited
        // TODO add your handling code here:
        setColorBlue(b_CrearDirectorio);
    }//GEN-LAST:event_b_CrearDirectorioMouseExited

    private void b_BorrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_BorrarMouseEntered
        // TODO add your handling code here:
        setColorRedDark(b_Borrar);
    }//GEN-LAST:event_b_BorrarMouseEntered

    private void b_BorrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_BorrarMouseExited
        // TODO add your handling code here:
        setColorRed(b_Borrar);
    }//GEN-LAST:event_b_BorrarMouseExited

    private void b_ConectarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ConectarMouseEntered
        // TODO add your handling code here:
        setColorBlueDark(b_Conectar);
    }//GEN-LAST:event_b_ConectarMouseEntered

    private void b_ConectarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ConectarMouseExited
        // TODO add your handling code here:
        setColorBlue(b_Conectar);
    }//GEN-LAST:event_b_ConectarMouseExited

    private void b_DesconectarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_DesconectarMouseEntered
        // TODO add your handling code here:
        setColorRedDark(b_Desconectar);
    }//GEN-LAST:event_b_DesconectarMouseEntered

    private void b_DesconectarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_DesconectarMouseExited
        // TODO add your handling code here:
        setColorRed(b_Desconectar);
    }//GEN-LAST:event_b_DesconectarMouseExited

    private void treeStructureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeStructureMouseClicked
        try {
            jtreeEvents.showDataFile(treeStructure, textFile, connection);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_treeStructureMouseClicked

    private void b_ConectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ConectarMouseClicked
        String ip = JOptionPane.showInputDialog(this, "Ingrese la ip del servidor");
        try {
            connection.setConnection(ip);
            jtreeEvents.refreshTree(connection.getServer(), treeStructure);
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(this, "Error en la conexión.", "Error", ERROR);
        } catch (NotBoundException ex) {
            JOptionPane.showMessageDialog(this, "Error al obtener los datos.", "Error", ERROR);
        }
    }//GEN-LAST:event_b_ConectarMouseClicked

    private void b_CrearDirectorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearDirectorioMouseClicked
        // TODO add your handling code here:
        String nombre = JOptionPane.showInputDialog("Ingresar nombre de directorio:");
        //System.out.println(nombre);
        try {
            System.out.println("Entro");
            bCrearEvents.crearDirectorio(nombre, treeStructure, connection);
            JOptionPane.showMessageDialog(this, "Se ha creado la carpeta "+nombre);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_b_CrearDirectorioMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        System.out.println("Refresh tree _________________");
        try {
            jtreeEvents.refreshTree(connection.getServer(), treeStructure);
        } catch (RemoteException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el arbol", "Error", ERROR);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void b_CrearArchivoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_CrearArchivoMouseClicked
        try {
            String name = JOptionPane.showInputDialog("Ingrese el nombre del archivo");
            String data = textFile.getText();
            if (data.isEmpty()) data = "";
            bCrearEvents.createFile(name, treeStructure, connection, data);
            JOptionPane.showMessageDialog(this, "Se ha creado un archivo nuevo: " + name);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al crear el archivo", "Error", ERROR);
        }
    }//GEN-LAST:event_b_CrearArchivoMouseClicked

    private void b_ModificarNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_ModificarNombreMouseClicked
        try {
            String data = textFile.getText();
            if (data.isEmpty()) data = "";
            String name = bCrearEvents.modifyFile(treeStructure, connection, data);
            JOptionPane.showMessageDialog(this, "Modificado archivo: " + name);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "Error al crear el archivo", "Error", ERROR);
        }
    }//GEN-LAST:event_b_ModificarNombreMouseClicked

    private void b_DesconectarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_DesconectarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_b_DesconectarMouseClicked


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
