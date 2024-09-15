package ConcertTicket;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class WalletTest {
    /**
     * Test of add method, of class Wallet.
     */
    @Test
    void testAdd() {
        ConcertTicket ct1 = new ConcertTicket("Peter", "08/17/2019", 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", "08/17/2019", 28.5);

        // Check the comparison method of the ConcertTicket class
        assertEquals(ct1.compareTo(ct2), -1, "ct1 should be less expensive than ct2");
        assertEquals(ct2.compareTo(ct1), 1, "ct2 should be more expensive than ct1");

        Wallet instance = new Wallet();

        // Check adding a ticket when the Wallet is empty
        assertEquals(0, instance.getSize(), "Wallet size should be 0 initially");
        instance.add(ct1);
        assertEquals(1, instance.getSize(), "Wallet size should be 1 after adding one ticket");

        // Check adding a ticket when the Wallet is not empty
        instance.add(ct2);
        assertEquals(2, instance.getSize(), "Wallet size should be 2 after adding two tickets");
        assertEquals(instance.tickets[1].compareTo(ct2), 0, "Second ticket should be ct2");

        // Check adding tickets until the wallet needs to resize
        for (int i = instance.getSize(); i < instance.getLength(); i++) {
            instance.add(new ConcertTicket("Test", "08/17/2019", 38.5));
        }
        instance.add(new ConcertTicket("Test", "08/17/2019", 38.5));
        assertEquals(20, instance.getLength(), "Wallet length should be 20 after resizing");
    }

    /**
     * Test of remove method, of class Wallet.
     */
    @Test
    void testRemove() {
        ConcertTicket ct1 = new ConcertTicket("Peter", "08/17/2019", 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", "08/17/2019", 28.5);

        Wallet instance = new Wallet();

        // Check removing a concert ticket from an empty wallet
        ConcertTicket ctIsNull = instance.remove();
        assertSame(ctIsNull, null, "Removing from an empty wallet should return null");

        // Add concert tickets
        instance.add(ct1);
        instance.add(ct2);

        // Check removing concert tickets from a non-empty wallet
        ConcertTicket ct2Removed = instance.remove();
        assertEquals(ct2, ct2Removed, "The last added ticket should be removed first");
        ConcertTicket ct1Removed = instance.remove();
        assertEquals(ct1, ct1Removed, "The first added ticket should be removed last");
        assertEquals(0, instance.getSize(), "Wallet size should be 0 after removing all tickets");
    }

    /**
     * Test of resize method, of class Wallet.
     */
    @Test
    void testResize() {
        // Check default constructor
        ConcertTicket ct = new ConcertTicket();
        assertEquals(0, ct.getPrice(), "Default price should be 0");

        ConcertTicket ct1 = new ConcertTicket("Peter", "08/17/2019", 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", "08/17/2019", 28.5);

        // Add concert tickets
        Wallet instance = new Wallet();
        int originalLength = instance.getLength();
        instance.add(ct1);
        instance.add(ct2);

        // Check the resize function
        instance.resize();
        assertEquals(originalLength * 2, instance.getLength(), "Wallet length should double after resizing");
    }

    /**
     * Test of toString method, of class Wallet.
     */
    @Test
    void testToString() {
        // Construct a non-empty wallet
        ConcertTicket ct1 = new ConcertTicket("Peter", "08/17/2019", 18.5);
        ConcertTicket ct2 = new ConcertTicket("Brandon", "08/17/2019", 28.5);
        Wallet instance = new Wallet();
        instance.add(ct1);
        instance.add(ct2);

        // Check the toString function
        assertNotEquals(0, instance.toString().length(), "toString result should not be empty for a non-empty wallet");
    }

    /**
     * Test of getSize method, of class Wallet.
     */
    @Test
    public void testGetSize() {
        Wallet instance = new Wallet();
        int expectedSize = 0;
        assertEquals(expectedSize, instance.getSize(), "Initial wallet size should be 0");

        instance.add(new ConcertTicket("Titanic", "08/17/2019", 18.5));
        expectedSize++;
        assertEquals(expectedSize, instance.getSize(), "Wallet size should be 1 after adding one ticket");
    }

    /**
     * Test of getLength method, of class Wallet.
     */
    @Test
    public void testGetLength() {
        Wallet instance = new Wallet();
        int expectedLength = 10;
        assertEquals(expectedLength, instance.getLength(), "Initial wallet length should be 10");

        instance.add(new ConcertTicket("Titanic", "08/17/2019", 18.5));
        assertEquals(expectedLength, instance.getLength(), "Wallet length should still be 10 after adding one ticket");
    }
}
