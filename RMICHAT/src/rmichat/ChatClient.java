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

public class ChatClient {

    public static void main(String[] argv) {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nombre:");
            String name = s.nextLine().trim();
            ChatInterface client = new Chat(name);
            //TODO: Change host in gui
            Registry registry = LocateRegistry.getRegistry(/*"192.168.43.44",*/8888);
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
