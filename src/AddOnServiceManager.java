import java.util.*;

/**
 * ============================================================
 * CLASS - AddOnServiceManager
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * @version 7.0
 */
public class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /**
     * Initializes the service manager
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Adds a service to a reservation
     */
    public void addService(String reservationId, AddOnService service) {

        servicesByReservation
                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                .add(service);
    }

    /**
     * Calculates total service cost
     */
    public double calculateTotalServiceCost(String reservationId) {

        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null) return 0.0;

        double total = 0;

        for (AddOnService s : services) {
            total += s.getCost();
        }

        return total;
    }
}