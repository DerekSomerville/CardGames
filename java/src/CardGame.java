import java.util.ArrayList;

public class CardGame {

    private Deck deck;
    private ArrayList<Player> players;
    private Input userInput;
    private Output userOutput;
    private CardGame game;

    public Input getUserInput() {
        return userInput;
    }

    public Output getUserOutput(){
        return this.userOutput;
    }

    public CardGame getGame(){
        return game;
    }

    public Deck getDeck() { return deck;}

    public ArrayList<Player> getPlayers(){
        return players;
    }

    protected void setGame(CardGame game){
        this.game = game;
    }

    CardGame(){
        this.deck = Deck.getInstance();
        this.userInput = new ConsoleInput();
        this.userOutput = new ConsoleOutput();
        this.players = new ArrayList<Player>();
    }

    protected void initiatePlayers(){
        userOutput.output("What is your name");
        String name = userInput.getInputString();
        userOutput.output("How many players, minimum of two?");
        int noOfPlayers = userInput.getInputInt();
        ComputerPlayer dealer = new ComputerPlayer(PlayerType.DEALER,"Dealer",17);
        players.add(dealer);
        players.add(new ComputerPlayer(PlayerType.COMPUTER,"Comp 1",0));
        for (int counter=1;counter < noOfPlayers;counter++){
            players.add(new ComputerPlayer(PlayerType.COMPUTER,"Comp" + counter,0));
        }
        players.add(new Player(PlayerType.USER,name));

    }

    public void dealHand(Player player, int noOfCards){
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


    public void initiate(int noOfCards){
        initiatePlayers();
    }

    public void play(int noOfCards){
        initiate(noOfCards);

    }


    public static void main(String[ ] args) {
        CardGame cardGame = new CardGame();
        cardGame.play(2);

    }
}
