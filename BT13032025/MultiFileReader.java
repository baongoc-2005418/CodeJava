package BT13032025;

public class MultiFileReader {
    public static void main(String[] args) {
        String[] files = {"input1.txt", "input2.txt"};

        for (String file : files) {
            new FileReaderThread(file).start();
        }
    }
}

