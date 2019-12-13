import java.util.ArrayList;

public class Player {
    private PlayerState state;
    private Hand hand;
    private PlayerType playerType;
    private String name;
    private BlackJack game;

    Player(PlayerType playerType, String name){
        this.hand = new Hand();
        this.playerType = playerType;
        this.name = name;
        this.game = new BlackJack();
        this.state = new ReadyToPlayState();
    }

    public PlayerType getPlayerType(){
        return playerType;
    }

    public void setState(PlayerState state){
        this.state = state;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType = playerType;
    }

    public void setGame(BlackJack game){
        this.game = game;
    }

    public void setName(String name){
        this.name = name;
    }

    public Hand getHand(){
        return this.hand;
    }

    public PlayerState getState(){
        return this.state;
    }

    public BlackJack getGame(){ return game;}

    public String nextPlay(){
        game.getUserOutput().output("Current state - " + getState().state());
        game.help();
        game.getUserOutput().output(hand.show());
        String request = game.getUserInput().getInputString();
        return request;
    }


}
