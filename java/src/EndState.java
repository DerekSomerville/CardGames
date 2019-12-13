public class EndState implements PlayerState{
    public void playGame(Player player){
        player.setState(new ReadyToPlayState());
    }
    public void twist(Player player){
        throw new UnsupportedOperationException();
    }
    public void stick(Player player){
        throw new UnsupportedOperationException();
    }
    public String state(){
        return "End of game";
    }
}
