/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmichat;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Dario Mendoza
 */
public class TestTree implements Serializable{
    private TestTree parent;
    private ArrayList<TestTree> children;
    private int val;

    public TestTree() {
        this.parent = null;
        this.children = new ArrayList();
    }

    public TestTree(int val) {
        this.parent = null;
        this.children = new ArrayList();
        this.val = val;
    }
    
    public TestTree(TestTree parent) {
        this.parent = parent;
        this.children = new ArrayList();
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
        child.setParent(this);
        this.children.add(child);
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TestTree{" + "children=" + children + ", val=" + val + '}';
    }
}
