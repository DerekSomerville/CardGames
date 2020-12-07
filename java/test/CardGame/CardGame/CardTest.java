package CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void getSuit() {
    }

    @Test
    void getRank() {
    }

    @Test
    void display() {
    }

    @Test
    void displayOf() {
    }

    @Test
    void shortDisplay() {
    }

    @Test
    void createCardSameSuit() {
        Card card = new Card(Suit.HEARTS,CardRank.ACE);
        assertEquals(card.getSuit(),Card.createCard("HA").getSuit());
    }

    @Test
    void createCardSameRank() {
        Card card = new Card(Suit.HEARTS,CardRank.ACE);
        assertEquals(card.getRank(),Card.createCard("HA").getRank());
    }
    @Test
    void createCardSameDisplay() {
        Card card = new Card(Suit.HEARTS,CardRank.ACE);
        assertEquals(card.display(),Card.createCard("HA").display());
    }
}