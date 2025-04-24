package BT6032025;

public class ThreadInterruptExample {
    public static void main(String[] args) {
        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Worker thread is running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("Worker thread interrupted!");
                    return;
                }
            }
        });

        worker.start();

        try {
            Thread.sleep(3000); // Chờ 3 giây
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.interrupt();
        System.out.println("Main thread sent interrupt signal.");
    }
}
