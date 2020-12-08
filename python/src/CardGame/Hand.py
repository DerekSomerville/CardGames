class Hand():

    hand = []

    def __init__(self):
        self.hand = []

    # Method: playACard
    # Description: A hand of cards is input and an individual playing card. If the individual playing card is found in the hand it is removed from
    # the hand.
    def playACard(self,cardToPlay):
        if cardToPlay in self.hand:
            self.hand.remove(cardToPlay)

    # Function: isPlayingACard
    # Description: For a given hand of cards if an individual hand of card is found it is removed from the hand and returns
    # True if no card if found this function returns False.
    def isPlayingACard(self,cardToPlay):
        played = False
        currentSize = len(self.hand)
        playACard(self.hand,cardToPlay)
        if currentSize > len(self.hand):
            played = True
        return played

    # Function: convertFaceToName
    # Description: An individual playing card is input and it is a face card e.g. A,K,Q,J we convert to hexadecimal. We
    # include converting a 10 to A, since it will order 1,2,...9,A,B,C,D. The converted individual playing card is returned.
    # HA -> H1
    # H10 -> H10 -- No change
    # HJ -> H11
    # HQ -> H12
    # CK -> C13
    def convertFaceToNumber(self,card):
        #print("card face to number",card)
        face = card[1:len(card)]
        if face == "K":
            newFace = "13"
        elif face == "Q":
            newFace = "12"
        elif face == "J":
            newFace = "11"
        elif face == "10":
            newFace = "10"
        elif face == "A":
            newFace = "01"
        else:
            newFace = str(0) + face

        return card[0] + newFace

    # Method: convertFacesToNumbers
    # Description: For a hand of cards, each playing card in the hand is converted from faces to hexadecimal numbers
    def convertFacesToNumbers(self):
        for counter in range(0,self.size()):
            self.hand[counter] = self.convertFaceToNumber(self.hand[counter])

    # Function: convertNumberToFace
    # Description: For an individual playing card this reverse the conversion from Face to hexadecimal number.
    def convertNumberToFace(self,card):
        face = card[1:len(card)]
        if face == "13":
            newFace = "K"
        elif face == "12":
            newFace = "Q"
        elif face == "11":
            newFace = "J"
        elif face == "10":
            newFace = "10"
        elif face == "01":
            newFace = "A"
        else:
            newFace = str(int(face))
        return card[0] + newFace

    # Method: convertNumbersToFaces
    # Description: For a hand of cards, each playing card in the hand is converted from a hexadecimal number to a face card
    def convertNumbersToFaces(self):
        for counter in range(0,self.size()):
            self.hand[counter] = self.convertNumberToFace(self.hand[counter])

    # Method: sortHand
    # Description: For a hand of playing cards it is sorted. It is converted to hexadecimal numbers, sorted and converted
    # back to face cards
    def sortHand(self):
        self.convertFacesToNumbers()
        self.hand.sort()
        self.convertNumbersToFaces()

    def sort(self):
        self.sortHand()

    # Method: sortHands
    # Description: For a set of hands of cards for a number of players, each hand is sorted
    def sortHands(self,hands):
        for hand in hands:
            sortHand(hand)

    def append(self,card):
        self.hand.append(card)

    def remove(self,card):
        self.hand.remove(card)

    def playACard(self):
        return self.hand.pop()

    def size(self):
        return len(self.hand)

    def getHand(self):
        return self.hand

    def copy(self):
        newHand = Hand()
        newHand.hand = self.hand.copy()
        return newHand

    def clear(self):
        self.hand.clear()

if __name__ == '__main__':
    hand = Hand()
    print(hand.hand)
    hand.append("HA")
    print(hand.hand)
