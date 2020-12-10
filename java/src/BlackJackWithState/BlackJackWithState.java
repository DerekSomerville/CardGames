package BlackJackWithState;

import Display.ConsoleOutput;
import Player.Player;
import BlackJack.BlackJack;
import BlackJack.BlackJackActions;
import Display.Output;

public class BlackJackWithState extends BlackJack {

    private Output output = new ConsoleOutput();

    private PlayerState callAction(Player player, BlackJackActions action, PlayerState playerState) {
        if (action == BlackJackActions.PLAY){
            playerState = playerState.playGame(this,player);
        } else if (action == BlackJackActions.STICK){
            playerState = playerState.stick(this,player);
        } else if (action == BlackJackActions.TWIST){
            playerState = playerState.twist(this,player);
        } else if (action == BlackJackActions.END){
            playerState = playerState.end(this,player);
        }
        return playerState;
    }

    private void userPlays(Player player){
        PlayerState playerState = new ReadyToPlayState();
        output.output("Black Jack With State");
        BlackJackActions userAction = this.getPlayerAction(player);

        while ( userAction != BlackJackActions.STICK && userAction != BlackJackActions.END){
            output.output("Your state is " + playerState.state());
            playerState = callAction(player,userAction,playerState);
            userAction = this.getPlayerAction(player);
        }
    }

    public void play() {
        this.setNoOfCards(2);
        this.initiatePlayers();
        userPlays(this.getPlayers().get(0));
        for (int counter=1; counter < getPlayers().size();counter++){
            this.computerPlays(getPlayers().get(counter));
        }
        determineWinner();
    }

    public static void main(String[ ] args) {
        BlackJackWithState blackJack = new BlackJackWithState();
        blackJack.play();

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

}
