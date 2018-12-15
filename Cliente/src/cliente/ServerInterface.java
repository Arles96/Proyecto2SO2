/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dario Mendoza
 */
public interface ServerInterface extends Remote{
    public void sendFileToServer() throws RemoteException;
    public void createDirectory(String path) throws RemoteException;
    public void login(ClientInterface newClient) throws RemoteException;
    public void requestFileFromServer(String path) throws RemoteException;
}
