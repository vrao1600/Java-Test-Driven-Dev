package ConcertTicket;

/**
 * This is the class ConcertTicket that stores the name of a concert, the price,
 * and the date.
 * 
 * @version Spring 2024
 */
public class ConcertTicket implements Comparable<ConcertTicket> {

    private String name;
    /** The date of the concert. */
    private String date;
    private double price;

    /**
     * Constructor with specified values for all the fields.
     *
     * @param name  the name of the band
     * @param date  the date of the concert
     * @param price the price of the ticket
     */
    public ConcertTicket(String name, String date, double price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    /**
     * Default constructor for this class.
     */
    public ConcertTicket() {
        this.name = "";
        this.date = "";
        this.price = 0.0;
    }

    /**
     * Returns the name of the band performing the concert.
     * 
     * @return the name of the band
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the band.
     *
     * @param name the name to be set for the band
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the date of the concert.
     *
     * @return the date of the concert
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date of the concert.
     *
     * @param date the date of the concert
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Returns the price of the ticket to the concert.
     *
     * @return the price of the ticket
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the ticket for the concert.
     *
     * @param price the price of the ticket
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Compares two concert ticket objects by price.
     * 
     * @param o the other ConcertTicket object to be compared
     * @return -1 if this ticket is cheaper, 1 if more expensive, 0 if equal
     */
    @Override
    public int compareTo(ConcertTicket o) {
        return Double.compare(this.price, o.price);
    }

    /**
     * Returns a string representation of this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        return "ConcertTicket{" + "name='" + name + '\'' + ", date='" + date + '\'' + ", price=" + price + '}';
    }
}
