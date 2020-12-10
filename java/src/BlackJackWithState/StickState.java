package BlackJackWithState;

import CardGame.Hand;
import Player.Player;

public class StickState implements PlayerState{
    public PlayerState playGame(BlackJackWithState game, Player player){
        Hand hand = player.getHand();
        hand.clear();
        hand = game.dealHand(hand,game.noOfCards);
        game.getUserOutput().output("Hello");
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
        return "Stick";
    }
}
