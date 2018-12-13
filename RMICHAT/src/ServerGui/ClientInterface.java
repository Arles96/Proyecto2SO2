/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerGui;

import java.rmi.RemoteException;

/**
 *
 * @author Dario Mendoza
 */
public interface ClientInterface {
    public void sendFile(String data) throws RemoteException;
    public void sendTree(DirectoryTree tree) throws RemoteException;
}
