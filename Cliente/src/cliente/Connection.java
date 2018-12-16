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
import java.util.Scanner;
import test.Chat;
import test.ChatInterface;

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
    
    public static void testConnection () {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nombre:");
            String name = s.nextLine().trim();
            ChatInterface client = new Chat(name);
            //TODO: Change host in gui
            Registry registry = LocateRegistry.getRegistry(8888);
            ChatInterface server = (ChatInterface) registry.lookup("ejemplo");
            String msg = "[" + client.getName() + "] conectado!";
            server.send(msg);
            System.out.println("Servicio listo");
            server.setClient(client);

            while (true) {
                msg = s.nextLine().trim();
                msg = "[" + client.getName() + "] " + msg;
                server.send(msg);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[System] Server failed (server): " + e);
        }
    }
    
}
