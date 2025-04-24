package BT6032025;

public class ThreadPriorityExample3 {
    public static void main(String[] args) {
        Thread highPriority = new Thread(() -> {
            while (true) {
                System.out.println("High priority thread running...");
            }
        });

        Thread lowPriority = new Thread(() -> {
            while (true) {
                System.out.println("Low priority thread running...");
            }
        });

        highPriority.setPriority(Thread.MAX_PRIORITY);
        lowPriority.setPriority(Thread.MIN_PRIORITY);

        highPriority.start();
        lowPriority.start();
    }
}
