/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerGui;

import java.io.File;

/**
 *
 * @author Dario Mendoza
 */
public class TestTransfer {
    String user = System.getenv("UserProfile");
    String dfsFolder = "DFS_Files";
    String rootFolder = user + "\\Documents\\" + dfsFolder;
    File f = new File(rootFolder);
}
