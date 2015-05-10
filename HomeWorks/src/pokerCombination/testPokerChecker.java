package pokerCombination;

import static org.junit.Assert.*;

import java.awt.CardLayout;

import org.junit.Test;

import solitaire.*;

public class testPokerChecker {

    @Test
    public void checkSortByValue() {
        Card[] temp = new Card[5];
        for (int i = 0; i < 5; i++) {
            temp[i] = new Card(1, 5 - i);
        }
        CheckerForPokerCombination.sort(temp, true);
        for (int i = 0; i < 5; i++) {
            assertEquals((i + 1), temp[i].getRank());
        }
    }

    @Test
    public void checkSortByRank() {
        Card[] temp = new Card[5];
        temp[0] = new Card(3, 1);
        temp[1] = new Card(3, 2);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 4);
        temp[4] = new Card(0, 5);
        CheckerForPokerCombination.sort(temp, false);
        assertEquals(0, temp[0].getSuit());
        assertEquals(1, temp[1].getSuit());
        assertEquals(2, temp[2].getSuit());
        assertEquals(3, temp[3].getSuit());
        assertEquals(3, temp[4].getSuit());
    }

    @Test
    public void checkNumberOfSameCard() {
        int[] result = new int[2];
        Card[] temp = new Card[5];
        temp[0] = new Card(3, 2);
        temp[1] = new Card(3, 2);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 3);
        temp[4] = new Card(0, 5);
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        assertEquals(2, result[0]);

        temp[0] = new Card(3, 2);
        temp[1] = new Card(3, 2);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 3);
        temp[4] = new Card(0, 5);
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        assertEquals(2, result[0]);
        assertEquals(2, result[1]);

        temp[0] = new Card(3, 2);
        temp[1] = new Card(3, 2);
        temp[2] = new Card(2, 2);
        temp[3] = new Card(1, 2);
        temp[4] = new Card(0, 5);
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        assertEquals(4, result[0]);
        assertEquals(1, result[1]);

        temp[0] = new Card(3, 2);
        temp[1] = new Card(3, 2);
        temp[2] = new Card(2, 2);
        temp[3] = new Card(1, 3);
        temp[4] = new Card(0, 3);
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        assertEquals(3, result[0]);
        assertEquals(2, result[1]);

        temp[0] = new Card(3, 3);
        temp[1] = new Card(3, 3);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 2);
        temp[4] = new Card(0, 2);
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        assertEquals(2, result[0]);
        assertEquals(3, result[1]);
    }

    @Test
    public void checkFullHouse() {
        Card[] temp = new Card[5];
        temp[0] = new Card(3, 5);
        temp[1] = new Card(3, 3);
        temp[2] = new Card(2, 5);
        temp[3] = new Card(1, 5);
        temp[4] = new Card(0, 3);
        assertEquals(true, CheckerForPokerCombination.isFullHouse(temp));

        temp[0] = new Card(3, 3);
        temp[1] = new Card(3, 5);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 5);
        temp[4] = new Card(0, 3);
        assertEquals(true, CheckerForPokerCombination.isFullHouse(temp));

        temp[0] = new Card(3, 3);
        temp[1] = new Card(3, 1);
        temp[2] = new Card(2, 3);
        temp[3] = new Card(1, 2);
        temp[4] = new Card(0, 2);
        assertEquals(false, CheckerForPokerCombination.isFullHouse(temp));
    }

    @Test
    public void checkTwoPair() {
        Card[] temp = new Card[5];
        temp[0] = new Card(3, 5);
        temp[1] = new Card(3, 3);
        temp[2] = new Card(2, 1);
        temp[3] = new Card(1, 5);
        temp[4] = new Card(0, 3);
        assertEquals(true, CheckerForPokerCombination.isTwoPairs(temp));

        temp[0] = new Card(3, 5);
        temp[1] = new Card(3, 3);
        temp[2] = new Card(2, 5);
        temp[3] = new Card(1, 1);
        temp[4] = new Card(0, 2);
        assertEquals(false, CheckerForPokerCombination.isTwoPairs(temp));
    }
}
