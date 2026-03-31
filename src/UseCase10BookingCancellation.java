/**
 * ============================================================
 * MAIN CLASS - UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    public static void main(String[] args) {

        System.out.println("===== BOOKING CANCELLATION SYSTEM =====");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Simulate confirmed bookings
        cancellationService.registerBooking("S101", "Single");
        cancellationService.registerBooking("D201", "Double");

        // Cancel bookings
        cancellationService.cancelBooking("S101", inventory);
        cancellationService.cancelBooking("D201", inventory);

        // Invalid cancellation
        cancellationService.cancelBooking("X999", inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Final inventory
        System.out.println("\nFinal Inventory: " + inventory.getRoomAvailability());
    }
}