/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmichat;

import java.util.ArrayList;

/**
 *
 * @author Dario Mendoza
 */
public class TestTree {
    private TestTree parent;
    private ArrayList<TestTree> children;

    public TestTree() {
        parent = null;
        children = new ArrayList();
    }

    public TestTree getParent() {
        return parent;
    }

    public void setParent(TestTree parent) {
        this.parent = parent;
    }

    public ArrayList<TestTree> getChildren() {
        return children;
    }
    
    public TestTree getChild(int i) {
        return children.get(i);
    }
    
    public void setChildren(ArrayList<TestTree> children) {
        this.children = children;
    }
    
    public void addChildren(TestTree child) {
        this.children.add(child);
    }
    
}
