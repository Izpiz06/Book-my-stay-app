/**
 * ============================================================
 * CLASS - ReservationValidator
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * @version 9.0
 */
public class ReservationValidator {

    /**
     * Validates booking input
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // Guest name validation
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // Room type validation
        if (roomType == null || roomType.trim().isEmpty()) {
            throw new InvalidBookingException("Room type cannot be empty");
        }

        // Inventory validation
        if (!inventory.getRoomAvailability().containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type selected");
        }

        // Availability check
        if (inventory.getRoomAvailability().get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for selected type");
        }
    }
}