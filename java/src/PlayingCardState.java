public class PlayingCardState implements PlayerState{
    public void twist(Player player){
        CardGame game = player.getGame();
        Card card = game.getDeck().playACard();
        player.getHand().add(card);

    }
    public void stick(Player player){
        player.setState(new StickState());
    }
    public void playGame(Player player){ throw new UnsupportedOperationException(); }
    public String state(){
        return "Playing cards";
    }
}
