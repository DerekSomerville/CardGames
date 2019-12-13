import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Deck{
    public int numberOfCards = 52;
    private static Deck uniqueDeck;
    private static ArrayList<Card> deckOfCards;
    private static HashMap< int[] ,Card> cardHashMap;

    private Deck(){
        deckOfCards = new ArrayList<Card>();
    }

    private static void generateDeck() {
        for (Suit suit: Suit.values()){
            for (CardRank rank: CardRank.values()){
                Card card = new Card(suit,rank);
                deckOfCards.add(card);
            }
        }
    }

    public static Deck getInstance (){
        if (uniqueDeck == null){
            uniqueDeck = new Deck();
            generateDeck();
        }

        return uniqueDeck;


    }

    public int getNumberOfCards(){
        return deckOfCards.size();
    }

    public Card playACard(){
        return deckOfCards.remove(-1);
    }

    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }

//    public static void main(String[ ] args) {
//        Deck deck = new Deck();
//    }
}


