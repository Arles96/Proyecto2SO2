/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmichat;

/**
 *
 * @author xioma
 */
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.*;

public class ChatServer {

    public static void main(String[] argv) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nombre: ");
            String name = s.nextLine().trim();
            
            Chat server = new Chat(name);
            Registry registry = LocateRegistry.createRegistry(8888);
            registry.bind("ejemplo", server);

            while (true) {
                String msg = s.nextLine().trim();
                for (int i = 0; i < server.client.size(); i++) {
                    if (server.getClient(i) != null) {
                        ChatInterface client = server.getClient(i);
                        // String newMsg = "[" + server.getName() + "] " + msg;
                        // TestClass newMsg = new TestClass(1,2,"3");
                        TestTree newMsg = new TestTree(0);
                        newMsg.addChildren(new TestTree(1));
                        newMsg.addChildren(new TestTree(2));
                        newMsg.getChild(0).addChildren(new TestTree(22));
                        //System.out.println(newMsg);
                        client.sendObj(newMsg);
                        //client.send(newMsg);
                    }
                }
                
                for (String message : server.messages) {
                    System.out.println(message);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("[System] Server failed (client): " + e);
        }
    }
}
