package pokerCombination;

import solitaire.*;

public class CheckerForPokerCombination {

    static void sort(final Card[] hand, final boolean isByRank)
    // bubble sort (by Value or by Suit)
    {
        boolean sorted = false;
        while (!sorted) {
            //
            int i = 0;
            sorted = true;
            while (i < hand.length - 1) {
                //
                boolean gt = isByRank ? hand[i].getRank() > hand[i + 1]
                        .getRank() : hand[i].getSuit() > hand[i + 1].getSuit();
                if (gt) {
                    //
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
        for (int i = 1; i < 5; i++) {
            if (v == temp[i].getRank()) {
                result[current]++;
            } else {
                v = temp[i].getRank();
                // current++;
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
        for (int i = 0; i < 5; i++) {
            hand[i] = dp.pop();
        }
        sort(hand, false);
        System.out.println(numberOfSameCard(hand)[0] + " "
                + numberOfSameCard(hand)[1]);
        for (int i = 0; i < 5; i++) {
            System.out.println(hand[i].getRank() + " " + hand[i].getSuit());
        }

    }

    public static boolean isTwoPairs(final Card[] temp) {
        int[] result = new int[2];
        result = CheckerForPokerCombination.numberOfSameCard(temp);
        return (2 == result[0] && 2 == result[1]);
    }
}
