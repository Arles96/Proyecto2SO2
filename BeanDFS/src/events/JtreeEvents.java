/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import connections.ClientInterface;
import connections.Connection;
import connections.DirectoryTree;
import connections.DirectoryTreeClient;
import connections.Server;
import connections.ServerInterface;
import connections.Test;
import java.rmi.RemoteException;
import javax.swing.JTextArea;
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
            DirectoryTreeClient newNode = new DirectoryTreeClient(f.getName(), f.getPath(), f.isDirectory());
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
     * @throws java.rmi.RemoteException 
     */
    public void refreshTree(ServerInterface server, JTree uiTree) throws RemoteException {
        DefaultTreeModel model = (DefaultTreeModel) uiTree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        DirectoryTree dirTree = server.getDirectoryTree();
        Test.PrintTree(dirTree, "");
        for (DirectoryTree file : dirTree.getChildren()) {
            DirectoryTreeClient node = new DirectoryTreeClient(file.getName(), file.getPath(), file.isDirectory());
            if (file.isDirectory()) {
                fillTree(node, file);
            }
            root.add(node);
        }
    }
    
    /**
     * Fuhcion para mostrar los datos al JTextArea
     * @param tree
     * @param textArea
     * @param connection 
     * @throws java.rmi.RemoteException 
     */
    public void showDataFile(JTree tree, JTextArea textArea, Connection connection) throws RemoteException {
        DirectoryTreeClient node = (DirectoryTreeClient) tree.getLastSelectedPathComponent();
        if (node != null) {
            String path = node.getPathFile();
            if (!node.isDirectory()) {
                ServerInterface server = connection.getServer();
                ClientInterface client = connection.getClient();
                server.requestFileFromServer(path, client);
                textArea.setText(client.getDataFile());
            }
        }
    }
    
}
