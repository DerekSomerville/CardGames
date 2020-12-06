package GinRummy;

import CardGame.CardGame;
import Player.Player;
import CardGame.Hand;
import Player.PlayerType;
import CardGame.Card;
import CardGame.Suit;

import java.util.ArrayList;

public class GinRummy extends CardGame {

    private Hand disGuardedCards = new Hand();
    public int numberOfCards = 7;

    private ArrayList<Hand> getCardsOfSameSuite(Hand hand){
        ArrayList<Hand> cardsGroupBySuits = new ArrayList<Hand>();
        hand.sortHand();
        Suit previousSuit = null;
        Hand cardsOfSameSuit = new Hand();
        for (Card card : hand.getHandOfCards()) {
            if (card.getSuit() == previousSuit ){
                cardsOfSameSuit.add(card);
            } else {
                if (cardsOfSameSuit.size() > 0){
                    cardsGroupBySuits.add(cardsOfSameSuit.copy());
                }
                cardsOfSameSuit.clear();
                cardsOfSameSuit.add(card);
                previousSuit = card.getSuit();
            }
        }
        cardsGroupBySuits.add(cardsOfSameSuit.copy());
        return cardsGroupBySuits;
    }

    private ArrayList<Hand> hasWinningHands(ArrayList<Hand>  hands){
        ArrayList<Hand> winningHands = new ArrayList<Hand>();
        for (Hand hand : hands){
            if (hand.size() >= 3) {
                winningHands.add(hand);
            }
        }
        return winningHands;
    }

    private ArrayList<Hand> getRuns(Hand hand){
        ArrayList<Hand> cardsGroupByRuns = new ArrayList<Hand>();
        Hand cardsInRun = new Hand();
        hand.sortHandByFace();
        int previousRank = 0;
        for (Card card : hand.getHandOfCards()){
            if (previousRank + 1 == card.getRank().getRank()) {
                cardsInRun.add(card);
            } else {
                if (cardsInRun.size() > 0){
                    cardsGroupByRuns.add(cardsInRun.copy());
                }
                previousRank = card.getRank().getRank();
                cardsInRun.clear();
                cardsInRun.add(card);

            }
        }
        cardsGroupByRuns.add(cardsInRun.copy());
        return cardsGroupByRuns;
    }


    private void help(){
        getUserOutput().output("Take from the dis Guarded pile or from the Deck");
        if (disGuardedCards.size() > 0) {
            getUserOutput().output("The dis guarded card " + disGuardedCards.getHandOfCards().get(disGuardedCards.size()-1).shortDisplay());
        }
    }

    private void humanPlaysHand(Player player){
        help();
        String userChoice = getUserInput().getInputString();
        Card card;
        if (userChoice.toUpperCase().equals("D")){
            card = getDeck().playACard();
        } else {
            card = disGuardedCards.playACard();
        }
        player.getHand().add(card);
        player.getHand().sortHand();
        getUserOutput().output(player.getHand().show());
        getUserOutput().output("Please enter zero to seven to select card to dis guard ");
        int userCard = getUserInput().getInputInt();
        disGuardedCards.add(player.getHand().playACard(userCard));
    }

    private void computerPlaysHand(Player player){
        Card card = null;
        boolean playFromDeck = true;
        if (disGuardedCards.size() > 0) {
            card = disGuardedCards.playACard();
            player.getHand().add(card);
            if (!playerHasWon(player)) {
                player.getHand().playACard(card);
            } else {
                playFromDeck = false;
            }

        }

        if (playFromDeck) {
            player.getHand().add(getDeck().playACard());
        }

    }

    public void playerPlaysHand(Player player){
        if (player.getPlayerType() == PlayerType.USER){
            humanPlaysHand(player);
        } else {
            computerPlaysHand(player);
        }

    }

    public boolean playerHasWon(Player player){
        boolean winner = false;
        ArrayList<Hand> listOfRuns = getRuns(player.getHand());
        ArrayList<Hand> listOfSuits = getCardsOfSameSuite(player.getHand());
        int total = 0;
        for (Hand hand : listOfRuns){
            if (hand.size() >= 3) {
                total += hand.size();
            }
        }
        for (Hand hand : listOfSuits){
            if (hand.size() >= 3) {
                total += hand.size();
            }
        }
        getUserOutput().output(total);
        if (total >= numberOfCards){
            winner = true;
            getUserOutput().output("Winner is " + player.getName());
            getUserOutput().output(player.getHand().show());
        }

        return winner;
    }


    public static void main(String[ ] args) {
        GinRummy ginRummy = new GinRummy();
        ginRummy.setNoOfCards(ginRummy.numberOfCards);
        ginRummy.play();

    }
}
