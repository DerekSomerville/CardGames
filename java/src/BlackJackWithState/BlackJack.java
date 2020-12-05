package BlackJackWithState;
import CardGame.Card;
import CardGame.Hand;
import Player.Player;

import CardGame.CardGame;

public class BlackJack extends CardGame {
    private int maxScore = 21;

    public void help(){
        getUserOutput().output("Please select one of the following options:");
        getUserOutput().output("Play");
        getUserOutput().output("Twist");
        getUserOutput().output("Stick");
    }

 //   private void callAction(Player.Player player, String request){
 //       getUserOutput().output("Request " +request);
 //       getUserOutput().output("Call Action state " + player.getState().state());
        //Derektry {
  //          if (request == "Play"){
  //              getUserOutput().output("If Play " + player.getState().state());
  //              player.setState(new BlackJackWithState.PlayingCardState());
  //              player.getState().playGame(player);
 //           }
 //           else if (request  == "Twist"){
 //               player.getState().twist(player);
 //           }
 //           else if (request == "Stick"){
 //               player.getState().stick(player);
 //           } else {
  //              getUserOutput().output("Command not found");
//            }
        //}catch (Exception UnsupportedOperationException) {
        //    getUserOutput().output("Command not valid for current state");
        //}
 //   }
    public void play(){
        int noOfCards = 2;
        initiate();
        for ( Player player : getPlayers()){
            String request;
            int counter = 0;
            //do {
                request = player.nextPlay();
                request = player.nextPlay();
                request = player.nextPlay();

            ++counter;
            //} while ( counter < 3 || request.substring(0,1) != "S");
        }
    }

    public int getMaxScore(){
        return maxScore;
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
