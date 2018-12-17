/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import connections.Client;
import connections.ClientInterface;
import connections.Connection;
import connections.DirectoryTree;
import connections.DirectoryTreeClient;
import connections.Server;
import connections.ServerInterface;
import connections.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
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
        root.removeAllChildren();
        DirectoryTree dirTree = server.getDirectoryTree();
        for (DirectoryTree file : dirTree.getChildren()) {
            DirectoryTreeClient node = new DirectoryTreeClient(file.getName(), file.getPath(), file.isDirectory());
            if (file.isDirectory()) {
                fillTree(node, file);
            }
            root.add(node);
        }
        
        model.reload();
    }
    
    /**
     * Fuhcion para mostrar los datos al JTextArea
     * @param tree
     * @param textArea
     * @param connection 
     * @throws java.rmi.RemoteException 
     */
    public void showDataFile(JTree tree, JTextArea textArea, Connection connection, JLabel nombre) throws RemoteException, FileNotFoundException {
        DirectoryTreeClient node = (DirectoryTreeClient) tree.getLastSelectedPathComponent();
        if(((Client)connection.getClient()).isInvalid(node.getPathFile()) || !new File(((Client)connection.getClient()).getRootFolder() + "\\" + node.getPathFile()).exists()){
            if (node != null) {
                System.out.println("Copia invalida");
                String path = node.getPathFile();
                if (!node.isDirectory()) {
                    textArea.setText("");
                    nombre.setText("");
                    nombre.setText(node.getName());
                    ServerInterface server = connection.getServer();
                    ClientInterface client = connection.getClient();
                    server.requestFileFromServer(path, client);
                    textArea.setText(client.getDataFile());
                }else{
                    textArea.setText("");
                }
            }
        }else{
            if(node != null){
                System.out.println("Copia valida");
                Client client = (Client) connection.getClient();
                client.setPath(node.getPathFile());
                textArea.setText("");
                nombre.setText("");
                nombre.setText(node.getName());
                textArea.setText(client.getDataFile());
            }
        }
    }
    
}
