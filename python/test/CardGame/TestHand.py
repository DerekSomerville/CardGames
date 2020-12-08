import unittest
from python.src.CardGame.Hand import Hand


class TestHand(unittest.TestCase):

    hand = Hand()

    def test_handAppend(self):
        self.hand.append("HA")
        self.assertEqual("HA", self.hand.playACard())

    def test_handSize(self):
        self.hand.clear()
        self.hand.append("HA")
        self.assertEqual(1,self.hand.size())

    def test_handCopySameCard(self):
        self.hand.clear()
        self.hand.append("HA")
        newHand = self.hand.copy()
        self.assertEqual("HA", newHand.playACard())

    def test_handCopyDiff(self):
        newHand = self.hand.copy()
        self.assertNotEqual(self.hand,newHand)

    def test_handCopyDiffHand(self):
        newHand = self.hand.copy()
        newHand.append("H3")
        self.assertNotEqual(self.hand.hand,newHand.hand)

    def test_handCopyDiffHand(self):
        self.hand.clear()
        newHand = self.hand.copy()
        newHand.append("H3")
        self.assertEqual(0,self.hand.size())

if __name__ == '__main__':
    unittest.main()
