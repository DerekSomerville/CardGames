import java.util.ArrayList;

public class Player {
    private PlayerState state;
    private Hand hand;
    private PlayerType playerType;
    private String name;
    private CardGame game;

    Player(PlayerType playerType, String name){
        this.hand = new Hand();
        this.playerType = playerType;
        this.name = name;
        this.game = game;
    }

    public PlayerType getPlayerType(){
        return playerType;
    }
    public Hand getHand(){
        return this.hand;
    }

    public PlayerState getState(){
        return state;
    }

}
