package BlackJackWithState;

public class EndState implements PlayerState{
    public void playGame(BlackJackPlayer player){
        player.setState(new ReadyToPlayState());
    }
    public void twist(BlackJackPlayer player){
        throw new UnsupportedOperationException();
    }
    public void stick(BlackJackPlayer player){
        throw new UnsupportedOperationException();
    }
    public String state(){
        return "End of game";
    }
}
