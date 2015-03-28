package solitaire;

/*
 Simple Solitaire Card Game in Java
 Written by Tim Budd, Oregon State University, 1996
 */
import java.awt.*;
import java.applet.*;

public class Solitaire extends Applet {
    static CardPile allPiles[];
    static DeckPile deckPile;
    static DiscardPile discardPile;
    static SuitPile suitPile[];
    static TablePile tableau[];
    static boolean isChousen;// TODO добавить сеттер поменять видимость???
    static int numOfChosenCard = 0;
    static Integer choosenDeck = null;

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

        }
    }

    public boolean mouseDown(final Event evt, final int x, final int y) {
        // if TablePile change numberOfCards after select to have right
        // coordinates
        // TODO рабочий код первой версии
        /*
         * for (int i = 0; i < 13; i++) { if (allPiles[i].includes(x, y)) {
         * 
         * 
         * // allPiles[i].select(x, y);
         * 
         * repaint();
         * 
         * return true;
         * 
         * } } return true; }
         */

        if (isChousen) {
            for (int i = 0; i < 13; i++) {
                if (allPiles[i].includes(x, y)) {
                    if (choosenDeck.equals(i)) {
                        try {
                            Card tmpCard = allPiles[choosenDeck].top();
                            for (int j = 0; j < numOfChosenCard; j++) {
                                tmpCard.unHighlight();
                                tmpCard = tmpCard.link;
                            }

                        } catch (NullPointerException e) {
                        }

                        repaint();
                        allPiles[choosenDeck].select(x, y);
                    }
                }
            }
            try {
                Card tmpCard = allPiles[choosenDeck].top();

                for (int j = 0; j < numOfChosenCard; j++) { //
                    tmpCard.unHighlight();
                    tmpCard = tmpCard.link;
                }

            } catch (NullPointerException e) {
            }

            repaint();
            Solitaire.numOfChosenCard = 0;
            Solitaire.isChousen = false;
            Solitaire.choosenDeck = null;
            return true;

        }

        if (!isChousen) {
            for (int i = 0; i < 13; i++) {
                int tmp = allPiles[i].includesToChoose(x, y);
                if (tmp > 0) {
                    Solitaire.numOfChosenCard = tmp;
                    Solitaire.isChousen = true;
                    Solitaire.choosenDeck = i;
                    try {
                        Card tmpCard = allPiles[choosenDeck].top();
                        for (int j = 0; j < numOfChosenCard; j++) {
                            tmpCard.highlight();
                            tmpCard = tmpCard.link;
                        }

                    } catch (NullPointerException e) {
                    }

                    repaint();
                }
            }
            return true;
        }

        return true;

        // allPiles[i].select(x, y);

    }

    public void paint(final Graphics g) {
        for (int i = 0; i < 13; i++) {
            allPiles[i].display(g);
        }
    }
}
