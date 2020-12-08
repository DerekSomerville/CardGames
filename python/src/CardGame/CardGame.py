from python.src.CardGame.Deck import Deck
from python.src.CardGame.Hand import Hand
import math
class CardGame():

    noOfPlayers = None
    noOfCards = 0
    hands = []
    deck = Deck()

        # Function: dealCards
    # Description: Deal a number of cards from a deck to a number of players (no of hands). Optionally an existing set of
    # hands of cards can be passed. The default is for no existing hands of cards to be passed.
    def dealCards(self,noOfCards,noOfHands):
        hands=[]
        allCards = False
        if noOfCards == 0:
            noOfCards = math.floor(self.deck.size()/noOfHands)
            allCards = True

        for handIndex in range(0,noOfHands):
            hand = Hand()
            for counter in range(noOfCards):
                hand.append(self.deck.dealACard())
            hands.append(hand.copy())

        if allCards:
            counter = 0
            while self.deck.size() > 0:
                hands[counter].append(self.deck.dealACard())
                counter = (counter +1) % noOfHands

        return hands

    def startCardGame(self):
        self.noOfPlayers = int(input("Enter the number of players"))
        self.deck.generateDeck()
        self.deck.shuffleCards()
        self.hands = self.dealCards(self.noOfCards,self.noOfPlayers)

if __name__ == '__main__':
    cardGame = CardGame()
    cardGame.startCardGame()
    for hand in cardGame.hands:
        print(hand.getHand())
        print(hand.size())
    print(cardGame.deck.size())
