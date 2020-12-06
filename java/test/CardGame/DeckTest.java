package CardGame;

import CardGame.Deck;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck = Deck.getInstance();

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertNotNull(deck);
    }

    @org.junit.jupiter.api.Test
    void getNumberOfCards() {
        int previousNoOfCards = deck.getNumberOfCards();
        deck.playACard();
        assertTrue(previousNoOfCards -1 == deck.getNumberOfCards());
    }

    @org.junit.jupiter.api.Test
    void playACard() {
        assertEquals(Suit.HEARTS,deck.playACard().getSuit());
    }

    @org.junit.jupiter.api.Test
    void shuffleDeck() {
        deck.shuffleDeck();
        assertNotEquals("HA",deck.playACard().display());
    }
}