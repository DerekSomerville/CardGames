import java.util.*;

public class Hand {
    private ArrayList<Card> handOfCards;

    Hand(){
        this.handOfCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHandOfCards(){
        return handOfCards;
    }

    public boolean playACard(Card card){
        return handOfCards.remove(card);
    }

    public void add(Card card){
        handOfCards.add(card);
    }

    public void set(int index, Card card){
        handOfCards.set(index,card);
    }

    public boolean isEmpty(){
        boolean result = false;
        if (handOfCards.size() == 0 ){
            result = true;
        }
        return result;
    }

    public String show(){
        String display = "";
        for (Card card : handOfCards){
            display += ", " + card.getRank().display() + " of " + card.getSuit().display();
        }
        return display;
    }

}
