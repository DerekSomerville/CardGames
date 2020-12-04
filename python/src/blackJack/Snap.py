from python.src.Deck import Deck
from python.src.CardGame import CardGame
import time



class Snap(CardGame):

    userHand = 0
    computerHand = 1


    # Function: initialiseScore
    # Description: Initialises who turn it is the computer of the user and how many winning hands
    def initialiseScore(self):
        return [{"turn":True,"score":0},{"turn":False,"score":0}]

    # Function: isSnap
    # Description: Determine if it is snap by comparing two playing cards
    def isSnap(self,previousCard, nextCard):
        snap = False
        if previousCard[0] == nextCard[0]:
            snap = True
        return snap

    # Function: playCard
    # Description: Deals a card from either the computer or the users hands and prompts the console. The next card dealt
    # from either hand is then returned.
    def playCard(self,currentScore,hands):
        if currentScore[self.computerHand]["turn"]:
            nextCard = self.deck.dealACard(hands[1])
            prompt = "Computer plays "
            currentScore[self.computerHand]["turn"] = False
        else:
            # The next function returns a playing card. The playing card is the next card from the users hand. A list
            # "hands" is a list of lists of cards. The constant playCard.userHand is used to get the hand of cards for the
            # user
            nextCard = self.deck.dealACard(hands[self.deck.userHand])
            prompt = "You played "
            currentScore[self.userHand]["turn"] = False
        print(prompt + nextCard)
        return nextCard

    # Method: determineWinner
    # Description: Determine if the computer or the user has won and display the result. If the user call snap they must do
    # it in a given time set by the user.
    def determineWinner(self,currentScore,previousCard,nextCard,answer,waited,secondsToWait):
        if answer == "S" and self.isSnap(previousCard,nextCard) and waited < secondsToWait:
            print("Correct you win in " + str(waited))
            currentScore[self.userHand]["score"] += 1
            print("You have won " + str(currentScore[self.userHand]["score"]) + " hands")
        elif answer == "S" and self.isSnap(previousCard,nextCard) and waited > secondsToWait:
            print("Sorry to slow you waited " + str(waited))
            print("Computer wins")
            currentScore[self.computerHand]["score"] += 1
            print("Computer has won " + str(currentScore[self.computerHand]["score"]) + " hands")
        elif answer == "S" and not self.isSnap(previousCard, nextCard):
            print("Wrong the cards are different")
        elif answer == "N" and self.isSnap(previousCard,nextCard):
            print("Computer wins")
            currentScore[self.computerHand]["score"] += 1
            print("Computer has won " + str(currentScore[self.computerHand]["score"]) + " hands")

    # Method: main
    # Description: The main logic for snap given a hands of cards and a wait time.
    def snap(self,hands,secondsToWait):
        answer = "N"
        nextCard = "  "
        currentScore = self.initialiseScore()
        while answer.upper() in ["N","S"]:
            previousCard = nextCard
            nextCard = self.playCard(currentScore,hands)
            start = time.time()
            answer = input("Please enter (S)nap or (N)ext")
            waited = time.time() - start
            self.determineWinner(currentScore,previousCard,nextCard,answer,waited,secondsToWait)

    def main(self):

        self.startCardGame()
        secondsToWait = int(input("Seconds to wait"))
        self.snap(self.hands,secondsToWait)

if __name__ == '__main__':
    snap = Snap()
    snap.main()
