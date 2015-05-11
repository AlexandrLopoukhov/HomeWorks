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
                { 0, 3, 0, 2, 1, 3, 2, 3, 1, 2, "FullHouse" },
                { 0, 3, 0, 0, 1, 1, 2, 3, 1, 2, "Pair" },
                { 0, 3, 1, 3, 1, 1, 2, 3, 1, 8, "Set" },
                { 1, 3, 1, 2, 1, 1, 1, 10, 1, 8, "Flush" },
                { 0, 8, 0, 0, 2, 8, 2, 3, 1, 8, "Set" },
                { 3, 8, 0, 0, 3, 0, 2, 0, 1, 0, "FourOfAKind" },
                { 1, 8, 0, 0, 2, 8, 3, 8, 0, 8, "FourOfAKind" },
                { 0, 0, 0, 2, 1, 5, 2, 3, 1, 0, "Pair" },
                { 0, 0, 0, 2, 1, 1, 2, 3, 1, 4, "Straight" },
                { 0, 2, 0, 4, 1, 5, 2, 6, 1, 7, "StraightFail" },// must down
                { 0, 5, 0, 2, 1, 1, 2, 3, 1, 4, "Straight" },
                { 1, 0, 1, 2, 1, 1, 1, 3, 1, 4, "StraightFlush" },
                { 1, 5, 1, 2, 1, 1, 1, 3, 1, 4, "StraightFlush" },
                { 1, 9, 1, 10, 1, 11, 1, 12, 1, 0, "RoyalFlush" } };
        return Arrays.asList(data);
    }

    @Test
    public void checkSortByRank() {
        CheckerForPokerCombination.sort(temp, true);
        for (int i = 1; i < 5; i++) {
            assertTrue(temp[i - 1].getRank() <= temp[i].getRank());
        }
    }

    @Test
    public void checkSortBySuit() {
        CheckerForPokerCombination.sort(temp, false);
        for (int i = 1; i < 5; i++) {
            assertTrue(temp[i - 1].getSuit() <= temp[i].getSuit());
        }
    }

    @Test
    public void checkNumberOfSameCard() {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        if (combination.equals("TwoPair")) {
            assertEquals(2, result[0]);
            assertEquals(2, result[1]);
        } else if (combination.equals("FullHouse")) {
            assertEquals(5, result[0] + result[1]);
        } else if (combination.equals("Pair")) {
            assertEquals(3, result[0] + result[1]);
        } else if (combination.equals("Set")) {
            assertEquals(4, result[0] + result[1]);
        } else if (combination.equals("FourOfAKind")) {
            assertEquals(5, result[0] + result[1]);
        } else {
            assertEquals(1, result[0]);
            assertEquals(1, result[1]);
        }
    }

    @Test
    public void checkFullHouse() {
        if (combination.equals("FullHouse")) {
            assertEquals(true, CheckerForPokerCombination.isFullHouse(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isFullHouse(temp));
        }
    }

    @Test
    public void checkTwoPair() {
        if (combination.equals("TwoPair")) {
            assertEquals(true, CheckerForPokerCombination.isTwoPairs(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isTwoPairs(temp));
        }
    }

    @Test
    public void checkPair() {
        if (combination.equals("Pair")) {
            assertEquals(true, CheckerForPokerCombination.isPair(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isPair(temp));
        }
    }

    @Test
    public void checkSet() {
        if (combination.equals("Set")) {
            assertEquals(true, CheckerForPokerCombination.isSet(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isSet(temp));
        }
    }

    @Test
    public void checkFourOfAKind() {
        if (combination.equals("FourOfAKind")) {
            assertEquals(true, CheckerForPokerCombination.isFourOfAKind(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isFourOfAKind(temp));
        }
    }

    // //убрать втлрое условие
    @Test
    public void checkFlush() {
        if (combination.equals("Flush") || combination.equals("StraightFlush")
                || combination.equals("RoyalFlush")) {
            assertEquals(true, CheckerForPokerCombination.isFlush(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isFlush(temp));
        }
    }

    @Test
    public void checkStraight() {
        if (combination.equals("Straight")) {
            assertEquals(true,
                    CheckerForPokerCombination.isStraight(temp, false));
        } else {
            assertEquals(false,
                    CheckerForPokerCombination.isStraight(temp, false));
        }
    }

    @Test
    public void checkStraightFlush() {
        if (combination.equals("StraightFlush")
                || combination.equals("RoyalFlush")) {
            assertEquals(true,
                    CheckerForPokerCombination.isStraight(temp, true));
        } else {
            assertEquals(false,
                    CheckerForPokerCombination.isStraight(temp, true));
        }
    }

    @Test
    public void checkRoyalFlush() {
        if (combination.equals("RoyalFlush")) {
            assertEquals(true, CheckerForPokerCombination.isRoyalFlush(temp));
        } else {
            assertEquals(false, CheckerForPokerCombination.isRoyalFlush(temp));
        }
    }
}
