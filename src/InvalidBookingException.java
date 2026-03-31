/**
 * ============================================================
 * CLASS - InvalidBookingException
 * ============================================================
 *
 * Use Case 9: Error Handling & Validation
 *
 * @version 9.0
 */
public class InvalidBookingException extends Exception {

    /**
     * Creates an exception with a message
     */
    public InvalidBookingException(String message) {
        super(message);
    }
}