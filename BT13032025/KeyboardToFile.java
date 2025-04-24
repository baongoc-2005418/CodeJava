package BT13032025;

import java.io.*;

public class KeyboardToFile {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter("output.txt")) {
            System.out.println("Nhập nội dung (gõ 'exit' để dừng):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + "\n");
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

