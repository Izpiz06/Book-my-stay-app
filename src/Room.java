/**
 * ============================================================
 * ABSTRACT CLASS - Room
 * ============================================================
 *
 * Represents a generic room in the hotel.
 *
 * @version 2.0
 */
public abstract class Room {

    protected int type;
    protected int size;
    protected double price;

    /**
     * Constructor to initialize room attributes
     */
    public Room(int type, int size, double price) {
        this.type = type;
        this.size = size;
        this.price = price;
    }

    /**
     * Displays room details
     */
    public void displayRoomDetails() {
        System.out.println("Room Type: " + type);
        System.out.println("Room Size: " + size + " sq ft");
        System.out.println("Price: ₹" + price);
    }
}