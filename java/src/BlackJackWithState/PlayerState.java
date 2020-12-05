package BlackJackWithState;

import Player.Player;

public interface PlayerState {
    public void playGame(BlackJackPlayer player);
    public void twist(BlackJackPlayer player);
    public void stick(BlackJackPlayer player);
    public String state();
}
