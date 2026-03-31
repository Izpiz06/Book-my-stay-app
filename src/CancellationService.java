import java.util.*;

/**
 * ============================================================
 * CLASS - CancellationService
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * @version 10.0
 */
public class CancellationService {

    /** Stack storing recently released room IDs */
    private Stack<String> releasedRoomIds;

    /** Maps reservation ID → room type */
    private Map<String, String> reservationRoomTypeMap;

    /** Initialize structures */
    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    /**
     * Register confirmed booking
     */
    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    /**
     * Cancel booking and restore inventory
     */
    public void cancelBooking(String reservationId, RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Invalid cancellation: Reservation not found");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        // Restore inventory
        Map<String, Integer> availability = inventory.getRoomAvailability();
        inventory.updateAvailability(roomType, availability.get(roomType) + 1);

        // Track rollback
        releasedRoomIds.push(reservationId);

        // Remove from active bookings
        reservationRoomTypeMap.remove(reservationId);

        System.out.println("Booking cancelled for ID: " + reservationId);
    }

    /**
     * Display rollback history
     */
    public void showRollbackHistory() {

        System.out.println("\n===== ROLLBACK HISTORY =====");

        if (releasedRoomIds.isEmpty()) {
            System.out.println("No cancellations yet.");
            return;
        }

        for (int i = releasedRoomIds.size() - 1; i >= 0; i--) {
            System.out.println(releasedRoomIds.get(i));
        }
    }
}