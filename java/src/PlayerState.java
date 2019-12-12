public interface PlayerState {
    public PlayerState startGame();
    public PlayerState dealtHand();
    public PlayerState twist();
    public PlayerState stick();
    public PlayerState determineWinner();
    public PlayerState Win();
    public PlayerState lose();

}
