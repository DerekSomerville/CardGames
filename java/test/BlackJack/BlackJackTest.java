package BlackJack;

import CardGame.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlackJackTest {

    BlackJack blackJack = new BlackJack();

    @Test
    void getMaxScore() {
    }

    @Test
    void getPlayerAction() {
    }

    @Test
    void computerPlays() {
    }

    @Test
    void play() {
    }

    @Test
    void determineWinner() {
    }

    @Test
    void getScore2And3() {
        String[] listOfCards = {"H2","H3"};
        Hand testHand = Hand.createHand(listOfCards);
        assertEquals(5,blackJack.getScore(testHand));
    }

    @Test
    void getScoreKandQ() {
        String[] listOfCards = {"HK","HQ"};
        Hand testHand = Hand.createHand(listOfCards);
        assertEquals(20,blackJack.getScore(testHand));
    }

    @Test
    void getScoreAceAndQueen() {
        String[] listOfCards = {"HA","HQ"};
        Hand testHand = Hand.createHand(listOfCards);
        assertEquals(21,blackJack.getScore(testHand));
    }
}