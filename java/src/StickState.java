public class StickState implements PlayerState{
    public void determineWinner(Player player){
        player.setState(new EndState());
    }

    public void playGame(Player player){ throw new UnsupportedOperationException(); }
    public void twist(Player player){
        throw new UnsupportedOperationException();
    }
    public void stick(Player player){
        throw new UnsupportedOperationException();
    }
    public String state(){
        return "Stick";
    }
}
