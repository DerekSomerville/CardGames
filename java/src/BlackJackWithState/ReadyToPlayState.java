package BlackJackWithState;
import CardGame.Hand;
import Player.Player;

public class ReadyToPlayState implements PlayerState{
    public PlayerState playGame(BlackJackWithState game, Player player){
        game.dealCards();
        return new PlayingCardState();
    }

    public PlayerState twist(BlackJackWithState game, Player player){
        game.getUserOutput().output("Not a valid choice");
        return this;
    }
    public PlayerState stick(BlackJackWithState game, Player player){
        game.getUserOutput().output("Not a valid choice");
        return this;
    }
    public PlayerState end(BlackJackWithState game, Player player){
        player.getHand().clear();
        return new ReadyToPlayState();
    }

    public String state(){
        return "Ready to play";
    }
}
