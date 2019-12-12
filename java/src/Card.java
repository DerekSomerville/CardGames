public class Card {

    private Suit suit;

    private CardRank rank;

    public Card(Suit suit,CardRank rank){
        this.suit = suit;
        this.rank = rank;
    }

    public Suit getSuit(){
        return suit;
    }

    public CardRank getRank(){
        return rank;
    }

    public String display(){
        return suit.display() + rank.display();
    }

}
