package BlackJackWithState;

import Display.ConsoleOutput;
import Player.Player;
import BlackJack.BlackJack;
import BlackJack.BlackJackActions;
import Display.Output;
import CardGame.CardGame;

public class BlackJackWithState extends BlackJack {

    protected Output output = new ConsoleOutput();

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
        userPlays(this.players.get(0));
        for (int counter=1; counter < players.size();counter++){
            this.computerPlays(players.get(counter));
        }
        determineWinner();
    }

    public static void main(String[ ] args) {
        BlackJackWithState blackJack = new BlackJackWithState();
        blackJack.play();

    }


}
