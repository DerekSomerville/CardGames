import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    public int numberOfCards = 52;
    private ArrayList<String> deckOfCards;
    private final String[] suits = {"D","C","S","H"};
    private final String[] faces = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    Deck (){
        numberOfCards = suits.length * faces.length;
        deckOfCards = generateDeck();
    }

    private ArrayList<String> generateDeck() {
        ArrayList<String> deckOfCards = new ArrayList<String>(numberOfCards);
        for (String suit: suits){
            for (String face: faces){
                deckOfCards.add(suit + face);
            }
        }
        return deckOfCards;
    }

    public ArrayList getDeck(){
        return deckOfCards;
    }

    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

    public String dealACard(){
        return deckOfCards.remove(-1);
    }

    public ArrayList<ArrayList> dealCards(int noOfCards, int noOfHands){
        ArrayList<ArrayList> hands = new ArrayList<ArrayList>();
        int cardsToDeal;
        if (noOfCards == 0){
            cardsToDeal = (int) Math.ceil(deckOfCards.size()/ noOfHands);
        }
        else {
            cardsToDeal = noOfCards;
        }
        for (int playerCounter=0; playerCounter<noOfHands;playerCounter++){
            ArrayList<String> hand = new ArrayList<String>();
            for (int cardCounter=0;cardCounter<cardsToDeal;cardCounter++){
                if (deckOfCards.size() > 0) {
                    hand.add(dealACard());
                }
            }
            hands.add(hand);
        }
        return hands;
    }

    public static void main(String[ ] args) {
        Deck deck = new Deck();
    }
}


