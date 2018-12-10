/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmichat;

import java.io.Serializable;

/**
 *
 * @author Dario Mendoza
 */
public class TestClass implements Serializable{
    private int val1;
    private int val2;
    private String str;

    public TestClass() {
    }
    
    public TestClass(int val1, int val2, String str) {
        this.val1 = val1;
        this.val2 = val2;
        this.str = str;
    }

    public int getVal1() {
        return val1;
    }

    public void setVal1(int val1) {
        this.val1 = val1;
    }

    public int getVal2() {
        return val2;
    }

    public void setVal2(int val2) {
        this.val2 = val2;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestClass{" + "val1=" + val1 + ", val2=" + val2 + ", str=" + str + '}';
    }
}
