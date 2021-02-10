package BlackJackWithState;

import CardGame.CardGame;
import CardGame.Card;
import Player.Player;

public class PlayingCardState implements PlayerState{
    public PlayerState playGame(BlackJackWithState game, Player player){
        game.output.output("Not a valid choice");
        return this;
    }

    public PlayerState twist(BlackJackWithState game, Player player){
        PlayerState playerState = this;
        player.getHand().add(game.getDeck().playACard());
        if (game.getScore(player.getHand()) > game.getMaxScore()){
            game.output.output("You are bust");
            playerState = new EndState();
        }
        return playerState;
    }
    public PlayerState stick(BlackJackWithState game, Player player){
        return new EndState();
    }
    public PlayerState end(BlackJackWithState game, Player player){
        game.output.output("Not a valid choice");
        return new EndState();
    }

    public String state() {return "Playing game";}

}
