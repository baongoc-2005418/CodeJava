package BT20032025;

import java.io.*;

public class CountLinesInFile {
    public static void main(String[] args) {
        String inputFile = "input.txt"; // File cần đếm số dòng

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            int lineCount = 0;
            while (reader.readLine() != null) {
                lineCount++;
            }

            System.out.println("Số dòng trong file '" + inputFile + "' là: " + lineCount);
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

