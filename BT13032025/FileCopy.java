package BT13032025;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            System.out.println("Copy file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
