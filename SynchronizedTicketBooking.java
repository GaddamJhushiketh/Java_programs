// Illustration of ticket booking using synchronized methods

class TicketBookingSystem 
{
    private int availableTickets;
    public TicketBookingSystem(int tickets) 
    {
        this.availableTickets = tickets;
    }
    // Synchronized method to book tickets
    public synchronized void bookTicket(String passengerName, int numberOfTickets) 
    {
        System.out.println(passengerName + " is trying to book " + numberOfTickets + " ticket(s).");
        if (numberOfTickets <= availableTickets) 
        {
            System.out.println("Booking successful for " + passengerName + ".");
            availableTickets -= numberOfTickets;
            System.out.println("Tickets remaining: " + availableTickets);
        } 
        else 
        {
            System.out.println("Booking failed for " + passengerName + ". Not enough tickets available.");
        }
    }
}

class BookingThread extends Thread 
{
    private TicketBookingSystem bookingSystem;
    private String passengerName;
    private int ticketsToBook;

    public BookingThread(TicketBookingSystem bookingSystem, String passengerName, int ticketsToBook) 
    {
        this.bookingSystem = bookingSystem;
        this.passengerName = passengerName;
        this.ticketsToBook = ticketsToBook;
    }
    @Override
    public void run() 
    {
        bookingSystem.bookTicket(passengerName, ticketsToBook);
    }
}

public class SynchronizedTicketBooking 
{
    public static void main(String[] args) {
        // Create a TicketBookingSystem with 10 tickets available
        TicketBookingSystem bookingSystem = new TicketBookingSystem(10);
        // Create threads for booking tickets
        BookingThread passenger1 = new BookingThread(bookingSystem, "Jhushiketh", 4);
        BookingThread passenger2 = new BookingThread(bookingSystem, "Aakash", 6);
        BookingThread passenger3 = new BookingThread(bookingSystem, "Sameeer", 3);
        // Start threads
        passenger1.start();
        passenger2.start();
        passenger3.start();
    }
}

