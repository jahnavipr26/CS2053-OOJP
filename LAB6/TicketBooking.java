package lab002;

public class TicketBooking {

    private int ticketsAvailable = 5;

    public synchronized boolean bookTicket(String user) {
        if (ticketsAvailable > 0) {
            System.out.println(user + " is booking ticket number " + ticketsAvailable);
            ticketsAvailable--;
            try {
                Thread.sleep(100); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(user + " successfully booked a ticket.");
            return true;
        } else {
            System.out.println("Sorry " + user + ", tickets are sold out.");
            return false;
        }
    }

    public static void main(String[] args) {
        TicketBooking bookingSystem = new TicketBooking();

        Runnable userTask = () -> {
            String userName = Thread.currentThread().getName();
            while (bookingSystem.bookTicket(userName)) {
              
            }
        };

        Thread user1 = new Thread(userTask, "User1");
        Thread user2 = new Thread(userTask, "User2");
        Thread user3 = new Thread(userTask, "User3");
        Thread user4 = new Thread(userTask, "User4");

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
