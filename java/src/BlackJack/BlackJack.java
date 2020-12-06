package BlackJack;
import CardGame.Hand;
import CardGame.Card;
import Player.Player;
import CardGame.CardGame;

public class BlackJack extends CardGame {
    private int maxScore = 21;

    public void help(){
        getUserOutput().output("Please select one of the following options:");
        getUserOutput().output("Twist");
        getUserOutput().output("Stick");
    }

    private void userPlays(Player player){
        String userChoice = " ";

        while (getScore(player.getHand()) <= maxScore && !userChoice.substring(0,1).toUpperCase().equals("S")){
            help();
            getUserOutput().outputHand(player.getHand());
            getUserOutput().output(player.getName() + " your score is " + getScore(player.getHand()));
            userChoice = getUserInput().getInputString();
            getUserOutput().output("You chose" + userChoice.substring(0,1).toUpperCase());
            if (userChoice.substring(0,1).toUpperCase().equals("T")){
                getUserOutput().output("You twisted");
                player.getHand().add(getDeck().playACard());
            }

        }
        if (getScore(player.getHand()) > maxScore){
            getUserOutput().output(player.getName() + " you are bust");
        }
    }

    private void computerPlays(Player player){
        while (getScore(player.getHand()) <= player.levelOfRisk){
            player.getHand().add(getDeck().playACard());
        }
    }

    public void play() {
        this.initiate();
        userPlays(this.getPlayers().get(0));
        for (int counter=1; counter < getPlayers().size();counter++){
            computerPlays(getPlayers().get(counter));
        }
        determineWinner();
    }

    private void determineWinner(){
        Integer winningScore = 0;
        String winningName = "";
        for (Player player : getPlayers()){
            if (getScore(player.getHand()) <= maxScore && getScore(player.getHand()) > winningScore){
                winningName = player.getName();
                winningScore = getScore(player.getHand());
            }
        }
        getUserOutput().output("The winner is " + winningName);

    }


    public int getScore(Hand hand){
        int score = 0;
        for (Card card: hand.getHandOfCards()){
            score += card.getRank().getValue();
        }
        return score;
    }

    public static void main(String[ ] args) {
        BlackJack blackJack = new BlackJack();
        blackJack.play();

    }


}
