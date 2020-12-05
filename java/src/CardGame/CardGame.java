package CardGame;
import Display.ConsoleOutput;
import Display.ConsoleInput;
import Display.Input;
import Display.Output;
import Player.Player;
import Player.ComputerPlayer;
import Player.PlayerType;
import BlackJackWithState.BlackJackComputerPlayer;

import java.util.ArrayList;

public class CardGame {

    public Integer noOfCards = 7;
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

    public CardGame(){
        this.deck = Deck.getInstance();
        this.userInput = new ConsoleInput();
        this.userOutput = new ConsoleOutput();
        this.players = new ArrayList<Player>();
    }

    private void createHumanPlayer(){
        userOutput.output("What is your name");
        String name = userInput.getInputString();
        players.add(new Player(PlayerType.USER,name));
    }

    private void createComputerPlayers(Integer noOfPlayers) {
        ComputerPlayer dealer = new ComputerPlayer(PlayerType.DEALER,"Dealer",17);
        players.add(dealer);
        players.add(new ComputerPlayer(PlayerType.COMPUTER,"Comp 1",0));
        noOfPlayers -= 1; //Remove the dealer
        for (int counter=2;counter < noOfPlayers;counter++){
            players.add(new ComputerPlayer(PlayerType.COMPUTER,"Comp" + counter,0));
        }
    }

    protected void initiatePlayers(){
        createHumanPlayer();
        userOutput.output("How many players, minimum of two?");
        int noOfPlayers = userInput.getInputInt();
        createComputerPlayers(noOfPlayers);
        dealCards(noOfPlayers);

    }

    public void dealCards(Integer noOfPlayers){
        boolean allCards = false;
        if (noOfCards == 0) {
            noOfCards = (int) Math.floor(deck.getNumberOfCards()/noOfPlayers);
            allCards = true;
        }
        for (Player player: players){
            player.setHand(dealHand(deck.getDeck(),noOfCards));
        }
        if (allCards){
            for (Player player: players){
                if (deck.getNumberOfCards() > 0){
                    player.getHand().add(deck.playACard());
                }
            }
        }
    }

    public Hand dealHand(Hand hand, int noOfCards){

        for (int cardCounter=0;cardCounter<noOfCards;cardCounter++){
            if (deck.getNumberOfCards() > 0) {
                hand.add(deck.playACard());
            }
        }
        return hand;
    }


    public void initiate(){
        initiatePlayers();
    }

    public void play(){
        initiate();

    }

    public int getScore(Hand hand){
        return 0;
    }

    public void showPlayers(){
        for (Player player: players){
            userOutput.output(player.getName());
            userOutput.output(player.getHand().show());

        }
    }

    public static void main(String[ ] args) {
        CardGame cardGame = new CardGame();
        cardGame.play();
        cardGame.showPlayers();


    }
}
