/**
 * ============================================================
 * MAIN CLASS - UseCase3InventorySetup
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * @version 3.1
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {

        // Create room objects (reuse UC2)
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        System.out.println("===== CENTRALIZED ROOM INVENTORY =====");

        // Display room details with availability
        System.out.println("\nSingle Room:");
        single.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Single"));

        System.out.println("\nDouble Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Double"));

        System.out.println("\nSuite Room:");
        suite.displayRoomDetails();
        System.out.println("Available: " + inventory.getRoomAvailability().get("Suite"));

        // Example update
        System.out.println("\nUpdating inventory...");
        inventory.updateAvailability("Single", 4);

        System.out.println("Updated Single Room Availability: "
                + inventory.getRoomAvailability().get("Single"));
    }
}