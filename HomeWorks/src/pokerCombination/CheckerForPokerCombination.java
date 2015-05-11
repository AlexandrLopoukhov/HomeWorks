package pokerCombination;

import solitaire.*;

public class CheckerForPokerCombination {

    static void sort(final Card[] hand, final boolean isByRank)
    // bubble sort (by Value or by Suit)
    {
        boolean sorted = false;
        while (!sorted) {
            int i = 0;
            sorted = true;
            while (i < hand.length - 1) {
                boolean cond = isByRank ? hand[i].getRank() > hand[i + 1]
                        .getRank() : hand[i].getSuit() > hand[i + 1].getSuit();
                if (cond) {
                    sorted = false;
                    Card tmp = hand[i + 1];
                    hand[i + 1] = hand[i];
                    hand[i] = tmp;
                }
                i++;
            }
        }
    }

    static int[] numberOfSameCard(final Card[] temp) {
        // return number of same card via two set
        int[] result = new int[2];
        result[0] = 1;
        result[1] = 1;
        sort(temp, true); // sort by value

        int current = 0;

        int v = temp[0].getRank();
        for (int i = 1; i < temp.length; i++) {
            if (v == temp[i].getRank()) {
                result[current]++;
            } else {
                v = temp[i].getRank();
                if (1 < result[current]) {
                    current++;
                }
                if (2 == current) {
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isFullHouse(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return ((3 == result[0] && 2 == result[1]) || (3 == result[1] && 2 == result[0]));
    }

    public static void main(final String[] args) {
        DeckPile dp = new DeckPile(0, 0);
        Card[] hand = new Card[5];
        for (int i = 0; i < hand.length; i++) {
            hand[i] = dp.pop();
        }
        sort(hand, false);
        for (int i = 0; i < hand.length; i++) {
            System.out.println(Card.names[hand[i].getRank()] + " "
                    + Card.suits[hand[i].getSuit()]);
        }
        System.out.println("----------------------");
        System.out.println(whatCombination(hand));

    }

    public static boolean isTwoPairs(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return (2 == result[0] && 2 == result[1]);
    }

    public static boolean isPair(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return ((2 == result[0] && 1 == result[1]) || (2 == result[1] && 1 == result[0]));
    }

    public static boolean isSet(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return ((3 == result[0] && 1 == result[1]) || (3 == result[1] && 1 == result[0]));
    }

    public static boolean isFourOfAKind(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return ((4 == result[0] && 1 == result[1]) || (4 == result[1] && 1 == result[0]));
    }

    public static boolean isFlush(final Card[] temp) {
        sort(temp, false);
        for (int i = 1; i < temp.length; i++) {
            if (temp[0].getSuit() != temp[i].getSuit()) {
                return false;
            }
        }
        return true;
        // return !isStraight(????
    }

    public static boolean isStraight(final Card[] temp, final boolean isFlush) {
        sort(temp, true);
        for (int i = 1; i < temp.length - 1; i++) {
            if (temp[i].getRank() + 1 != temp[i + 1].getRank()
                    || ((temp[0].getRank() != 0) && (temp[0].getRank() + 1 != temp[1]
                            .getRank()))) {
                return false;
            }
        }
        if (isFlush) {
            return isFlush(temp);
        }
        return !isFlush(temp);

    }

    public static boolean isRoyalFlush(final Card[] temp) {
        sort(temp, true);
        return (temp[0].isAce() && isStraight(temp, true) && temp[4].isKing());
    }

    public static String whatCombination(final Card[] temp) {
        if (isRoyalFlush(temp)) {
            return "RoyalFlush";
        }
        if (isStraight(temp, true)) {
            return "StraightFlush";
        }
        if (isFlush(temp)) {
            return "Flush";
        }
        if (isStraight(temp, false)) {
            return "Straight";
        }
        if (isFourOfAKind(temp)) {
            return "FourOfAKind";
        }
        if (isFullHouse(temp)) {
            return "FullHouse";
        }
        if (isSet(temp)) {
            return "Set";
        }
        if (isTwoPairs(temp)) {
            return "TwoPair";
        }
        if (isPair(temp)) {
            return "Pair";
        }
        return "Card";
    }
}
