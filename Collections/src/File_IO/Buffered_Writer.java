package File_IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buffered_Writer {
    public static void main(String[] args) {
        // Specify the file path and name
        String filePath = "example.txt";

        // Content to write to the file
        String content = "This file is always created or overwritten.!";

        // Using try-with-resources to ensure the writer is closed properly
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write content to the file
            writer.write(content);
            System.out.println("File created successfully: " + filePath);
        } catch (IOException e) {
            // Handle exceptions related to file operations
            System.err.println("An error occurred while creating the file: " + e.getMessage());
        }
    }
}
