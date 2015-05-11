package pokerCombination;

import static org.junit.Assert.*;

import java.awt.CardLayout;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import solitaire.*;

@RunWith(value = Parameterized.class)
public class testPokerChecker {

    private Card[] temp = new Card[5];
    private String combination;

    public testPokerChecker(final int suit0, final int rank0, final int suit1,
            final int rank1, final int suit2, final int rank2, final int suit3,
            final int rank3, final int suit4, final int rank4,
            final String combination) {
        this.temp[0] = new Card(suit0, rank0);
        this.temp[1] = new Card(suit1, rank1);
        this.temp[2] = new Card(suit2, rank2);
        this.temp[3] = new Card(suit3, rank3);
        this.temp[4] = new Card(suit4, rank4);
        this.combination = combination;
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                { 0, 1, 2, 2, 0, 1, 1, 2, 1, 5, "TwoPair" },
                { 1, 3, 1, 5, 0, 5, 2, 1, 2, 3, "TwoPair" },
                { 0, 3, 0, 2, 1, 3, 2, 3, 1, 2, "FullHouse" } };
        return Arrays.asList(data);
    }

    @Test
    public void checkSortByValue2() {
        // for (int i = 0; i < 5; i++) {
        // temp[i] = new Card(suit, rank);
        // }
        System.out.println(temp[0].getSuit() + " " + temp[0].getRank());
        // temp[0] = new Card(suit, rank);
        // temp[1] = new Card(suit, rank);
        // temp[2] = new Card(suit, rank);
        // temp[3] = new Card(suit, rank);
        // temp[4] = new Card(suit, rank);
        // System.out.println(temp[0].getSuit() + " " + temp[0].getRank());
        // // System.out.println(temp[1].getSuit() + " " + temp[1].getRank());
        // // System.out.println(temp[2].getSuit() + " " + temp[2].getRank());
        // // System.out.println(temp[3].getSuit() + " " + temp[3].getRank());
        // // System.out.println(temp[4].getSuit() + " " + temp[4].getRank());

    }

    @Test
    public void checkSortByRank() {
        // for (int i = 0; i < 5; i++) {
        // temp[i] = new Card(1, 5 - i);
        // }
        CheckerForPokerCombination.sort(temp, true);
        for (int i = 1; i < 5; i++) {
            assertTrue(temp[i - 1].getRank() <= temp[i].getRank());
            // assertEquals((i + 1), temp[i].getRank());
        }
    }

    @Test
    public void checkSortBySuit() {
        // temp[0] = new Card(3, 1);
        // temp[1] = new Card(3, 2);
        // temp[2] = new Card(2, 3);
        // temp[3] = new Card(1, 4);
        // temp[4] = new Card(0, 5);
        CheckerForPokerCombination.sort(temp, false);
        for (int i = 1; i < 5; i++) {
            assertTrue(temp[i - 1].getSuit() <= temp[i].getSuit());
            // assertEquals((i + 1), temp[i].getRank());
        }
        // assertEquals(0, temp[0].getSuit());
        // assertEquals(1, temp[1].getSuit());
        // assertEquals(2, temp[2].getSuit());
        // assertEquals(3, temp[3].getSuit());
        // assertEquals(3, temp[4].getSuit());
    }

    @Test
    public void checkNumberOfSameCard() {
        int[] result = new int[2];
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
