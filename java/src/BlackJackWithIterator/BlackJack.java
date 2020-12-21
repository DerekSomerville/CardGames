package BlackJackWithIterator;

import BlackJack.BlackJackActions;
import BlackJackWithIterator.Hand;
import CardGame.Card;
import Player.Player;
import CardGame.CardGame;

import java.util.HashMap;
import java.util.Map;

public class BlackJack extends CardGame {
    private int maxScore = 21;
    public int noOfCards = 2;

    public int getMaxScore(){
        return maxScore;
    }

    public void help(){
        getUserOutput().output("Please select one of the following options:");
        for (BlackJackActions action : BlackJackActions.values()) {
            getUserOutput().output(action.display());
        }
    }

    public BlackJackActions getPlayerAction(Player player){
        String userChoice = " ";
        BlackJackActions userAction;
        help();
        if (player.hasHand()) {
            getUserOutput().outputHand(player.getHand());
        }
        userChoice = getUserInput().getInputString();
        userAction = BlackJackActions.getAction(userChoice.substring(0,1).toUpperCase());
        getUserOutput().output("You chose " + userAction.display());
        return userAction;
    }

    private void userPlays(Player player){
        BlackJackActions userAction = BlackJackActions.PLAY;

        while (getScore(player.getHand()) <= maxScore && userAction != BlackJackActions.STICK){
            userAction = getPlayerAction(player);
            if (userAction == BlackJackActions.TWIST){
                getUserOutput().output("You twisted");
                player.getHand().add(getDeck().playACard());
            }

        }
        if (getScore(player.getHand()) > maxScore){
            getUserOutput().output(player.getName() + " you are bust");
        }
    }

    public void computerPlays(Player player){
        while (getScore(player.getHand()) <= player.levelOfRisk){
            player.getHand().add(getDeck().playACard());
        }
    }

    public void play() {
        this.setNoOfCards(2);
        this.initiate();
        userPlays(this.getPlayers().get(0));
        for (int counter=1; counter < getPlayers().size();counter++){
            computerPlays(getPlayers().get(counter));
        }
        determineWinner();
    }

    public void determineWinner(){
        Integer winningScore = 0;
        String winningName = "";
        //Hand winningHand = new Hand(noOfCards);
        for (Player player : getPlayers()){
            if (getScore(player.getHand()) <= maxScore && getScore(player.getHand()) > winningScore){
                winningName = player.getName();
                winningScore = getScore(player.getHand());
                //winningHand = player.getHand();
            }
        }
        getUserOutput().output("The winner is " + winningName);
        //getUserOutput().outputHand(winningHand.getHandAsList());

    }


    public int getScore(Hand hand){
        int score = 0;
        while ( hand.hasNext()){
            score += hand.next().getRank().getValue();
        }
        return score;
    }

    public static void main(String[ ] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.play();
    }


}
