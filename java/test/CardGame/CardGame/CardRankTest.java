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

    @Test
    void getCardRankValueKing() {
        assertEquals(10,CardRank.KING.getValue());
    }
    @Test
    void getCardRankValueAce() {
        assertEquals(11,CardRank.ACE.getValue());
    }

    @Test
    void getShortDisplayAce(){ assertEquals("A",CardRank.ACE.shortDisplay());}

    @Test
    void getShortDisplayNine(){ assertEquals("9",CardRank.NINE.shortDisplay());}

}