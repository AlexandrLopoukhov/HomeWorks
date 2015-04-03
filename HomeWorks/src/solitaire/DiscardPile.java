package solitaire;

class DiscardPile extends MovingCardPile {
    DiscardPile(final int x, final int y) {
        super(x, y);
    }

    @Override
    public void addCard(final Card aCard) {
        if (!aCard.isFaceUp()) {
            aCard.flip();
        }
        super.addCard(aCard);
    }

    @Override
    public void select(final int tx, final int ty) {
        if (empty()) {
            return;
        }
        super.moveWhenSelect();

    }

    public void rebank() {
        while (!Solitaire.discardPile.empty()) {
            Solitaire.deckPile.addCard(pop());
        }
    }

    @Override
    public int includesToChoose(final int tx, final int ty) {
        return includes(tx, ty) ? 1 : 0;
    }
}
