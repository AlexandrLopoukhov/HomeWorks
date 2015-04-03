package solitaire;

class SuitPile extends CardPile {
    SuitPile(final int x, final int y) {
        super(x, y);
    }

    @Override
    public boolean canTake(final Card aCard) {
        if (empty()) {
            return aCard.isAce();
        }
        Card topCard = top();
        return (aCard.getSuit() == topCard.getSuit())
                && (aCard.getRank() == 1 + topCard.getRank());
    }
}
