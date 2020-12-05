from python.src.CardGame.Deck import CardGame.Deck

class WinningRummy():

    def getGroupsOfSuits(self,hand):
        allGroupsOfSuites = []
        groupOfSameSuite = []
        hand.sort()
        previousSuit  = ""
        for card in hand:
            if card[0] == previousSuit:
                groupOfSameSuite.append(card)
            else:
                if len(groupOfSameSuite) > 0:
                    allGroupsOfSuites.append(groupOfSameSuite.copy())
                groupOfSameSuite.clear()
                groupOfSameSuite.append(card)
            previousSuit = card[0]
        allGroupsOfSuites.append(groupOfSameSuite.copy())
        return allGroupsOfSuites

    def hasWinningHand(self, hands):
        winningHands = []
        for hand in hands:
            if len(hand) >= 3:
                winningHands.append(hand)
        return winningHands

    def invertCard(self,card):
        return card[1:3]+card[0]

    def invertCards(self,hand):
        invertedHand = []
        for card in hand:
            invertedHand.append(self.invertCard(card))
        return invertedHand

    def getRuns(self,hand):
        allRuns = []
        currentRun = []
        previousSuit = ""
        previousFace = 0
        deck = CardGame.Deck()
        deck.sortHand(hand)
        deck.convertFacesToNumbers(hand)
        for card in hand:
            if card[0] == previousSuit and int(card[1:3]) == previousFace + 1:
                currentRun.append(card)
            else:
                if len(currentRun) >1:
                    deck.convertNumbersToFaces(currentRun)
                    allRuns.append(currentRun.copy())
                currentRun.clear()
                currentRun.append(card)
            previousSuit = card[0]
            previousFace = int(card[1:3])


        return allRuns

    def hasRummy(self,handofRuns,groupBySuit):
        totalCards = 7
        counter = 0
        for hand in handofRuns:
            counter += len(hand)
        for hand in groupBySuit:
            counter += len(hand)
        return counter >= totalCards
