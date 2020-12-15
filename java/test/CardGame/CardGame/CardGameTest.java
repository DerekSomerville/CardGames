package CardGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {
    CardGame cardGame = new CardGame();

    CardGameTest(){
    }

    @Test
    void getPlayers() {

    }

    @Test
    void setGame() {
    }

    @Test
    void initiatePlayers() {
    }

    @Test
    void dealCardsHandCount() {
        Hand hand = new Hand();
        int noOfCards = 2;
        hand = cardGame.dealHand(hand,noOfCards);
        assertEquals(noOfCards,hand.size());
    }

    @Test
    void dealCardsDeckCount() {
        Hand hand = new Hand();
        int noOfCards = 2;
        int previousNoOfCards = cardGame.getDeck().getNumberOfCards();
        hand = cardGame.dealHand(hand,noOfCards);
        assertTrue(previousNoOfCards - noOfCards==cardGame.getDeck().getNumberOfCards());
    }

    @Test
    void dealHand() {
    }
}