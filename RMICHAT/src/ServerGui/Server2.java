package ServerGui;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Mendoza
 */
public class Server2 extends UnicastRemoteObject implements ServerInterface {
    /*private*/public File rootDirectory;
    /*private*/public ArrayList<ClientInterface> clients;
    /*private*/public DirectoryTree dirTree;

    public Server2(File RootDirectory) {
        this.rootDirectory = RootDirectory;
        this.clients = new ArrayList();
        this.dirTree = new DirectoryTree();
        fillTree(dirTree, rootDirectory);
    }
    
    public Server2(File RootDirectory, ArrayList<ClientInterface> clients, DirectoryTree dirTree) {
        this.rootDirectory = RootDirectory;
        this.clients = clients;
        this.dirTree = dirTree;
    }
    
    private void fillTree(DirectoryTree tree, File path){
        for (File file : path.listFiles()) {
            if (file.isDirectory()){
                tree.addChildren(new DirectoryTree(file.getName(), false));
                fillTree(tree.getChild(tree.getChildren().size() - 1), file);
            }else{
                tree.addChildren(new DirectoryTree(file.getName(), false));
            }
            
        }
    }
    
    @Override
    public void joinServer(ClientInterface newClient) throws RemoteException{
        clients.add(newClient);
        try {
            newClient.sendTree(dirTree);
        } catch (RemoteException ex) {
            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createDirectory(String path) throws RemoteException {
        
    }

    @Override
    public void requestFileFromServer(String path, ClientInterface client) throws RemoteException {
        String txtFile;
        try {
            txtFile = new Scanner(new File(this.rootDirectory.getAbsolutePath() + path)).useDelimiter("\\Z").next();
            client.sendFile(txtFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendFileToServer(String data) throws RemoteException {
        
    }
}