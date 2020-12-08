from python.src.CardGame.CardGame import Deck
from python.src.CardGame.CardGame import CardGame
from python.src.rummy.WinningRummy import WinningRummy

class Rummy(CardGame):

    noOfCards = 7

    discardedCards = []
    winningRummy = WinningRummy()

    def playHumanRummyHand(self,hand):
        hand.sort()
        print("Your hand",hand.getHand())
        if len(self.discardedCards) > 0:
            print("Discarded Cards",self.discardedCards[-1])
            userChoice = input("Do you want this card")
            if userChoice.upper()[0] == "Y":
                hand.append(self.discardedCards.pop())
        if len(self.discardedCards) == 0 or userChoice.upper()[0] != "Y":
            hand.append(self.deck.dealACard())
        hand.sort()
        print("Your hand",hand.getHand())
        userCard = input("What card would you like to remove")
        hand.remove(userCard)
        self.discardedCards.append(userCard)

    def cardToDiscard(self,hand):
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        lowestCounter = 0
        lowestCount = 10
        counter = 0
        for hand in groupBySuit:
            if hand.size() < lowestCount:
                lowestCount = hand.size()
                lowestCounter = lowestCounter
            counter += 1

        return groupBySuit[lowestCounter].getHand()[0]

    def playComputerRummyHand(self,hand):
        discardedCard = self.discardedCards.pop()
        hand.append(discardedCard)
        rummyDiscardScore = self.winningRummy.hasRummyScore(hand)
        hand.remove(discardedCard)
        self.discardedCards.append(discardedCard)
        deckCard = self.deck.dealACard()
        hand.append(deckCard)
        rummyDeckScore = self.winningRummy.hasRummyScore(hand)
        if rummyDeckScore > rummyDiscardScore:
            cardToDrop = self.cardToDiscard(hand)
        else:
            hand.remove(deckCard)
            self.deck.append(deckCard)
            hand.append(self.discardedCards.pop())
            cardToDrop = self.cardToDiscard(hand)
        self.discardedCards.append(cardToDrop)
    def playRummy(self):
        counter = 0
        while not self.winningRummy.hasRummy(self.hands[counter]):
            if counter == 0:
                self.playHumanRummyHand(self.hands[counter])
            else:
                self.playComputerRummyHand(self.hands[counter])
            counter = (counter + 1) % self.noOfPlayers

    def main(self):
        self.startCardGame()
        self.playRummy()

if __name__ == "__main__":
    rummy = Rummy()
    rummy.main()
