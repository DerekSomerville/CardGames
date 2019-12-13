import java.util.Random;

public class ComputerPlayer extends Player {
    private int levelOfRisk;

    ComputerPlayer(PlayerType playerType, String name, int levelOfRisk){
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

    public String nextPlay(){
        String request;
        if (getHand().isEmpty()){
            request = "Play";
        }
        else if (getGame().getScore(getHand()) < levelOfRisk){
            request = "Twist";
        } else {
            request = "Stick";
        }
        callAction(request);
        return request;
    }

}
