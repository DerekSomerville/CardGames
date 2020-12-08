from python.src.CardGame.CardGame import Deck
from python.src.CardGame.Hand import Hand

class WinningRummy():

    def getGroupsOfSuits(self,hand):
        allGroupsOfSuites = []
        groupOfSameSuite = Hand()
        hand.sort()
        previousSuit  = ""
        for card in hand.getHand():
            if card[0] == previousSuit:
                groupOfSameSuite.append(card)
            else:
                if groupOfSameSuite.size() > 0:
                    allGroupsOfSuites.append(groupOfSameSuite.copy())
                groupOfSameSuite.clear()
                groupOfSameSuite.append(card)
            previousSuit = card[0]
        allGroupsOfSuites.append(groupOfSameSuite.copy())
        return allGroupsOfSuites

    def invertCard(self,card):
        return card[1:3]+card[0]

    def invertCards(self,hand):
        invertedHand = []
        for card in hand:
            invertedHand.append(self.invertCard(card))
        return invertedHand

    def getRuns(self,hand):
        allRuns = []
        currentRun = Hand()
        previousSuit = ""
        previousFace = 0
        hand.sort()
        hand.convertFacesToNumbers()
        for card in hand.getHand():
            if card[0] == previousSuit and int(card[1:3]) == previousFace + 1:
                currentRun.append(card)
            else:
                if currentRun.size() >1:
                    currentRun.convertNumbersToFaces()
                    allRuns.append(currentRun.copy())
                currentRun.clear()
                currentRun.append(card)
            previousSuit = card[0]
            previousFace = int(card[1:3])
        hand.convertNumbersToFaces()
        return allRuns

    def hasRummyScore(self,handOfCards):
        counter = 0
        newHand = handOfCards.copy()
        handOfRuns = self.getRuns(newHand)
        for hand in handOfRuns:
            if hand.size() >= 3:
                #print("handRummyScore hand",handOfCards.getHand())
                #print("handRummyScore hand of handOfRuns",hand.getHand())
                counter += hand.size()
                for card in hand.getHand():
                    #print("newHand",newHand.getHand())
                    #print("card",card)
                    newHand.remove(card)
        groupBySuit = self.getGroupsOfSuits(newHand)
        for hand in groupBySuit:
            if hand.size() >= 3:
                counter += hand.size()
        return counter

    def hasRummy(self,hand):
        totalCards = 7
        winner = False
        counter = self.hasRummyScore(hand)
        if counter >= totalCards:
            print(hand.getHand())
            winner = True
        return winner
