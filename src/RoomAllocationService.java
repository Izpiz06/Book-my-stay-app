import java.util.*;

/**
 * ============================================================
 * CLASS - RoomAllocationService
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * @version 6.0
 */
public class RoomAllocationService {

    /** Stores all allocated room IDs to prevent duplicates */
    private Set<String> allocatedRoomIds;

    /**
     * Stores assigned room IDs by room type.
     * Key   -> Room type
     * Value -> Set of assigned room IDs
     */
    private Map<String, Set<String>> assignedRoomsByType;

    /** Initializes allocation tracking structures */
    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    /**
     * Allocates a room if available
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();
        Map<String, Integer> availability = inventory.getRoomAvailability();

        // Check availability
        if (!availability.containsKey(roomType) || availability.get(roomType) <= 0) {
            System.out.println("Booking failed for " + reservation.getGuestName()
                    + " (No " + roomType + " rooms available)");
            return;
        }

        // Generate unique room ID
        String roomId = generateRoomId(roomType);

        // Store globally
        allocatedRoomIds.add(roomId);

        // Store by type
        assignedRoomsByType
                .computeIfAbsent(roomType, k -> new HashSet<>())
                .add(roomId);

        // Update inventory
        inventory.updateAvailability(roomType, availability.get(roomType) - 1);

        // Confirmation
        System.out.println("Booking Confirmed!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room Type: " + roomType);
        System.out.println("Room ID: " + roomId);
        System.out.println("---------------------------");
    }

    /**
     * Generates unique room ID
     */
    private String generateRoomId(String roomType) {

        String prefix = roomType.substring(0, 1).toUpperCase();

        String roomId;
        do {
            roomId = prefix + (int) (Math.random() * 1000);
        } while (allocatedRoomIds.contains(roomId));

        return roomId;
    }
}