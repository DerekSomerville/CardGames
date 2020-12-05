package BlackJackWithState;

import CardGame.Hand;
import Player.PlayerType;

public class BlackJackPlayer {

    public BlackJack getGame(){ return game;}
    private PlayerType playerType;
    private String name;
    private BlackJack game;
    private Hand hand;
    private PlayerState state;

    BlackJackPlayer(PlayerType playerType, String name){

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


    protected void callAction(String request){
        game.getUserOutput().output("Name " +name);
        game.getUserOutput().output("Request " +request + " end");
        game.getUserOutput().output("Pre Call Action state " + state.state());
        try {
            if (request == "Play"){
                game.getUserOutput().output("In Play " + state.state());
                //state = (new BlackJackWithState.PlayingCardState());
                state.playGame(this);
            }
            else if (request  == "Twist"){
                game.getUserOutput().output("In Twist " + state.state());
                state.twist(this);
            }
            else if (request == "Stick"){
                game.getUserOutput().output("In Stick " + state.state());
                state.stick(this);
            } else {
                game.getUserOutput().output("Command not found");
            }
            game.getUserOutput().output("Post Call Action state " + state.state());
        }catch (Exception UnsupportedOperationException) {
            game.getUserOutput().output("Command not valid for current state");
        }
    }

    public String nextPlay(){
        game.getUserOutput().output("Current state - " + getState().state());
        game.help();
        game.getUserOutput().output(hand.show());
        String request = game.getUserInput().getInputString();
        callAction(request);
        return request;
    }


}
