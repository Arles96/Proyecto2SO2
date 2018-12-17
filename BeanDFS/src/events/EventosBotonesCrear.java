/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package events;

import connections.ClientInterface;
import connections.Connection;
import connections.DirectoryTreeClient;
import connections.ServerInterface;
import java.io.File;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTree;

/**
 *
 * @author Harold Mendoza
 */
public class EventosBotonesCrear {
    
    public void crearDirectorio(String nombre, JTree tree, Connection connection) throws RemoteException{
        DirectoryTreeClient node = (DirectoryTreeClient) tree.getLastSelectedPathComponent();
        if (node != null) {
            String path = node.getPathFile();
            if (node.isDirectory()) {
                ServerInterface server = connection.getServer();
                server.createDirectory(path +"\\"+nombre);
            }
        }
    }
    
    public void createFile (String name, JTree tree, Connection connecttion) throws RemoteException {
        DirectoryTreeClient node = (DirectoryTreeClient) tree.getLastSelectedPathComponent();
        if (node != null) {
            String path = node.getPathFile();
            if (node.isDirectory()) {
                ServerInterface server = connecttion.getServer();
                server.sendNewFileToServer("Se ha creado el archivo " + name, path + "\\" + name);
                connecttion.getClient().createFile("Se ha creado el archivo" + name, path + "\\" + name);
                server.joinServer(connecttion.getClient());
            }
        } else {
            ServerInterface server = connecttion.getServer();
            server.sendNewFileToServer("Se ha creado el archivo " + name, "\\" + name);
            connecttion.getClient().createFile("Se ha creado el archivo " + name, "\\" + name);
            server.joinServer(connecttion.getClient());
        }
    }
    
}
