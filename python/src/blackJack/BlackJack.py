import random
from python.src.Deck import Deck
from python.src.CardGame import CardGame

class BlackJack(CardGame):
    """Constant values to be references in the functions and methods below."""
    winningScore = 21
    faceCardScore = 10
    maxAceScore = 11
    minAceScore = 1
    goodNumberOfCards = 5
    noOfCards = 2

    def display(self,message):
        print(message)

    def displayWithItem(self,message,item):
        print(message,item)

    def scoreHand(self,hand):
        """Score an individual hand of playing cards. We add each card score to a total. All face cards King, Queen
     and Jack score ten. If the hand has an ace we can score at one or eleven. If the hand is less than or equal to eleven
     then ten additional score is added on (one already been added and the score for the ace is eleven)"""
        totalScore = 0
        hasAnAce = False
        self.deck.convertFacesToNumbers(hand)
        for card in hand:
            if int(card[1:len(card)]) == self.minAceScore:
                hasAnAce = True
            if int(card[1:len(card)])  > self.faceCardScore: #Face cards i.e. King, Queen and Jack
                totalScore += self.faceCardScore
            else:
                totalScore += int(card[1:len(card)])
        self.deck.convertNumbersToFaces(hand)
        if totalScore > self.winningScore:
            totalScore = 0
        elif hasAnAce and totalScore <= self.maxAceScore:
            totalScore += self.maxAceScore - self.minAceScore

        return totalScore

    def dealToPlayer(self,deck,hand):
        """Deal a card to a player from the deck. The score is then checked and if the have a score above 21 they
     get a score of 0. We return True if they are still below 21 or False if the score goes above i.e. when it is zero."""
        playerGood = False
        hand.append(self.deck.dealACard(deck))
        if self.scoreHand(hand) > 0:
            playerGood = True
        return playerGood

    def validDealInput(self):
        """Get an input of "D"eal or "S"tick from the user, validates only "D" or "S" has been entered and the
     returns the answer in upper case. A while loop is used to prompt the user till the enter a valid response"""
        """Function to get a valid user input for the dealToUser function"""
        allowedAnswers = ["D", "S"]
        answer = input("Please select (D)raw or (S)tick: ")
        while answer.upper() not in allowedAnswers:
            answer = input("That is not a valid input. Please select (D)raw or (S)tick: ")
        return answer.upper()

    def dealToUser(self,deck,hand):
        """The user will be displayed their hand and can either request to be dealt a new ard from the deck or they
     can stick so stop and move on. When you are dealt a card we determine the score, if you go over the limit 21 you loose
     and are bust. In this case we move on."""
        answer = "D"
        while answer == "D":
            self.displayWithItem("Your hand is", hand)
            answer = self.validDealInput()
            if answer == "D":
                if not self.dealToPlayer(deck,hand):
                    answer = "F"
                    self.displayWithItem("Sorry you have gone over the score and are bust", hand)


    def findWinner(self,hands):
        """Go through each of the hands and determine the score. If the score is better than the previous score we
     replace the previous score, so we only store the highest score so far. If we have a draw both players are added to
     the to the previous player list. To determine a winner if you have the same score you win if you have five cards."""
        previousPlayer = []
        previousHand = []
        previousScore = 0

        for counter in range(0,len(hands)):
            currentScore = self.scoreHand(hands[counter])
            if previousScore < currentScore or (previousScore == currentScore and (len(hands[counter])==self.goodNumberOfCards and len(previousHand) != self.goodNumberOfCards)):
                previousPlayer = [counter]
                previousHand = hands[counter]
                previousScore = currentScore
            elif previousScore == currentScore:
                previousPlayer.append(counter)


        return previousPlayer

    def initialiseComputerRisk(self,numberOfPlayer):
        """The  function determines the risk for each computer player. The risk is determined by getting a random
     number. So if there risk level is nine they will stick if the have a score of twelve or above i.e. 21 minus risk
     level. If they have nine they will request an additional card."""
        computerRisk = {}
        for counter in range(1,numberOfPlayer):
            computerRisk[counter] = random.randint(2,9)
        return computerRisk

    def dealToComputer(self,deck,hands,computerRisk):
        """The computer will have a risk, the number on or above they will stick at i.e. not ask for more cards. So
     if there risk level is nine they will stick if the have a score of twelve or above. If they have nine they will request an
     additional card. One gap is the computer does not know if they have an Ace. If the have an ace it could be sensible to
     request another card, this would require a second risk level for when you have an Ace."""
        for counter in computerRisk.keys():
            score = self.scoreHand(hands[counter])
            while score > 0 and score + computerRisk[counter] < self.winningScore and len(deck) >0:
                result = self.dealToPlayer(deck,hands[counter])
                score = self.scoreHand(hands[counter])

    def blackJack(self,deck,hands,computerRisk):
        """The Black Jack method is passed a deck of playing cards, a starting deal of two cards each and the level
     of risk for the computer. The cards need to add up to 21 or less. If you go above 21 you are bust (loose). First the
     user has the opportunity to request more cards to be dealt, one at a time. The computer will have a risk, the number
     on or above they will stick at i.e. not ask for more cards. Once all the cards have been dealt we determine the winner
     i.e. the closest to 21."""
        self.dealToUser(deck, hands[self.deck.userHand])
        self.dealToComputer(deck,hands,computerRisk)
        players = self.findWinner(hands)
        if len(players) == 1:
            self.display("Player " + str(players[0]) + " is the winner")
        else:
            for player in players:
                self.display("Player " + str(player) + " draw")
        self.display(hands)

    def main(self):
        self.startCardGame()
        computerRisk = self.initialiseComputerRisk(self.noOfPlayers)
        self.blackJack(self.deckOfCards,self.hands,computerRisk)

# This allows the main to be called only when you run this file.
if __name__ == "__main__":
    blackJack = BlackJack()
    blackJack.main()
