package com.k7;

import java.io.*;

public class Main {

    public static File findAbsoluteFile(File dir, String fileName) {
        File rez = null;
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
        findAbsoluteFile(path, "test.txt").listFiles();
    }
}