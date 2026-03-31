/**
 * ============================================================
 * MAIN CLASS - UseCase6RoomAllocationService
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class UseCase6RoomAllocationService {

    public static void main(String[] args) {

        System.out.println("===== ROOM ALLOCATION SYSTEM =====");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Booking queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Double"));
        queue.addRequest(new Reservation("Ram", "Single"));
        queue.addRequest(new Reservation("John", "Suite"));
        queue.addRequest(new Reservation("Arya", "Single"));

        // Allocation service
        RoomAllocationService allocator = new RoomAllocationService();

        // Process queue
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocator.allocateRoom(r, inventory);
        }

        System.out.println("\nFinal Inventory:");
        System.out.println(inventory.getRoomAvailability());
    }
}