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
import java.rmi.RemoteException;
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
            System.out.println(node.getName());
            System.out.println(node.isDirectory());
            if (node.isDirectory()) {
                System.out.println("Estoy en un directorio");
                ServerInterface server = connection.getServer();
                ClientInterface client = connection.getClient();
                server.requestFileFromServer(path, client);
                
            }
        }
    }
    
}
