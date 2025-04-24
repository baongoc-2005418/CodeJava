package BT6032025;

public class MemoryVisibilityExample {
    private static volatile boolean flag = false;

    public static void main(String[] args) {
        Thread reader = new Thread(() -> {
            while (!flag) {

            }
            System.out.println("Reader thread detected flag change!");
        });

        Thread writer = new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("Writer thread changed flag.");
        });

        reader.start();
        writer.start();
    }

}
