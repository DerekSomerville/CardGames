package GinRummy;

import CardGame.Hand;
import Player.Player;
import Player.PlayerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GinRummyTest {

    GinRummy ginRummy = new GinRummy();

    @Test
    void playerHasWonRun4Suit3() {
        Player player = new Player(PlayerType.USER,"Derek",0);
        String[] listOfCards = {"H2","S3","C7","S4","H5","C10","C9"};
        Hand hand = Hand.createHand(listOfCards);
        player.setHand(hand);
        assertTrue(ginRummy.playerHasWon(player));
    }

    @Test
    void playerHasWonRun3Suit3() {
        Player player = new Player(PlayerType.USER,"Derek",0);
        String[] listOfCards = {"H2","S3","C3","H4","H5","CA","C5"};
        Hand hand = Hand.createHand(listOfCards);
        player.setHand(hand);
        assertFalse(ginRummy.playerHasWon(player));
    }

    @Test
    void scoreHandSixCard() {
        String[] listOfCards = {"H2","S3","C3","H4","H9","CA","C5"};
        Hand hand = Hand.createHand(listOfCards);
        assertEquals(6,ginRummy.scoreHand(hand));

    }

    @Test
    void scoreHandSevenCard() {
        String[] listOfCards = {"H2", "S3", "C7", "S4", "H5", "C10", "C9"};
        Hand hand = Hand.createHand(listOfCards);
        assertEquals(7,ginRummy.scoreHand(hand));
    }
}