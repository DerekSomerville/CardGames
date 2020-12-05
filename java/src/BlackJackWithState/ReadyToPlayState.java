package BlackJackWithState;
import CardGame.Hand;

public class ReadyToPlayState implements PlayerState{
    public void playGame(BlackJackPlayer player){
        Hand hand = player.getHand();
        player.setHand(player.getGame().dealHand(hand,2));
        player.getGame().getUserOutput().output("Hello");
        player.setState(new PlayingCardState());
    }

    public void twist(BlackJackPlayer player){
        throw new UnsupportedOperationException();
    }
    public void stick(BlackJackPlayer player){
        throw new UnsupportedOperationException();
    }
    public String state(){
        return "Ready to play";
    }
}
