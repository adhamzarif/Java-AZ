package File_IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Buffered_Reader {
    public static void main(String[] args) {
        // Specify the file path and name
        String filePath = "example.txt";

        // Reading the content of the file using BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("Reading the file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // Handle exceptions related to file reading
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
