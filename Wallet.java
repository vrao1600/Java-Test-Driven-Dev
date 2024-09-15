package ConcertTicket;

import java.util.Arrays;

/**
 * This class represents a Wallet which can store any number of concert tickets.
 *
 * @version Spring 2024
 */
public class Wallet {

    /**
     * Array of ConcertTicket objects
     */
    protected ConcertTicket[] tickets = new ConcertTicket[10];
    private int size = 0;

   
    /**
     * Adds a concert ticket to the array.
     *
     * @param ct a concert ticket being added to the wallet
     */
    public void add(ConcertTicket ct) {
        if (this.size == this.tickets.length) {
            this.resize();
        }

        this.tickets[this.size] = ct;
        this.size++;
    }

    /**
     * Resizes the wallet so that it can fit more tickets.
     */
    public void resize() {
        this.tickets = Arrays.copyOf(this.tickets, 2 * this.tickets.length);
    }

    /**
     * Converts the wallet into a string representation for easy reading.
     *
     * @return a string representation of the wallet
     */
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(this.tickets, size));
    }

    /**
     * Returns the number of tickets in the wallet.
     *
     * @return the number of tickets in the wallet
     */
    public int getSize() {
        // TODO: Implement `getSize()`
        return this.size;
    }

    /**
     * Returns the capacity of the wallet (the length of the ticket array).
     *
     * @return the capacity of the wallet
     */
    public int getLength() {
        // TODO: Implement `getLength()`
        //return length;
        return this.tickets.length;
    }

    /**
     * Removes the most recently added concert ticket from the wallet.
     *
     * @return the concert ticket removed from the wallet, or null if the wallet is
     *         empty
     */
    public ConcertTicket remove() {
        // TODO: Implement `remove()`
        // TODO: Create a ConcertTicket reference variable (DO NOT create a new
        // ConcertTicket – JUST create the reference variable)
        // ConcertTicket lastTicket;

        ConcertTicket lastTicket;

        if (this.size > 0) {
            // TODO: Use the size variable (which always points at the next empty slot) to
            // get the last added ConcertTicket from the array:
            lastTicket = this.tickets[this.size - 1];

            // TODO: Set that array slot to null:
            this.tickets[this.size - 1] = null;

            // TODO: Decrement the size variable:
            this.size--;

            // TODO: Return the ConcertTicket:
            return lastTicket;
        }
        // Return null if the wallet is empty
        return null;
    }
}
