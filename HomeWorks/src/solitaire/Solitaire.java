package solitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */
import java.awt.*;
import java.applet.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Solitaire extends Applet {
    static CardPile allPiles[];
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static SuitPile suitPile[];
    static TablePile tableau[];
    // TODO inner class
    static int numOfChosenCard = 0;
    static Integer choosenDeck = null;
    static volatile LinkedList<Card> tmpList = new LinkedList<Card>();// TODO

    // cardPile
    @Override
    public void init() {
        // first allocate the arrays
        allPiles = new CardPile[13];
        suitPile = new SuitPile[4];
        tableau = new TablePile[7];
        // then fill them in
        allPiles[0] = deckPile = new DeckPile(335, 5);
        allPiles[1] = discardPile = new DiscardPile(268, 5);
        for (int i = 0; i < 4; i++) {
            allPiles[2 + i] = suitPile[i] = new SuitPile(15 + 60 * i, 5);
        }
        for (int i = 0; i < 7; i++) {
            allPiles[6 + i] = tableau[i] = new TablePile(5 + 55 * i, 80, i + 1);
            // NB!!! set activeCards (faceTop) = 1 in each tablePile after init
            tableau[i].activeCards = 1;
        }
    }

    @Override
    public boolean mouseDown(final Event evt, final int x, final int y) {
        // if TablePile change numberOfCards after select to have right
        // coordinates
        // TODO рабочий код первой версии
        /*
         * for (int i = 0; i < 13; i++) { if (allPiles[i].includes(x, y)) { //
         * allPiles[i].select(x, y); repaint(); return true; } } return true; }
         */

        if (!Solitaire.tmpList.isEmpty()) {
            for (int i = 0; i < 13; i++) {
                if (allPiles[i].includes(x, y)) {
                    // /repack List
                    if (choosenDeck.equals(i)) {
                        // for debug
                        // for (Card x1 : Solitaire.tmpList) {
                        // System.out.println(x1.getRank() + " "
                        // + x1.getSuit() + " "
                        // + Solitaire.tmpList.indexOf(x1));
                        // }
                        System.out.println(tmpList.size());
                        // //
                        allPiles[choosenDeck].select(x, y);

                        // repaint(); delete??? does anof 1 repaint after if
                        // block????
                    }

                    else if ((allPiles[i] instanceof TablePile)
                            && (choosenDeck != i)
                            && (Solitaire.allPiles[i].canTake(Solitaire.tmpList
                                    .getLast()))) {
                        pickUpList();
                        // for debug
                        // for (Card x1 : Solitaire.tmpList) {
                        // System.out.println(x1.getRank() + " "
                        // + x1.getSuit() + " "
                        // + Solitaire.tmpList.indexOf(x1));
                        // }
                        // ///
                        for (int j = numOfChosenCard - 1; j >= 0; j--) {
                            Solitaire.allPiles[i].addCard(Solitaire.tmpList
                                    .get(j));
                        }

                    } else if (((allPiles[i] instanceof SuitPile)
                            && (choosenDeck != i) && (Solitaire.allPiles[i]
                                .canTake(Solitaire.tmpList.getFirst())))
                            || ((allPiles[choosenDeck] instanceof DeckPile) && (allPiles[i] instanceof DiscardPile))) {
                        allPiles[choosenDeck].select(x, y);
                    }
                }
            }
            Solitaire.tmpList.clear();
            Solitaire.numOfChosenCard = 0;
            Solitaire.choosenDeck = null;
            repaint();
            // repaint after choose block
            return true;

        }

        if (Solitaire.tmpList.size() == 0) {
            for (int i = 0; i < 13; i++) {
                int tmp = allPiles[i].includesToChoose(x, y);
                if (tmp > 0) {
                    Solitaire.numOfChosenCard = tmp;
                    Solitaire.choosenDeck = i;
                    chooseList();

                    // repaint();
                }
            }
            // repaint after choose block
            repaint();
            // for (Card x1 : Solitaire.tmpList) {
            // System.out.println(x1.getRank() + " " + x1.getSuit() + " "
            // + Solitaire.tmpList.indexOf(x1) + "cd" + choosenDeck);
            // }
            // System.out.println(Solitaire.tmpList.getLast());
            return true;
        }
        return false;
    }

    private void chooseList() {
        try {
            Card tmpCard = allPiles[choosenDeck].top();
            for (int j = 0; j < numOfChosenCard; j++) {
                Solitaire.tmpList.add(tmpCard);
                tmpCard = tmpCard.link;
            }
        } catch (NullPointerException e) {
        }
    }

    private void pickUpList() {
        tmpList.clear();
        Card tmpCard;
        for (int j = 0; j < numOfChosenCard; j++) {
            tmpCard = allPiles[choosenDeck].pop();
            // tmpCard.link = null;
            Solitaire.tmpList.add(tmpCard);
        }
    }

    @Override
    public void paint(final Graphics g) {
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }
}
