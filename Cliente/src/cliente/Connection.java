/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author arles
 */
public class Connection {
    
    private Registry register;
    public final String NAMECONNECTION = "DFS_Server";
    private Server server;

    public Connection(String host, int port) throws RemoteException, NotBoundException {
        this.register = LocateRegistry.getRegistry(host, port);
        this.server = (Server)this.register.lookup(NAMECONNECTION);
    }
    
    public Connection (int port) throws RemoteException, NotBoundException {
        this.register = LocateRegistry.getRegistry(port);
        this.server = (Server) this.register.lookup(NAMECONNECTION);
    }

    public Connection() {
    }

    public Registry getServer() {
        return register;
    }

    public void setServer(Registry server) {
        this.register = server;
    }
    
    public void setConnection(String host, int port) throws RemoteException {
        this.register = LocateRegistry.getRegistry(host, port);
    }
    
    public void status () {
        if (this.register != null) {
            System.out.println("Conectado");
        } else {
            System.out.println("No esta conectado");
        }
    }
    
}
