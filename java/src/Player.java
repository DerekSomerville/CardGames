import java.util.ArrayList;

public class Player {
    private PlayerState state;
    private Hand hand;
    private PlayerType playerType;
    private String name;

    Player(PlayerType playerType, String name){
        this.hand = new Hand();
        this.playerType = playerType;
        this.name = name;
    }

    public Hand getHand(){
        return this.hand;
    }
}
