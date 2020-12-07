package CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void displayHearts() {
        assertEquals("Hearts", Suit.HEARTS.display());

    }

    @Test
    void getSuitHearts() {
        assertEquals(Suit.HEARTS, Suit.getSuit("H"));
    }

}