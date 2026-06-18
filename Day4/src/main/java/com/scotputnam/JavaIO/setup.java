package com.scotputnam.JavaIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class setup {
    static void setupSampleData() throws IOException {
        Path dataDir = Paths.get("data");
        Files.createDirectories(dataDir);

        Path csv = dataDir.resolve("scores.csv");

        if(!Files.exists(csv)){
            List<String> rows = List.of(
                    "Name,Score",
                    "Alice, 82",
                    "Bob, 88",
                    "Carol, 45",
                    "Dave, 37"
            );
            Files.write(csv, rows);
        }
    }
}
