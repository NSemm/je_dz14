package com.k7;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static List<File> findAbsoluteFile(List<File> rezList, File dir, String fileName) {
        for (File list : dir.listFiles()) {
            if (list.isDirectory()) findAbsoluteFile(rezList, list.getAbsoluteFile(), fileName);
            if (list.getName().equals(fileName)) rezList.add(new File(list.getAbsoluteFile().getPath()));
        }
        //System.out.println(rez);
        return rezList;
    }

        public static File findAbsoluteFile(File dir, String fileName) {
        File rez= null;
        for (File list : dir.listFiles()) {
            if (list.isDirectory()) findAbsoluteFile(list.getAbsoluteFile(), fileName);
                rez = list.getName().equals(fileName) ? list.getAbsoluteFile() : null;
            }
        System.out.println(rez);
        return rez;
    }


    public static void main(String[] args) {
        File file = new File("test.txt");
        File path = new File(".");
        List<File> rez = new LinkedList<>();
        if (path.isDirectory() && path.exists()) {
            findAbsoluteFile(rez, path, "test.txt");
            for (File f : rez) {
                System.out.println(f);
            }
            System.out.println("-------------------");
            System.out.println("file: "+findAbsoluteFile(path, "test.txt"));
        } else {
            System.out.println("Invalid path or not directory");
        }

    }
}