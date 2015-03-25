package solitaire;

public class MovingCardPile extends CardPile {

    MovingCardPile(final int xl, final int yl) {
        super(xl, yl);
        // TODO Auto-generated constructor stub
    }

    public void moveWhenSelect() {
        Card topCard = pop();
        for (int i = 0; i < 4; i++) {
            if (Solitaire.suitPile[i].canTake(topCard)) {
                Solitaire.suitPile[i].addCard(topCard);
                if (this instanceof TablePile) {
                    ((TablePile) this).setNumberOfCards(((TablePile) this)
                            .getNumberOfCards() - 1);
                }
                return;
            }
        }
        for (int i = 0; i < 7; i++) {
            if (Solitaire.tableau[i].canTake(topCard)) {
                Solitaire.tableau[i].addCard(topCard);
                if (this instanceof TablePile) {
                    ((TablePile) this).setNumberOfCards(((TablePile) this)
                            .getNumberOfCards() - 1);
                }
                return;
            }
        }
        // nobody can use it, put it back on our list
        addCard(topCard);
    }

}
