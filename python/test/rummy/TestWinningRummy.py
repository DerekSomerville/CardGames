from python.src.rummy.WinningRummy import WinningRummy
from python.src.CardGame.Hand import Hand
import unittest

class TestWinningRummy(unittest.TestCase):

    winningRummy = WinningRummy()

    def test_getGroupsOfSuitsFirst(self):
        handOfCards = ["S2","C5","C6","S9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(["C5","C6"],self.winningRummy.getGroupsOfSuits(hand)[0].getHand())

    def test_getGroupsOfSuitsSecond(self):
        handOfCards = ["S2","C5","C6","S9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(["D4","D6","D8"],self.winningRummy.getGroupsOfSuits(hand)[1].getHand())

    def test_getGroupsOfSuitsThird(self):
        handOfCards = ["S2","C5","C6","S9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(["S2","S9"],self.winningRummy.getGroupsOfSuits(hand)[2].getHand())

    def test_hasThreeOfSameSuit(self):
        handOfCards = ["S8","C9","C6","S9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        compareHand = Hand()
        compareHand.hand = ["D4","D6","D8"]
        self.assertEqual(["D4","D6","D8"],groupBySuit[1].getHand())

    def test_hasFourOfSameSuit(self):
        handOfCards = ["S2","D3","C6","S9","D9","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        compareHand = Hand()
        compareHand.hand = ["D3","D4","D6","D8"]
        self.assertEqual(["D3","D6","D8","D9"],groupBySuit[1].getHand())

    def test_hasTwoGroupsOfSuitsFirst(self):
        handOfCards = ["D2","D3","C6","C9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        compareHandOne = Hand()
        compareHandOne = ["C2","C6","C9"]
        compareHandTwo = Hand()
        compareHandTwo.hand = ["D3","D4","D6","D8"]
        self.assertEqual(["C6","C9"],groupBySuit[0].getHand())

    def test_hasTwoGroupsOfSuitsSecond(self):
        handOfCards = ["C2","D3","C6","C9","D4","D6","D8"]
        hand = Hand()
        hand.hand = handOfCards
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        compareHandOne = Hand()
        compareHandOne = ["C2","C6","C9"]
        compareHandTwo = Hand()
        compareHandTwo.hand = ["D3","D4","D6","D8"]
        self.assertEqual(["D3","D4","D6","D8"],groupBySuit[1].getHand())

    def test_hasNoGroupsOfSuits(self):
        handOfCards = ["C2","H3","C6","H9","D4","D6","S8"]
        hand = Hand()
        hand.hand = handOfCards
        score = self.winningRummy.hasRummyScore(hand)
        self.assertEqual(0,score)

    def test_invertCard(self):
        card = "H5"
        self.assertEqual("5H",self.winningRummy.invertCard(card))

    def test_invertCards(self):
        hand = ["C2","H3","C6","H9","D4","D6","S8"]
        self.assertEqual( ['2C', '3H', '6C', "9H", '4D', '6D','8S'], self.winningRummy.invertCards(hand))

    def test_invertCardsWithAce(self):
        hand = ["C2","H3","CA","H9","D4","D6","S8"]
        self.assertEqual( ['2C', '3H', 'AC', "9H", '4D', '6D', '8S'], self.winningRummy.invertCards(hand))

    def test_invertCardsWithKing(self):
        hand = ["C2","H3","CA","H9","D4","D6","SK"]
        self.assertEqual( ['2C', '3H', 'AC', "9H", '4D', '6D', 'KS'], self.winningRummy.invertCards(hand))

    def test_getRunsFirst(self):
        handOfCards = ["C2","D6","CA","H9","D4","D5","SK"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(["CA","C2"],self.winningRummy.getRuns(hand)[0].getHand())

    def test_getRunsSecond(self):
        handOfCards = ["C2","D6","CA","H9","D4","D5","SK"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(["D4","D5","D6"],self.winningRummy.getRuns(hand)[1].getHand())

    def test_hasRunofThree(self):
        handOfCards = ["C2","D6","CA","H9","D4","D5","SK"]
        hand = Hand()
        hand.hand = handOfCards
        handsOfRun = self.winningRummy.getRuns(hand)
        compareHand = Hand()
        compareHand.hand = ["D4","D5","D6"]
        self.assertEqual(["D4","D5","D6"],handsOfRun[1].getHand())

    def test_hasRunofFour(self):
        handOfCards = ["C2","D6","CA","H9","D4","D5","D3"]
        hand = Hand()
        hand.hand = handOfCards
        handsOfRun = self.winningRummy.getRuns(hand)
        self.assertEqual(["D3","D4","D5","D6"],handsOfRun[1].getHand())

    def test_hasRummy(self):
        handOfCards = ["C2","D6","CA","C9","D4","D5","D3"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertTrue(self.winningRummy.hasRummy(hand))

    def test_hasRummyScore(self):
        handOfCards = ["C2","D6","CA","C9","D4","D5","D3"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertEqual(7,self.winningRummy.hasRummyScore(hand))

    def test_hasNoRummy(self):
        handOfCards = ["C2","D6","CA","H9","D4","D5","D3"]
        hand = Hand()
        hand.hand = handOfCards
        self.assertFalse(self.winningRummy.hasRummy(hand))

if __name__ == '__main__':
    unittest.main()
