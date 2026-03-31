/**
 * ============================================================
 * MAIN CLASS - UseCase8BookingHistoryReport
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class UseCase8BookingHistoryReport {

    public static void main(String[] args) {

        System.out.println("===== BOOKING HISTORY SYSTEM =====");

        // Inventory
        RoomInventory inventory = new RoomInventory();

        // Queue
        BookingRequestQueue queue = new BookingRequestQueue();

        // Add requests
        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Double"));
        queue.addRequest(new Reservation("Ram", "Single"));

        // Allocation
        RoomAllocationService allocator = new RoomAllocationService();

        // History
        BookingHistory history = new BookingHistory();

        // Process queue
        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();

            // Try allocation
            allocator.allocateRoom(r, inventory);

            // Add to history (assume success for now)
            history.addReservation(r);
        }

        // Generate report
        BookingReportService reportService = new BookingReportService();
        reportService.generateReport(history);
    }
}