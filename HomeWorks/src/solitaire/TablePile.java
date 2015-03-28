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

    public boolean includeForToChoose(final int tx, final int ty,
            final boolean isFinal) {
        int counter = 0;
        int tY;

        try {
            Card tmp = this.top();
            while (!(tmp.link == null)) {
                if (!tmp.isFaceUp()) {
                    counter++;
                }
                tmp = tmp.link;
            }

        } catch (NullPointerException e) {
        }

        tY = counter * 35 + y;
        if (isFinal == true) {
            return x <= tx && tx <= x + Card.width && tY <= ty
                    && ty <= tY + Card.height;
        }
        return x <= tx && tx <= x + Card.width && tY <= ty && ty <= tY + 35;
    }

    public int includesToChoose(final int tx, final int ty) {

        // y, x - top left angle of card
        // TODO можеть быть есть смысл удаить блок переворачивания
        try {
            Card tmp = this.top();
            if (!tmp.isFaceUp()) {
                tmp.flip();
                this.activeCards++;
            }
        } catch (NullPointerException e) {
        }
        boolean temp = false;
        int numberOfCard = 0;
        // int numberOfCard = 0;
        for (int i = 0; i < activeCards; i++) {

            /*
             * if (includes(tx, ty + 35 * i)) { numberOfCard++; }
             */
            if (i == activeCards - 1) {
                temp = true;
            }
            if (includeForToChoose(tx, ty + 35 * i, temp)) {
                numberOfCard = i + 1;
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
