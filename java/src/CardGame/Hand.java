package CardGame;

import CardGame.Card;

import java.util.*;

public class Hand {
    private ArrayList<Card> handOfCards;

    Hand(){
        this.handOfCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHandOfCards(){
        return handOfCards;
    }

    public Boolean playACard(Card card){
        return handOfCards.remove(card);
    }

    public Card playACard(){
        return handOfCards.remove(0);
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

    public void clear(){
        handOfCards.clear();
    }

    public Integer size(){
        return handOfCards.size();
    }

    public String show(){
        String display = "";
        String prefix = "";
        for (Card card : handOfCards){
            display += prefix + card.shortDisplay();
            prefix = ", ";
        }
        return display;
    }

}
