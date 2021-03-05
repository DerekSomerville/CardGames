package GinRummy;

import CardGame.Hand;
import Player.Player;
import Player.PlayerType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GinRummyTest {

    GinRummy ginRummy = new GinRummy();

    @Test
    void playerHasWonRun4Same3() {
        Player player = new Player(PlayerType.USER,"Derek",0);
        Hand hand = new Hand("H2,H3,C7,H4,H5,H7,D7");
        player.setHand(hand);
        assertTrue(ginRummy.playerHasWon(player));
    }

    @Test
    void getCardsOfSameNumber() {
        String[] listOfCards = {"H2","H3","C7","H4","H5","H7","D7"};
        Hand hand = Hand.createHand(listOfCards);
        String[] listOfSameNumber = {"C7","H7","D7"};
        Hand handOfSameNumber = Hand.createHand(listOfSameNumber);
        assertEquals(handOfSameNumber.toString(),ginRummy.getCardsOfSameNumber(hand).get(0).toString());
    }

    @Test
    void hasWinningHandsThreeSameNumber(){
        ArrayList<Hand> winningHands = new ArrayList<Hand>();
        String[] listOfSameNumber = {"C7","H7","D7"};
        Hand handOfSameNumber = Hand.createHand(listOfSameNumber);
        winningHands.add(handOfSameNumber);
        assertEquals(1,ginRummy.hasWinningHands(winningHands).size());
    }

    @Test
    void hasWinningHandsOneRunOfFour(){
        ArrayList<Hand> winningHands = new ArrayList<Hand>();
        String[] listOfRun = {"H2","H3","H4","H5"};
        Hand handOfRun = Hand.createHand(listOfRun);
        winningHands.add(handOfRun);
        assertEquals(1,ginRummy.hasWinningHands(winningHands).size());
    }

    @Test
    void hasNoWinningWithOneHand(){
        ArrayList<Hand> winningHands = new ArrayList<Hand>();
        String[] listOfSameNumber = {"C7","D7"};
        Hand handOfSameNumber = Hand.createHand(listOfSameNumber);
        winningHands.add(handOfSameNumber);
        assertEquals(0,ginRummy.hasWinningHands(winningHands).size());
    }

    @Test
    void getRuns(){
        String[] listOfCards = {"H2","H3","C7","H4","H5","H7","D7"};
        Hand hand = Hand.createHand(listOfCards);
        String[] listOfRun = {"H2","H3","H4","H5"};
        Hand handOfRun = Hand.createHand(listOfRun);
        assertEquals(handOfRun.toString(),ginRummy.getRuns(hand).get(0).toString());
    }

    @Test
    void scoreHandSeven(){
        String[] listOfCards = {"H2","H3","C7","H4","H5","H7","D7"};
        Hand hand = Hand.createHand(listOfCards);
        assertEquals(7,ginRummy.scoreHand(hand));
    }

    @Test
    void playerHasWonRun3Same4() {
        Player player = new Player(PlayerType.USER,"Derek",0);
        String[] listOfCards = {"C2","D5","C3","S5","H5","CA","C5"};
        Hand hand = Hand.createHand(listOfCards);
        player.setHand(hand);
        assertFalse(ginRummy.playerHasWon(player));
    }

    @Test
    void scoreHandZero() {
        String[] listOfCards = {"H2","S3","C7","H4","H9","CA","C5"};
        Hand hand = Hand.createHand(listOfCards);
        assertEquals(0,ginRummy.scoreHand(hand));

    }

    @Test
    void scoreHandSevenCard() {
        String[] listOfCards = {"H2", "H3", "DJ", "H4", "H5", "CJ", "HJ"};
        Hand hand = Hand.createHand(listOfCards);
        assertEquals(7,ginRummy.scoreHand(hand));
    }
}