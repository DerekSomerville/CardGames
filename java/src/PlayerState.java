public interface PlayerState {
    public void playGame(Player player);
    public void twist(Player player);
    public void stick(Player player);
    public String state();
}
