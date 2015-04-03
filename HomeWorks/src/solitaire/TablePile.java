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

    @Override
    public boolean canTake(final Card aCard) {
        if (empty()) {
            return aCard.isKing();
        }
        Card topCard = top();
        return (aCard.color() != topCard.color())
                && (aCard.getRank() == topCard.getRank() - 1);
    }

    @Override
    public void display(final Graphics g) {
        stackDisplay(g, top());
    }

    @Override
    public boolean includes(final int tx, final int ty) {
        return includeForToChoose(tx, ty, true);
    }

    public boolean includeForToChoose(final int tx, final int ty,
            final boolean isFirst) {
        int counter = 0;
        int tY;

        if (empty()) {
            return true;
        }

        Card tmp = this.top();
        while (!(tmp.link == null)) {
            counter++;
            tmp = tmp.link;
        }

        tY = counter * 35 + y;
        if (isFirst == true) {
            return x <= tx && tx <= x + Card.width && tY <= ty
                    && ty <= tY + Card.height;
        }

        return x <= tx && tx <= x + Card.width && tY <= ty && ty <= tY + 35;
    }

    @Override
    public int includesToChoose(final int tx, final int ty) {
        boolean temp = false;
        int numberOfCard = 0;

        if (empty()) {
            return 0;
        }

        for (int i = 0; i < activeCards; i++) {
            if (i == 0) {
                temp = true;
            }
            if (includeForToChoose(tx, ty + 35 * i, temp)) {
                numberOfCard = i + 1;
            }
            temp = false;
        }
        return numberOfCard;
    }

    @Override
    public void addCard(final Card aCard) {
        super.addCard(aCard);
        this.activeCards++;
        System.out.println(this + " " + activeCards);
    }

    @Override
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
