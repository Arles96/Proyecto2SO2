/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connections;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dario Mendoza
 */
public class DirectoryTree implements Serializable{
    private DirectoryTree parent;
    private ArrayList<DirectoryTree> children;
    private String name;
    private boolean directory;
    private String path;

    public DirectoryTree() {
        this.parent = null;
        this.children = new ArrayList();
        this.name = "\\";
        this.directory = true;
        this.path = "";
    }

    public DirectoryTree(String name, boolean directory) {
        this.name = name;
        this.directory = directory;
        this.parent = null;
        this.children = new ArrayList();
        this.path = "";
    }
    
    public DirectoryTree(DirectoryTree parent) {
        this.parent = parent;
        this.children = new ArrayList();
    }

    public DirectoryTree getParent() {
        return parent;
    }

    public void setParent(DirectoryTree parent) {
        this.parent = parent;
    }

    public ArrayList<DirectoryTree> getChildren() {
        return children;
    }
    
    public DirectoryTree getChild(int i) {
        return children.get(i);
    }
    
    public void setChildren(ArrayList<DirectoryTree> children) {
        this.children = children;
    }
    
    public void addChildren(DirectoryTree child) {
        child.setParent(this);
        child.setPath(path + "\\" + child.getName());
        this.children.add(child);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDirectory() {
        return directory;
    }

    public void setDirectory(boolean directory) {
        this.directory = directory;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public DirectoryTree lastChild(){
        return children.get(children.size() - 1);
    }
    
    public boolean hasChildren(){
        return !children.isEmpty();
    }
    
    @Override
    public String toString() {
        return name + "\\" + children;
    }
}
