package CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {

    Hand hand = new Hand();

    @Test
    void playACard() {
    }

    @Test
    void testPlayACard() {
    }

    @Test
    void testPlayACard1() {
    }

    @Test
    void add() {
    }

    @Test
    void set() {
    }

    @Test
    void copy() {
    }

    @Test
    void isEmpty() {
    }

    @Test
    void clear() {
    }

    @Test
    void size() {
    }

    @Test
    void show() {
        String[] listOfCards = {"H2","H3","C3","H4","H5","CA","C5"};
        Hand testHand = Hand.createHand(listOfCards);
        assertEquals("H2, H3, C3, H4, H5, CA, C5",testHand.toString());
    }

    @Test
    void sortHand() {
    }

    @Test
    void sortHandByFace() {
        String[] listOfCards = {"H2","H3","C3","H4","H5","CA","C5"};
        Hand testHand = Hand.createHand(listOfCards);
        testHand.sortHandByFace();
        assertEquals("H2, H3, C3, H4, H5, C5, CA",testHand.toString());
    }

    @Test
    void createHand() {
        String[] listOfCards = {"H2","H3","C3","H4","H5","CA","C5"};
        Hand testHand = Hand.createHand(listOfCards);
        assertEquals(7,testHand.size());
    }
}