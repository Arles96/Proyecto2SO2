/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import connections.DirectoryTree;
import connections.Server;
import connections.ServerInterface;
import java.rmi.RemoteException;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author arles
 */
public class JtreeEvents {

    public JtreeEvents() {
    }
    /**
     * Funcion privada para recorrer los subdirectorios
     * @param node
     * @param file 
     */
    private void fillTree (DefaultMutableTreeNode node, DirectoryTree file) {
        for (DirectoryTree f : file.getChildren()) {
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(f.getName());
            if (f.isDirectory()) {
                fillTree(newNode, f);
            }
            node.add(newNode);
        }
    }
    
    /**
     * Funcion para refrescar el jtree
     * @param server
     * @param uiTree 
     */
    public void refreshTree(ServerInterface server, JTree uiTree) throws RemoteException {
        DefaultTreeModel model = (DefaultTreeModel) uiTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DirectoryTree dirTree = server.getDirectoryTree();
        System.out.println(dirTree.getName());
        for (DirectoryTree file : dirTree.getChildren()) {
            DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
            if (file.isDirectory()) {
                fillTree(node, file);
            }
            root.add(node);
        }
    }
    
}
