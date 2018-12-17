/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase para agregar los nodos al JTree
 * @author arles
 */
public class DirectoryTreeClient extends DefaultMutableTreeNode {
    
    private String name;
    private String path;
    private boolean directory;

    public DirectoryTreeClient() {
    }

    public DirectoryTreeClient(Object userObject) {
        super(userObject);
    }

    public DirectoryTreeClient(String name, String path, boolean directory) {
        super(name);
        this.name = name;
        this.path = path;
        this.directory = directory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPathFile() {
        return path;
    }

    public void setPathFile(String path) {
        this.path = path;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }    
}
