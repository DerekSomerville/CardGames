public enum Suit {
    HEARTS("Hearts"),
    DIAMONDS("Diamonds"),
    SPADES( "Spades"),
    CLUBS( "Clubs");

    private String camelCase;

    Suit(String camelCase){
        this.camelCase = camelCase;
    }

    public String display(){
        return camelCase;
    }
}
