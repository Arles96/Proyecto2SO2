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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends UnicastRemoteObject implements ClientInterface {

    private ServerInterface server;
    public DirectoryTree tree;
    private boolean active;
    private File rootFolder;
    private String path;
    private File metadata;

    public Client(String path) throws RemoteException{
        rootFolder = new File(path);
        metadata = new File(".\\DFSMetadata.txt");
        /*FileWriter fr = new FileWriter(metadata);
        fr.append("");
        fr.flush();
        fr.close();*/
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

    public File getRootFolder() {
        return rootFolder;
    }

    public void setRootFolder(File rootFolder) {
        this.rootFolder = rootFolder;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public void sendFile(String data, String path) throws RemoteException {
        try {
            this.path = path;
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
        this.tree = tree;
    }

    @Override
    public String getDataFile() throws RemoteException {
        String data = "";
        try {
            String string;
            File filePath = new File(rootFolder.getAbsolutePath() + path);
            FileReader f = new FileReader(filePath);
            BufferedReader b = new BufferedReader(f);
            while ((string = b.readLine()) != null) {
                data += string;
            }
            b.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void createDirectory(String path) throws RemoteException {
        File newDir = new File(rootFolder.getAbsolutePath() + path);
        newDir.mkdirs();
    }

    @Override
    public void createFile(String data, String path) throws RemoteException {
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
    public void notifyChangedFile(String path) throws RemoteException {
        ArrayList<String> metadataList = readMetadata();
        System.out.println("metadata: " + metadataList);
        System.out.println("notify " + path);
        if (!metadataList.contains(path)) {
            try {
                FileWriter fr = new FileWriter(metadata, true);
                fr.write("\n");
                fr.write(path);
                fr.flush();
                fr.close();
                System.out.println("Notificado");
            } catch (IOException ex) {
                ex.printStackTrace();
                System.out.println("Error en escritura de cache.");
            }
        }
    }

    public boolean isInvalid(String path) {
        ArrayList<String> metadataList = readMetadata();
        return metadataList.contains(path);
    }

    @Override
    public void setValid(String path) {
        ArrayList<String> metadataList = readMetadata();
        System.out.println("Antes de remover " + metadataList);
        metadataList.remove(path);
        System.out.println("Despues de remover " + metadataList);
        
        writeMetadata(metadataList);
    }

    private ArrayList<String> readMetadata() {
        ArrayList<String> arr = new ArrayList();
        System.out.println("Antes de leer");
        try {
            Scanner sc = new Scanner(metadata);
            while (sc.hasNextLine()) {
                arr.add(sc.nextLine());
            }
            System.out.println("Leyo la metadata");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error en lectura de cache.");
        }

        return arr;
    }

    private void writeMetadata(ArrayList<String> metadataList) {
        try {
            FileWriter fr = new FileWriter(metadata);
            for (String string : metadataList) {
                fr.append("\n");
                fr.append(string);
            }
            fr.flush();
            fr.close();
            System.out.println("Escribio la metadata");
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error en escritura de cache.");
        }
    }
}
