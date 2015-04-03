package solitaire;

public class MovingCardPile extends CardPile {

    MovingCardPile(final int xl, final int yl) {
        super(xl, yl);
    }

    public void moveWhenSelect() {
        // Card topCard = pop();
        Card topCard = top();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(pop());
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].addCard(pop());
                return;
            }
        }
        // nobody can use it, put it back on our list
        // addCard(topCard);
    }

}
