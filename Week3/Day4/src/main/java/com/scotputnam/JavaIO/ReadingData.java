package com.scotputnam.JavaIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class ReadingData {

    static void inspectPath() throws IOException{
        Path path = Paths.get("data/scores.csv");
        System.out.println("Path: " + path);

        System.out.println("Path: " + path);
        System.out.println("Absolute Path: " + path.toAbsolutePath());
        System.out.println("File Name: " + path.getFileName());
        System.out.println("Parent Dir: " + path.getParent());
        System.out.println("Exists: " + Files.exists(path));
        System.out.println("Is regular file: " + Files.isRegularFile(path));
        System.out.println("Size (bytes): " + Files.size(path));

        BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
        System.out.println(attr.lastModifiedTime());
    }

    static void readWithBufferedReader(){
        Path path = Paths.get("data/scores.csv");

        //try-with-resources guarantees reader is always closed
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)){
            String line;
            int lineNum = 0;
            while((line = reader.readLine()) != null){
                lineNum++;
                System.out.printf("  Line %2d: %s%n", lineNum, line);
            }
        } catch (IOException e) {
            System.err.println("Could not read file: " + e.getStackTrace());;
        }

    }

    // reading files with convenience methods (since Java 11)

    static void readWithFilesAPI() throws IOException {
        Path path = Paths.get("data/scores.csv");

        // Option A: all lines as List<String> (Java 7+)
        System.out.println("-- readAllLines():");
        List<String> lines = Files.readAllLines(path);
        lines.forEach(l-> System.out.println("  " + l));

        // Option B: entire file as a single string
        System.out.println("\n--readString():");
        String content = Files.readString(path);
        System.out.println(content);
    }
}
