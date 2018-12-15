/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerGui;

import java.rmi.*;
import java.rmi.RemoteException;

/**
 *
 * @author Dario Mendoza
 */
public interface ServerInterface extends Remote{
    public void sendFileToServer(String data, String path) throws RemoteException;
    public void sendNewFileToServer(String data, String path) throws RemoteException;
    public void createDirectory(String path) throws RemoteException;
    public void joinServer(ClientInterface newClient) throws RemoteException;
    public void requestFileFromServer(String path, ClientInterface client) throws RemoteException;
}
