package ServerGui;

import java.io.File;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Mendoza
 */
public class Server extends UnicastRemoteObject implements ServerInterface {
    /*private*/public File rootDirectory;
    /*private*/public ArrayList<ClientInterface> clients;
    /*private*/public DirectoryTree dirTree;

    public Server(File RootDirectory) {
        this.rootDirectory = RootDirectory;
        this.clients = new ArrayList();
        this.dirTree = new DirectoryTree();
        fillTree(dirTree, rootDirectory);
    }
    
    public Server(File RootDirectory, ArrayList<ClientInterface> clients, DirectoryTree dirTree) {
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
    
    public void joinServer(ClientInterface newClient){
        clients.add(newClient);
        //TODO: newClient.sendTree(dirTree);
    }
}
