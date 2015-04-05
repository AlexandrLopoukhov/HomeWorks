package solitaire;

public class MovingCardPile extends CardPile {

    MovingCardPile(final int xl, final int yl) {
        super(xl, yl);
    }

    public void moveWhenSelect() {
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(top())) {
                Solitaire.suitPile[i].addCard(pop());
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(top())) {
                Solitaire.tableau[i].addCard(pop());
                return;
            }
        }
    }

}
