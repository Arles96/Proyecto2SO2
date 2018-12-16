/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

/**
 *
 * @author xioma
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends UnicastRemoteObject implements ClientInterface {

    private ServerInterface server;
    public DirectoryTree tree;
    private boolean active;
    private File rootFolder;

    public Client(String path) throws RemoteException {
        rootFolder = new File(path);
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
    public void sendFile(String data, String path) throws RemoteException {
        try {
            File filePath = new File(rootFolder.getAbsolutePath() + path);
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

    @Override
    public void sendTree(DirectoryTree tree) throws RemoteException {
        Test.PrintTree(tree, "");
    }
}
