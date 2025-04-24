import java.util.LinkedList;
import java.util.Queue;

class TicketBuffer {
    private final int capacity;
    private final Queue<Integer> queue = new LinkedList<>();

    public TicketBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void sellTicket(int ticket) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(ticket);
        System.out.println("Ticket Sold: " + ticket);
        notifyAll();
    }

    public synchronized int buyTicket() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        int ticket = queue.poll();
        System.out.println("Ticket Bought: " + ticket);
        notifyAll();
        return ticket;
    }
}

class TicketSeller extends Thread {
    private final TicketBuffer buffer;

    public TicketSeller(TicketBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int ticket = 0;
        while (true) {
            try {
                buffer.sellTicket(ticket++);
                sleep(100); // Simulate time taken to sell a ticket
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class TicketBuyer extends Thread {
    private final TicketBuffer buffer;

    public TicketBuyer(TicketBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                buffer.buyTicket();
                sleep(150); // Simulate time taken to buy a ticket
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class TrainTicketSelling {
    public static void main(String[] args) {
        TicketBuffer buffer = new TicketBuffer(5);

        TicketSeller seller = new TicketSeller(buffer);
        TicketBuyer buyer = new TicketBuyer(buffer);

        seller.start();
        buyer.start();
    }
}