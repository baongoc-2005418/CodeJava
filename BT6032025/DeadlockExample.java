package BT6032025;

class Resource {
    private final String name;

    public Resource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        Resource r1 = new Resource("Resource 1");
        Resource r2 = new Resource("Resource 2");

        Thread t1 = new Thread(() -> {
            synchronized (r1) {
                System.out.println("Thread 1 locked " + r1.getName());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (r2) {
                    System.out.println("Thread 1 locked " + r2.getName());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (r1) { // Đổi thứ tự khóa giúp tránh deadlock
                System.out.println("Thread 2 locked " + r1.getName());
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                synchronized (r2) {
                    System.out.println("Thread 2 locked " + r2.getName());
                }
            }
        });

        t1.start();
        t2.start();
    }
}

