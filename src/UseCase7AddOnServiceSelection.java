/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * @version 7.0
 */
public class UseCase7AddOnServiceSelection {

    public static void main(String[] args) {

        System.out.println("===== ADD-ON SERVICE SYSTEM =====");

        // Assume reservation ID from UC6
        String reservationId = "S101";

        // Create services
        AddOnService breakfast = new AddOnService("Breakfast", 500);
        AddOnService spa = new AddOnService("Spa", 1500);
        AddOnService pickup = new AddOnService("Airport Pickup", 800);

        // Manager
        AddOnServiceManager manager = new AddOnServiceManager();

        // Add services
        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, pickup);

        // Calculate total
        double total = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: ₹" + total);
    }
}