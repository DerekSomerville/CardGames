package BlackJackWithState;

import CardGame.CardGame;
import CardGame.Card;

public class PlayingCardState implements PlayerState{
    public void twist(BlackJackPlayer player){
        CardGame game = player.getGame();
        Card card = game.getDeck().playACard();
        player.getHand().add(card);

    }
    public void stick(BlackJackPlayer player){
        player.setState(new StickState());
    }
    public void playGame(BlackJackPlayer player){ throw new UnsupportedOperationException(); }
    public String state(){
        return "Playing cards";
    }
}
