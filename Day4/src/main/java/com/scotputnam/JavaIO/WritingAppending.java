package com.scotputnam.JavaIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

public class WritingAppending {

    public static void writeToDirectory() throws IOException {
        // Three methods of writing/appending
        // BufferedWriter, writeString, write(List)

        Path outDir = Paths.get("data/");
        Files.createDirectories(outDir);

        // write with buffered writer
        Path report = outDir.resolve("result.txt");
        try(BufferedWriter writer = Files.newBufferedWriter(report)){

            writer.write("=== Test Run Report ===");
            writer.newLine();
            writer.write("Generated: " + LocalDateTime.now());
            writer.newLine();
        }

        // Append
        try(BufferedWriter writer = Files.newBufferedWriter(report, StandardOpenOption.APPEND)){
            writer.write("Pass: Login Test");
            writer.newLine();
            writer.write("FAIL: Checkout Test");
            writer.newLine();
        }
        System.out.println("Wrote: " + report.toAbsolutePath());

        // Files.writeString() - most concise -
        Path summary = outDir.resolve("summary.txt");
        Files.writeString(summary, "Total: 50 | Pass: 48 | Fail: 2\n");
        System.out.println("Summary written: " + Files.readString(summary));

        // Files.write(List)
        Path results = outDir.resolve("results_list.txt");
        List<String> entries = List.of("PASS loginTest", "PASS searchTest", "FAIL CheckoutTest");
        Files.write(results,entries);
        System.out.println("Results list written" + Files.readAllLines(results));


    }

    public static void endToEndScenario() throws IOException {
        Path input = Paths.get("data/scores.csv");
        Path output = Paths.get("output/failures.txt");

        // read all lines
        List<String> failures = Files.readAllLines(input)
                .stream()
                .skip(1)    // skips headers
                .filter(line ->{
                    String[] parts = line.split(",");
                    int score = Integer.parseInt(parts[1].trim());
                    return score < 50;
                }).toList();

        // write filtered report
        Files.createDirectories(output.getParent());
        Files.write(output, failures);

        System.out.println("Failures Found: " + failures.size());
        System.out.println("Report Saved: " + output.toAbsolutePath());
        failures.forEach(s -> System.out.println(" >> " + s));
    }



}
