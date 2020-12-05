package Player;

import Player.Player;
import Player.PlayerType;

import java.util.Random;

public class ComputerPlayer extends Player {
    public int levelOfRisk;

    public ComputerPlayer(PlayerType playerType, String name, int levelOfRisk){
        super(playerType,name);
        int risk;
        Random rand = new Random();
        if (levelOfRisk == 0){
            risk = 11 + rand.nextInt() % 8;
        } else {
            risk = levelOfRisk;
        }
        this.levelOfRisk = risk;
    }

    public void setLevelOfRisk(int risk){
        this.levelOfRisk = risk;
    }


}
