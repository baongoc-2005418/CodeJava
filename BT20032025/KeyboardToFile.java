package BT20032025;

import java.io.*;

public class KeyboardToFile {
    public static void main(String[] args) {
        String outputFile = "output.txt"; // Tên file để lưu dữ liệu nhập

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            System.out.println("Nhập nội dung (gõ 'exit' để dừng):");

            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Dữ liệu đã được ghi vào file " + outputFile);
        } catch (IOException e) {
            System.err.println("Lỗi: " + e.getMessage());
        }
    }
}
