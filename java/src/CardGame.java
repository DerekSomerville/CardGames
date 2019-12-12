import java.util.ArrayList;

public class CardGame {

    private Deck deck;
    private ArrayList<Player> players;
    private Input userInput;
    private Output userOutput;

    public Input getUserInput() {
        return userInput;
    }

    public Output getUserOutput(){
        return this.userOutput;
    }

    CardGame(){
        this.deck = Deck.getInstance();
        this.userInput = new ConsoleInput();
        this.userOutput = new ConsoleOutput();
    }
    private void initiatePlayers(){
        userOutput.output("What is your name");
        String name = userInput.getInputString();
        userOutput.output("How many players, minimum of two?");
        int noOfPlayers = userInput.getInputInt();
        players.add(new Player(PlayerType.DEALER,"Dealer"));
        players.add(new Player(PlayerType.COMPUTER,"Comp 1"));
        for (int counter=2;counter < noOfPlayers;counter++){
            players.add(new Player(PlayerType.COMPUTER,"Comp" + counter));
        }
        players.add(new Player(PlayerType.USER,name));

    }

    private void dealHand(Player player, int noOfCards){
        int cardsToDeal;
        if (noOfCards == 0){
            cardsToDeal = (int) Math.ceil(deck.getNumberOfCards()/ players.size());
        }
        else {
            cardsToDeal = noOfCards;
        }

        for (int cardCounter=0;cardCounter<cardsToDeal;cardCounter++){
            if (deck.getNumberOfCards() > 0) {
                player.getHand().add(deck.playACard());
            }
        }
    }

    private void dealPlayers(int noOfCards){
        for (Player player : players){
            dealHand(player,noOfCards);
        }
    }

    private void initiate(int noOfCards){
        initiatePlayers();
        dealPlayers(noOfCards);
    }

    public void play(int noOfCards){
        initiate(noOfCards);
    }
}
