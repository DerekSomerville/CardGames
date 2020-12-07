package CardGame;

import Display.TestingInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import CardGame.CardGame;
import CardGame.Hand;

import static org.junit.jupiter.api.Assertions.*;

class CardGameTest {
    CardGame cardGame = new CardGame();

    CardGameTest(){
        TestingInput testingInput = new TestingInput();
        cardGame.setUserInput(testingInput);
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