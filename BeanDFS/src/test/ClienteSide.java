package test;


import connections.Client;
import connections.ClientInterface;
import connections.ServerInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dario Mendoza
 */
public class ClienteSide {
    public static void main(String[] argv) throws RemoteException, NotBoundException{
        ClientInterface client = new Client(System.getenv("UserProfile") + "\\Documents\\ClientFiles");
        Registry registry = LocateRegistry.getRegistry("192.168.1.15",8888);
        ServerInterface server = (ServerInterface) registry.lookup("DFS_Server");
        server.joinServer(client);
        server.requestFileFromServer("\\folder1\\text1.txt", client);
    }
}
