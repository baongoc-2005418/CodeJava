package BT13032025;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File folder = new File("C:\\Users\\Public\\Documents"); // Đổi đường dẫn phù hợp
        File[] files = folder.listFiles();

        if (files != null) {
            System.out.println("Danh sách file trong thư mục:");
            for (File file : files) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("Thư mục không tồn tại hoặc rỗng.");
        }
    }
}

