/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arles
 */
public class Server extends UnicastRemoteObject implements  ServerInterface{

    /*private*/public File rootDirectory;
    /*private*/public ArrayList<ClientInterface> clients;
    /*private*/public DirectoryTree dirTree;
    
    public Server(String path) throws RemoteException {
        rootDirectory = new File(path);
        this.clients = new ArrayList();
        this.dirTree = new DirectoryTree();
        fillTree(dirTree, rootDirectory);
    }

    public Server(File path) throws RemoteException {
        rootDirectory = path;
        this.clients = new ArrayList();
        this.dirTree = new DirectoryTree();
        fillTree(dirTree, rootDirectory);
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
    
    private void refillTree(DirectoryTree tree, File path){
        tree = new DirectoryTree();
        fillTree(tree, path);
    }
    
    private void sendTreeToAll() throws RemoteException{
        for (ClientInterface client : clients) {
            client.sendTree(dirTree);
        }
    }

    @Override
    public void joinServer(ClientInterface newClient) throws RemoteException{
        clients.add(newClient);
        try {
            newClient.sendTree(dirTree);
        } catch (RemoteException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendFileToServer(String data, String path) throws RemoteException {
        try {
            File filePath = new File(rootDirectory.getAbsolutePath() + path);
            filePath.getParentFile().mkdirs();
            FileWriter fr = new FileWriter(filePath);
            fr.write(data);
            fr.flush();
            fr.close();
            for (ClientInterface client : clients) {
                //client.notifyChangedFile();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createDirectory(String path) throws RemoteException {
        File newDir = new File(rootDirectory.getAbsolutePath() + path);
        newDir.mkdirs();
        refillTree(dirTree, rootDirectory);
        sendTreeToAll();
    }

    @Override
    public void requestFileFromServer(String path, ClientInterface client) throws RemoteException {
        String txtFile;
        System.out.println(this.rootDirectory.getAbsolutePath() + path);
        try {
            txtFile = new Scanner(new File(this.rootDirectory.getAbsolutePath() + path)).useDelimiter("\\Z").next();
            client.sendFile(txtFile, path);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sendNewFileToServer(String data, String path) throws RemoteException {
        try {
            File filePath = new File(rootDirectory.getAbsolutePath() + path);
            filePath.getParentFile().mkdirs();
            FileWriter fr = new FileWriter(filePath);
            fr.write(data);
            fr.flush();
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
