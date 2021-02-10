package BlackJackWithIterator;
import CardGame.Card;

import java.util.*;

public class Hand implements Iterator{
    private int maxSizeOfHand = 52;
    private int numberOfCards = 0;
    private int iteratorPosition = 0;

    private Card[] handOfCards;

    public Hand(int sizeOfHand){

        this.handOfCards = new Card[sizeOfHand];
    }

    public Card next(){
        Card card = handOfCards[iteratorPosition];
        iteratorPosition ++;
        return card;
    }

    public boolean hasNext(){
        return iteratorPosition == handOfCards.length || handOfCards[iteratorPosition] == null;
    }

    public void remove(Card card){
        Card[] newhand = new Card[handOfCards.length];
        int newHandCounter = 0;
        for ( int counter=0; counter < handOfCards.length; counter++){
            if (card.displayCamelCase() == handOfCards[counter].displayCamelCase()) {
                newhand[newHandCounter] = handOfCards[counter];
                newHandCounter++;
            }
        }
        handOfCards = newhand;
    }

    public Card remove(int noOfCard){
        Card card = null;
        Card[] newhand = new Card[handOfCards.length];
        int newHandCounter = 0;
        for ( int counter=0; counter < handOfCards.length; counter++){
            if (counter == noOfCard) {
                card = handOfCards[counter];
            } else {
                newhand[newHandCounter] = handOfCards[counter];
                newHandCounter++;
            }
        }
        handOfCards = newhand;
        return card;
    }
    public Boolean playACard(Card card){
        int currentSizeOfHand = handOfCards.length;
        remove(card);
        return currentSizeOfHand == handOfCards.length -1;
    }

    public Card playACard(String cardShortCode){
        Card card;
        if (cardShortCode.length() == 1) {
            int indexOfCard = Integer.parseInt(cardShortCode);
            card = playACard(indexOfCard);
        } else {
            card = Card.createCard(cardShortCode);
            if (!playACard(card)) {
                card = null;
            }
        }
        return card;
    }

    public Card playACard(){
        return remove(handOfCards.length-1);
    }

    public Card playACard(int userCard){
        return remove(userCard);
    }

    public void add(Card card){
        handOfCards[numberOfCards] = card;
        numberOfCards += 1;
    }

    public void set(int index, Card card){
        handOfCards[index] = card;
    }

    public Hand copy(){
        Hand newHand = new Hand(handOfCards.length);
        for (Card card : getHandAsList()){
            newHand.add(card);
        }
        return newHand;
    }

    public boolean isEmpty(){
        return handOfCards.length == 0;
    }

    public Integer size(){
        return handOfCards.length;
    }

    public String show(){
        String display = "";
        String prefix = "";
        for (Card card : handOfCards){
            display += prefix + card.toString();
            prefix = ", ";
        }
        return display;
    }

    public List<Card> getHandAsList() {
        List<Card> hand = new ArrayList<Card>(Arrays.asList(handOfCards));
        return hand;
    }
    public void sortHand(){
        List<Card> hand = getHandAsList();
        Collections.sort(hand, Comparator.comparing(Card::toString));
    }

    public void sortHandByFace(){
        List<Card> hand = getHandAsList();
        try {
            Collections.sort(hand, Comparator.comparing(Card::getRank));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Hand createHand(String[] listOfCards){
        Hand hand = new Hand(listOfCards.length);
        for (String card : listOfCards){
            hand.add(Card.createCard(card));
        }
        return hand;
    }
}
