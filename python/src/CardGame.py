from python.src.CardGame.Deck import CardGame.Deck
class CardGame.CardGame():

    noOfPlayers = None
    noOfCards = 0
    hands = []
    deck = CardGame.Deck()
    deckOfCards = []

    def startCardGame(self):
        self.noOfPlayers = int(input("Enter the number of players"))
        self.deckOfCards = self.deck.shuffleCards(self.deck.generateDeck())
        self.hands = self.deck.dealCards(self.deckOfCards,self.noOfCards,self.noOfPlayers)
