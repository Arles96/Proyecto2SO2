/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import java.rmi.*;
import java.rmi.RemoteException;

/**
 *
 * @author Dario Mendoza
 */
public interface ClientInterface extends Remote{
    public void sendFile(String data, String path) throws RemoteException;
    public void sendTree(DirectoryTree tree) throws RemoteException;
    public String getDataFile () throws RemoteException;
}
