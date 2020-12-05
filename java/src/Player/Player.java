package Player;

import CardGame.Hand;
import CardGame.CardGame;

public class Player {

    private Hand hand;
    private PlayerType playerType;
    private String name;
    private CardGame game;


    public Player(PlayerType playerType, String name){
        this.playerType = playerType;
        this.name = name;
    }

    public void setGame(CardGame game) {
        this.game = game;
    }

    public CardGame getGame(){
        return this.game;
    }

    public PlayerType getPlayerType(){
        return playerType;
    }

    public void setHand(Hand hand){
        this.hand = hand;
    }

    public void setPlayerType(PlayerType playerType){
        this.playerType = playerType;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() { return this.name;}

    public Hand getHand(){
        return this.hand;
    }

    public String nextPlay(){
        return "";
    }

}
