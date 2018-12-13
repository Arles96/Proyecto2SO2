/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author arles
 */
public class Connection {
    
    private Registry server;

    public Connection(String host, int port) throws RemoteException {
        this.server = LocateRegistry.getRegistry(host, port);
    }

    public Connection() {
    }

    public Registry getServer() {
        return server;
    }

    public void setServer(Registry server) {
        this.server = server;
    }
    
    public void setConnection(String host, int port) throws RemoteException {
        this.server = LocateRegistry.getRegistry(host, port);
    }
    
}
