package BT13032025;

import java.io.*;

public class IntegerFile {
    public static void main(String[] args) {
        String fileName = "numbers.dat";

        // Ghi danh sách số nguyên vào file
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            int[] numbers = {10, 20, 30, 40, 50};
            for (int num : numbers) {
                dos.writeInt(num);
            }
            System.out.println("Ghi file thành công!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Đọc danh sách số nguyên từ file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            System.out.println("Danh sách số nguyên từ file:");
            while (dis.available() > 0) {
                System.out.println(dis.readInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

