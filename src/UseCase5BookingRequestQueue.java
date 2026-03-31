/**
 * ============================================================
 * MAIN CLASS - UseCase5BookingRequestQueue
 * ============================================================
 *
 * Use Case 5: Booking Request (FIFO)
 *
 * @version 5.0
 */
public class UseCase5BookingRequestQueue {

    public static void main(String[] args) {

        // Display application header
        System.out.println("===== Booking Request Queue =====");

        // Initialize booking queue
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Create booking requests
        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Double");
        Reservation r3 = new Reservation("Vanmathi", "Suite");

        // Add requests to queue
        bookingQueue.addRequest(r1);
        bookingQueue.addRequest(r2);
        bookingQueue.addRequest(r3);

        System.out.println("\nProcessing booking requests (FIFO):");

        // Process requests in FIFO order
        while (bookingQueue.hasPendingRequests()) {
            Reservation r = bookingQueue.getNextRequest();

            System.out.println("Guest: " + r.getGuestName()
                    + " | Requested Room: " + r.getRoomType());
        }
    }
}