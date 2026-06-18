package com.scotputnam.JavaIO;

import java.io.IOException;

public class DemoIO {
    static void main() {
        try {
            setup.setupSampleData();
            ReadingData.inspectPath();
            ReadingData.readWithBufferedReader();
            WritingAppending.writeToDirectory();
            WritingAppending.endToEndScenario();

        } catch (IOException e) {
            System.out.println("File Error Occured: ");
            e.printStackTrace();
        }
    }
}
