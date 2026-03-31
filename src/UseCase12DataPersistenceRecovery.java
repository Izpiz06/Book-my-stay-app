/**
 * ============================================================
 * MAIN CLASS - UseCase12DataPersistenceRecovery
 * ============================================================
 *
 * Use Case 12: Data Persistence & System Recovery
 *
 * @version 12.0
 */
public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("===== DATA PERSISTENCE SYSTEM =====");

        String filePath = "inventory.txt";

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistence = new FilePersistenceService();

        // Load existing data
        persistence.loadInventory(inventory, filePath);

        System.out.println("Current Inventory: " + inventory.getRoomAvailability());

        // Simulate booking (reduce inventory)
        inventory.updateAvailability("Single",
                inventory.getRoomAvailability().get("Single") - 1);

        System.out.println("After booking: " + inventory.getRoomAvailability());

        // Save updated state
        persistence.saveInventory(inventory, filePath);
    }
}