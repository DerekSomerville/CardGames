package CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardRankTest {

    @Test
    void getValue() {
    }

    @Test
    void getRank() {
    }

    @Test
    void display() {
    }

    @Test
    void getCardRankAce() {
        assertEquals(CardRank.ACE,CardRank.getCardRank("A"));
    }
    @Test
    void getCardRankNine() {
        assertEquals(CardRank.NINE,CardRank.getCardRank("9"));
    }
    @Test
    void getCardRankTwo() {
        assertEquals(CardRank.TWO,CardRank.getCardRank("2"));
    }
}