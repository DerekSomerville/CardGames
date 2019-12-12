public class BlackJack extends CardGame {
    private int maxScore = 21;

    BlackJack(){
        this.setGame(new BlackJack());
    }

    private void help(){
        getUserOutput().output("Options are:");
        getUserOutput().output("Play");
        getUserOutput().output("Twist");
        getUserOutput().output("Stick");
    }

    private void callAction(Player player, String request){
        if (request.substring(0,1) = "P"){
            player.getState().startGame();
        }
        else if (request.substring(0,1)  = "T"){
            player.getState().twist();
        }
        else if (request.substring(0,1) = "S"){
            player.getState().stick();
        } else {
            getUserOutput().output("Command not found");
        }
    }
    public void play(){
        int noOfCards = 2;
        initiate(noOfCards);
        for ( Player player : getPlayers()){
            if (player.getPlayerType() == PlayerType.USER) {
                help();
                String request = getGame().getUserInput().getInputString();
                callAction(player,request);
            }
        }
    }

    public int getMaxScore(){
        return maxScore;
    }

    public int getScore(Hand hand){
        int score = 0;
        for (Card card: hand.getHandOfCards()){
            score += card.getRank().getValue();
        }
        return score;
    }
}
