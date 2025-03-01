import java.util.ArrayList;
import java.util.List;

class TicketBookingSystem {
    private List<Integer> availableSeats = new ArrayList<>();

    public TicketBookingSystem(int totalSeats) {
        for (int i = 1; i <= totalSeats; i++) {
            availableSeats.add(i);
        }
    }

    public synchronized boolean bookSeat(String customerType) {
        if (!availableSeats.isEmpty()) {
            int seat = availableSeats.remove(0);
            System.out.println(customerType + " booked seat number: " + seat);
            return true;
        } else {
            System.out.println("No seats available for " + customerType);
            return false;
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem system;
    private String customerType;

    public BookingThread(TicketBookingSystem system, String customerType, int priority) {
        this.system = system;
        this.customerType = customerType;
        setPriority(priority);
    }

    public void run() {
        system.bookSeat(customerType);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem(5);

        BookingThread vip1 = new BookingThread(system, "VIP Customer 1", Thread.MAX_PRIORITY);
        BookingThread vip2 = new BookingThread(system, "VIP Customer 2", Thread.MAX_PRIORITY);
        BookingThread regular1 = new BookingThread(system, "Regular Customer 1", Thread.NORM_PRIORITY);
        BookingThread regular2 = new BookingThread(system, "Regular Customer 2", Thread.NORM_PRIORITY);
        BookingThread regular3 = new BookingThread(system, "Regular Customer 3", Thread.NORM_PRIORITY);

        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();
        regular3.start();
    }
}
