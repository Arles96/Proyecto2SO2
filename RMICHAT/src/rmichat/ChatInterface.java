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
 
public interface ChatInterface extends Remote{
	public String getName() throws RemoteException;
	public void send(String msg) throws RemoteException;
        public void sendObj(Object msg) throws RemoteException;
	public void setClient(ChatInterface c)throws RemoteException;
	public ChatInterface getClient(int i) throws RemoteException;
}