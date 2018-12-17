/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author arles
 */
public class Connection {
    
    private Registry registry;
    public final String NAMECONNECTION = "DFS_Server";
    private ServerInterface server;
    private ClientInterface client;

    public Connection(String host, int port) throws RemoteException, NotBoundException {
        this.registry = LocateRegistry.getRegistry(host, port);
        this.server = (Server)this.registry.lookup(NAMECONNECTION);
    }
    
    public Connection (int port) throws RemoteException, NotBoundException {
        client = new Client(System.getenv("UserProfile") + "\\Documents\\ClientFiles");
        registry = LocateRegistry.getRegistry(port);
        server = (ServerInterface) registry.lookup("DFS_Server");
        server.joinServer(client);
        // server.requestFileFromServer("\\folder1\\text1.txt", client);
    }

    public Connection() {
    }

    public Registry getRegistry() {
        return registry;
    }

    public void setRegistry(Registry server) {
        this.registry = server;
    }

    public ServerInterface getServer() {
        return server;
    }

    public void setServer(ServerInterface server) {
        this.server = server;
    }

    public ClientInterface getClient() {
        return client;
    }

    public void setClient(ClientInterface client) {
        this.client = client;
    }
    
    
    
    public void setConnection(String host, int port) throws RemoteException {
        this.registry = LocateRegistry.getRegistry(host, port);
    }
    
    public void setConnection (String host) throws RemoteException, NotBoundException {
        client = new Client(System.getenv("UserProfile") + "\\Documents\\ClientFiles");
        registry = LocateRegistry.getRegistry(host,8888);
        server = (ServerInterface) registry.lookup("DFS_Server");
        server.joinServer(client);
        server.requestFileFromServer("\\folder1\\text1.txt", client);
    }
    
    public void status () {
        if (this.registry != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No esta conectado");
        }
    }
    
    public static void testConnection () throws RemoteException, NotBoundException {
        ClientInterface client = new Client(System.getenv("UserProfile") + "\\Documents\\ClientFiles");
        Registry registry = LocateRegistry.getRegistry("192.168.1.15",8888);
        ServerInterface server = (ServerInterface) registry.lookup("DFS_Server");
        server.joinServer(client);
        server.requestFileFromServer("\\folder1\\text1.txt", client);
    }
    
    public void desconnect () {
        this.registry = null;
        this.server = null;
        this.client = null;
    }
    
}
