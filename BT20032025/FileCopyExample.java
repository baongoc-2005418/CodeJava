package BT20032025;

import java.io.*;

public class FileCopyExample {
    public static void main(String[] args) {
        String inputFile = "input.txt";  // File nguồn
        String outputFile = "output.txt"; // File đích

        try (FileInputStream fis = new FileInputStream(inputFile);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("Sao chép file thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}

