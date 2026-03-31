import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 * CLASS - BookingHistory
 * ============================================================
 *
 * Use Case 8: Booking History & Reporting
 *
 * @version 8.0
 */
public class BookingHistory {

    /** List storing confirmed reservations */
    private List<Reservation> confirmedReservations;

    /** Initializes empty history */
    public BookingHistory() {
        confirmedReservations = new ArrayList<>();
    }

    /** Adds confirmed reservation */
    public void addReservation(Reservation reservation) {
        confirmedReservations.add(reservation);
    }

    /** Returns all confirmed reservations */
    public List<Reservation> getConfirmedReservations() {
        return confirmedReservations;
    }
}