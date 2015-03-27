package solitaire;

import java.awt.Graphics;

class TablePile extends MovingCardPile {

    public int activeCards = 1;

    TablePile(final int x, final int y, final int c) {
        // initialize the parent class
        super(x, y);
        // then initialize our pile of cards
        for (int i = 0; i < c; i++) {
            addCard(Solitaire.deckPile.pop());
        }

        // flip topmost card face up
        top().flip();
    }

    public boolean canTake(final Card aCard) {
        if (empty()) {
            return aCard.isKing();
        }
        Card topCard = top();
        return (aCard.color() != topCard.color())
                && (aCard.getRank() == topCard.getRank() - 1);
    }

    public void display(final Graphics g) {
        stackDisplay(g, top());
    }

    public boolean includes(final int tx, final int ty) {
        // y, x - top left angle of card

        int counter = 0;
        int tY;
        try {
            Card tmp = this.top();
            while (!(tmp.link == null)) {
                tmp = tmp.link;
                counter++;
            }
        } catch (NullPointerException e) {
        }
        tY = counter * 35 + y;
        return x <= tx && tx <= x + Card.width && tY <= ty
                && ty <= tY + Card.height;
    }

    public int includesToChoose(final int tx, final int ty) {
        // y, x - top left angle of card
        try {
            Card tmp = this.top();

            if (!tmp.isFaceUp()) {
                tmp.flip();
                this.activeCards++;
            }
        } catch (NullPointerException e) {
        }

        int numberOfCard = 0;
        for (int i = 0; i < activeCards; i++) {
            if (includes(tx, ty + 35 * i)) {
                numberOfCard++;
            }
        }
        return numberOfCard;
    }

    @Override
    public void addCard(final Card aCard) {
        // TODO Auto-generated method stub
        super.addCard(aCard);
        this.activeCards += Solitaire.numOfChosenCard;
    }

    public void select(final int tx, final int ty) {
        if (empty()) {
            return;
        }
        // if face down, then flip
        Card topCard = top();
        if (!topCard.isFaceUp()) {
            topCard.flip();
            return;
        }
        super.moveWhenSelect();

        this.activeCards -= Solitaire.numOfChosenCard;
    }

    private int stackDisplay(final Graphics g, final Card aCard) {
        int localy;
        if (aCard == null) {
            return y;
        }
        localy = stackDisplay(g, aCard.link);
        aCard.draw(g, x, localy);
        return localy + 35;
    }
}
