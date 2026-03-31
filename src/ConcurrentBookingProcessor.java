/**
 * ============================================================
 * CLASS - ConcurrentBookingProcessor
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * @version 11.0
 */
public class ConcurrentBookingProcessor implements Runnable {

    /** Shared booking queue */
    private BookingRequestQueue bookingQueue;

    /** Shared inventory */
    private RoomInventory inventory;

    /** Shared allocation service */
    private RoomAllocationService allocationService;

    /**
     * Constructor
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Thread execution logic
     */
    @Override
    public void run() {

        while (true) {
            Reservation reservation;

            // 🔒 Synchronize queue access
            synchronized (bookingQueue) {
                if (!bookingQueue.hasPendingRequests()) {
                    break;
                }
                reservation = bookingQueue.getNextRequest();
            }

            // 🔒 Synchronize inventory mutation
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}