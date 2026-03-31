/**
 * ============================================================
 * MAIN CLASS - UseCase4RoomSearch
 * ============================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * @version 4.0
 */
public class UseCase4RoomSearch {

    public static void main(String[] args) {

        // Room objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Search service
        RoomSearchService searchService = new RoomSearchService();

        // Perform search (READ-ONLY)
        searchService.searchAvailableRooms(
                inventory,
                single,
                doubleRoom,
                suite
        );
    }
}