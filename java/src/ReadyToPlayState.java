public class ReadyToPlayState implements PlayerState{
    public void playGame(Player player){
        player.getGame().dealHand(player,2);
        player.setState(new PlayingCardState());
    }

    public void twist(Player player){
        throw new UnsupportedOperationException();
    }
    public void stick(Player player){
        throw new UnsupportedOperationException();
    }
    public String state(){
        return "Ready to play";
    }
}
