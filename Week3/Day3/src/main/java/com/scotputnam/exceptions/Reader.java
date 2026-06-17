package com.scotputnam.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Reader {
    public static void main(String[] args) {
        try{
            readAwfulFile();
        } catch (FileNotFoundException e) {
            System.out.println("File wasn't found");
        }
    }

    public static void readAwfulFile() throws FileNotFoundException {
        File f = new File("/not/a/real/path");
        System.out.println(f.exists());
        FileReader fr = new FileReader(f);
    }
}
