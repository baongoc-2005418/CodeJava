package BT20032025;

import java.io.*;

public class IntegerFileIO {
    public static void main(String[] args) {
        String fileName = "numbers.dat"; // Tên file để lưu danh sách số nguyên

        // Ghi danh sách số nguyên vào file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50}; // Danh sách số nguyên
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Ghi dữ liệu vào file thành công!");
        } catch (IOException e) {
            System.err.println("Lỗi khi ghi file: " + e.getMessage());
        }

        // Đọc danh sách số nguyên từ file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Các số nguyên trong file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }
}

