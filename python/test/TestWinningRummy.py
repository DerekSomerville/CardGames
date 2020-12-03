from python.src.rummy.WinningRummy import WinningRummy
import unittest

class TestWinningRummy(unittest.TestCase):

    winningRummy = WinningRummy()

    def test_getGroupsOfSuits(self):
        hand = ["S2","C5","C6","S9","D4","D6","D8"]
        self.assertEqual([["C5","C6"],["D4","D6","D8"],["S2","S9"]],self.winningRummy.getGroupsOfSuits(hand))

    def test_hasThreeOfSameSuit(self):
        hand = ["S2","C5","C6","S9","D4","D6","D8"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        self.assertEqual([["D4","D6","D8"]],self.winningRummy.hasWinningHand(groupBySuit))

    def test_hasFourOfSameSuit(self):
        hand = ["S2","D3","C6","S9","D4","D6","D8"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        self.assertEqual([["D3","D4","D6","D8"]],self.winningRummy.hasWinningHand(groupBySuit))

    def test_hasTwoGroupsOfSuits(self):
        hand = ["C2","D3","C6","C9","D4","D6","D8"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        self.assertEqual([["C2","C6","C9"],["D3","D4","D6","D8"]],self.winningRummy.hasWinningHand(groupBySuit))

    def test_hasNoGroupsOfSuits(self):
        hand = ["C2","H3","C6","H9","D4","D6","S8"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        self.assertEqual([],self.winningRummy.hasWinningHand(groupBySuit))

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

    def test_getRuns(self):
        hand = ["C2","D6","CA","H9","D4","D5","SK"]
        self.assertEqual([["CA","C2"],["D4","D5","D6"]],self.winningRummy.getRuns(hand))

    def test_hasRunofThree(self):
        hand = ["C2","D6","CA","H9","D4","D5","SK"]
        handsOfRun = self.winningRummy.getRuns(hand)
        self.assertEqual([["D4","D5","D6"]],self.winningRummy.hasWinningHand(handsOfRun))

    def test_hasRunofFour(self):
        hand = ["C2","D6","CA","H9","D4","D5","D3"]
        handsOfRun = self.winningRummy.getRuns(hand)
        self.assertEqual([["D3","D4","D5","D6"]],self.winningRummy.hasWinningHand(handsOfRun))

    def test_hasRummy(self):
        hand = ["C2","D6","CA","C9","D4","D5","D3"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        handsOfRun = self.winningRummy.getRuns(hand)
        self.assertTrue(self.winningRummy.hasRummy(handsOfRun,groupBySuit))

    def test_hasNoRummy(self):
        hand = ["C2","D6","CA","H9","D4","D5","D3"]
        groupBySuit = self.winningRummy.getGroupsOfSuits(hand)
        handsOfRun = self.winningRummy.getRuns(hand)
        self.assertTrue(self.winningRummy.hasRummy(handsOfRun,groupBySuit))

if __name__ == '__main__':
    unittest.main()
