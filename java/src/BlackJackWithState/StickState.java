package BlackJackWithState;

import Player.Player;

public class StickState implements PlayerState{
    public void determineWinner(BlackJackPlayer player){
        player.setState(new EndState());
    }

    public void playGame(BlackJackPlayer player){ throw new UnsupportedOperationException(); }
    public void twist(BlackJackPlayer player){
        throw new UnsupportedOperationException();
    }
    public void stick(BlackJackPlayer player){
    }
    public String state(){
        return "Stick";
    }
}
