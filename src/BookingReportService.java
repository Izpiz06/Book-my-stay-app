/**
 * ============================================================
 * CLASS - BookingReportService
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingReportService {

    /**
     * Generates report of bookings
     */
    public void generateReport(BookingHistory history) {

        System.out.println("===== BOOKING REPORT =====");

        if (history.getConfirmedReservations().isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }

        int count = 0;

        for (Reservation r : history.getConfirmedReservations()) {
            count++;
            System.out.println(count + ". Guest: " + r.getGuestName()
                    + " | Room Type: " + r.getRoomType());
        }

        System.out.println("\nTotal Bookings: " + count);
    }
}