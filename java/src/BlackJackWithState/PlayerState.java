package BlackJackWithState;

import Player.Player;

public interface PlayerState {
    public PlayerState playGame(BlackJackWithState game, Player player);
    public PlayerState twist(BlackJackWithState game, Player player);
    public PlayerState stick(BlackJackWithState game, Player player);
    public PlayerState end(BlackJackWithState game, Player player);
    public String state();
}
