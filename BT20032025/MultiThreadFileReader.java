package BT20032025;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class MultiThreadFileReader {
    private static final String OUTPUT_FILE = "output.txt";
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java MultiThreadFileReader <directory-path>");
            return;
        }

        File folder = new File(args[0]);
        if (!folder.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                executor.execute(() -> readFileAndWrite(file));
            }
        }
        executor.shutdown();
    }

    private static void readFileAndWrite(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            synchronized (LOCK) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
                    writer.write("--- " + file.getName() + " ---\n");
                    writer.write(content.toString());
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
