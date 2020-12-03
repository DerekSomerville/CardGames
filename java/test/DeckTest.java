import static org.junit.jupiter.api.Assertions.*;

class DeckTest {
    private Deck deck = Deck.getInstance();

    @org.junit.jupiter.api.Test
    void getInstance() {
        assertNotNull(deck);
    }

    @org.junit.jupiter.api.Test
    void getNumberOfCards() {
        assertEquals(52, deck.getNumberOfCards());
    }

    @org.junit.jupiter.api.Test
    void playACard() {
        assertEquals("HeartsTwo",deck.playACard().display());
    }

    @org.junit.jupiter.api.Test
    void shuffleDeck() {
        deck.shuffleDeck();
        assertNotEquals("H2",deck.playACard().display());
    }
}