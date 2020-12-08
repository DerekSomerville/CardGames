import random #, playingCardTests
from python.src.CardGame.Hand import Hand

class Deck():

    suits = {"H": "Hearts", "D": "Diamonds", "S": "Spades", "C": "Clubs"}
    faces = ["A","2","3","4","5","6","7","8","9","10","J","Q","K"]

    deckOfCards = Hand()
    userHand = 0

    # Function: generateDeck
    # Description: This function generates a 52 pack of cards, with four suites and 13 playing cards Ace to King.
    # The cards are returned in an ordered deck
    def generateDeck(self):
        for suit in self.suits.keys():
            for face in self.faces:
                self.deckOfCards.append(suit + face)

    # Function: shuffleDeck
    # Description: A set of cards is supplied and shuffled, randomly ordered.
    def shuffleCards(self):
        random.shuffle(self.deckOfCards.getHand())


    # Method: trentineSmall
    # Description: An Italian set of cards Tertine can be only 40 cards or 52. The small set has no "8","9" or "10". It
    # still has ace to seven and jack, queen and king.
    def trentineSmall(self):
        faces.remove("8")
        faces.remove("9")
        faces.remove("10")

    # Function: dealACard
    # Description: Remove a card from a deck or hand of cards and return the card.
    def dealACard(self):
        if self.deckOfCards.size() == 0:
            self.generateDeck()
            self.shuffleCards()
        return self.deckOfCards.playACard()

    def append(self,card):
        self.deckOfCards.append(card)

    def show(self):
        return self.deckOfCards.getHand()

    def size(self):
        return self.deckOfCards.size()

if __name__ == '__main__':
    deck = Deck()
    deck.generateDeck()
    print(deck.show())
