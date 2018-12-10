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
import java.rmi.server.*;
import java.util.ArrayList;
 
public class Chat extends UnicastRemoteObject implements ChatInterface  {
 
	public String name;
	public ArrayList<ChatInterface> client = new ArrayList();
        public ArrayList<String> messages = new ArrayList();
        
            
	public Chat(String n)  throws RemoteException { 
		this.name=n;   
	}
	public String getName() throws RemoteException {
		return this.name;
	}
 
	public void setClient(ChatInterface c){
		client.add(c);
	}
 
	public ChatInterface getClient(int i){
		return client.get(i);
	}
 
	public void send(String s) throws RemoteException{
		System.out.println(s);
                messages.add(s);
	}
        
        public void sendObj(Object s) throws RemoteException{
            System.out.println(s);
	}
}