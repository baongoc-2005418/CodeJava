package BT13032025;

import java.io.*;

class FileReaderThread extends Thread {
    private String fileName;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            System.out.println("Nội dung file: " + fileName);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

