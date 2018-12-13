package ServerGui;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Mendoza
 */
public class Client extends UnicastRemoteObject implements ClientInterface{
    private ServerInterface server;
    public DirectoryTree tree;
    private boolean active;
    private File rootFolder;

    public Client(String rootFolder) {
        this.rootFolder = new File(rootFolder);
    }
    
    public Client(ServerInterface server, String rootFolder) {
        this.server = server;
        this.rootFolder = new File(rootFolder);
    }
    
    public Client(ServerInterface server, File rootFolder) {
        this.server = server;
        this.rootFolder = rootFolder;
    }
    
    public Client(ServerInterface server) {
        this.server = server;
        this.active = true;
    }
    
    public Client(ServerInterface server, boolean active) {
        this.server = server;
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public DirectoryTree getTree() {
        return tree;
    }

    public void setTree(DirectoryTree tree) {
        this.tree = tree;
    }
    
    @Override
    public void sendFile(String data) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sendTree(DirectoryTree tree) throws RemoteException {
        this.tree = tree;
    }
    
}
