/**
 * ============================================================
 * MAIN CLASS - UseCase11ConcurrentBookingSimulation
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("===== CONCURRENT BOOKING SIMULATION =====");

        // Shared resources
        RoomInventory inventory = new RoomInventory();
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomAllocationService allocationService = new RoomAllocationService();

        // Add requests
        bookingQueue.addRequest(new Reservation("A", "Single"));
        bookingQueue.addRequest(new Reservation("B", "Single"));
        bookingQueue.addRequest(new Reservation("C", "Double"));
        bookingQueue.addRequest(new Reservation("D", "Suite"));
        bookingQueue.addRequest(new Reservation("E", "Single"));

        // Threads
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService)
        );

        // Start threads
        t1.start();
        t2.start();

        // Wait for completion
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        System.out.println("\nFinal Inventory: " + inventory.getRoomAvailability());
    }
}