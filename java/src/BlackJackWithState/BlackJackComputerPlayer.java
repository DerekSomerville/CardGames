package BlackJackWithState;

import Player.PlayerType;
import Player.Player;

public class BlackJackComputerPlayer extends Player {

    public BlackJackComputerPlayer(PlayerType playerType, String name, int levelOfRisk){
        super(playerType,name,levelOfRisk);
    }

    public String nextPlay(){
        String request;
        if (getHand().isEmpty()){
            request = "Play";
        }
        else if (getGame().getScore(getHand()) < this.levelOfRisk){
            request = "Twist";
        } else {
            request = "Stick";
        }
        //callAction(request);
        return request;
    }

}
