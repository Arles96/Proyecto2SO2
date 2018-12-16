/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Dario Mendoza
 */
public class Test {
    public static void main(String[] argv) throws FileNotFoundException{
        DirectoryTree tree = new DirectoryTree("\\", true);
        String user = System.getenv("UserProfile");
        String dfsFolder = "DFS_Files";
        String rootFolder = user + "\\Documents\\" + dfsFolder;
        File f = new File(rootFolder);
        FillTree(tree, f);
        PrintTree(tree, "");
        System.out.println(ReadEntireFile(tree.getChild(0).getChild(0).getChild(0).getPath(), rootFolder));
        //System.out.println(Arrays.toString(f.list()));
        //System.out.println(tree.getChild(0).getChild(0));
    
    }
    
    public static void FillTree(DirectoryTree tree, File path){
        for (File file : path.listFiles()) {
            if (file.isDirectory()){
                tree.addChildren(new DirectoryTree(file.getName(), false));
                FillTree(tree.getChild(tree.getChildren().size() - 1), file);
            }else{
                tree.addChildren(new DirectoryTree(file.getName(), false));
            }
        }
    }
    
    public static void PrintTree(DirectoryTree tree, String tabs){
        System.out.println(tabs + tree.getName() + "\t" + tree.getPath());
        for (DirectoryTree dirTree : tree.getChildren()) {
            PrintTree(dirTree, tabs + "\t");
        }
    }
    
    public static String ReadEntireFile(String path, String rootFolder) throws FileNotFoundException{
        String txtFile = new Scanner(new File(rootFolder + path)).useDelimiter("\\Z").next();
        
        return txtFile;
    }
}

