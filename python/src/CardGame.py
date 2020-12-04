from python.src.Deck import Deck
class CardGame():

    noOfPlayers = None
    noOfCards = 0
    hands = []
    deck = Deck()
    deckOfCards = []

    def startCardGame(self):
        self.noOfPlayers = int(input("Enter the number of players"))
        self.deckOfCards = self.deck.shuffleCards(self.deck.generateDeck())
        self.hands = self.deck.dealCards(self.deckOfCards,self.noOfCards,self.noOfPlayers)
