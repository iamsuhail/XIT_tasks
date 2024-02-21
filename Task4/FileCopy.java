// 2. Copy text file to another text file

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {

    public static void main(String[] args) {
        String sourceFilePath = "C:XIT\\Tasks\\Task4\\copy1.txt";
        String destinationFilePath = "C:XIT\\Tasks\\Task4\\copy2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("File copied successfully.");

        } catch (IOException e) {
            System.err.println("Error during file copy: " + e.getMessage());
        }
    }
}
