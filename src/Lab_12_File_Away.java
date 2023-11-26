import javax.swing.*;
import java.io.*;

public class Lab_12_File_Away {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        } else {
            System.out.println("No file chosen.");
        }
    }

    private static void processFile(File file) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int lineCount = 0;
            int wordCount = 0;
            int charCount = 0;

            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split("\\s+");
                wordCount += words.length;
                charCount += line.length();
            }

            System.out.println("File Name found: " + file.getName());

            System.out.println("Number of Lines found: " + lineCount);

            System.out.println("Number of Words found: " + wordCount);

            System.out.println("Number of Characters found: " + charCount);

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
