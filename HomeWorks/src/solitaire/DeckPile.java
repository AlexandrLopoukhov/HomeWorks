package solitaire;

public class DeckPile extends CardPile {

    public DeckPile(final int x, final int y) {
        // first initialize parent
        super(x, y);
        // then create the new deck
        // first put them into a local pile
        CardPile pileOne = new CardPile(0, 0);
        CardPile pileTwo = new CardPile(0, 0);
        int count = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= 12; j++) {
                pileOne.addCard(new Card(i, j));
                count++;
            }
        }
        // then pull them out randomly
        for (; count > 0; count--) {
            int limit = ((int) (Math.random() * 1000)) % count;
            // move down to a random location
            for (int i = 0; i < limit; i++) {
                pileTwo.addCard(pileOne.pop());
            }
            // then add the card found there
            addCard(pileOne.pop());
            // then put the decks back together
            while (!pileTwo.empty()) {
                pileOne.addCard(pileTwo.pop());
            }
        }
    }

    @Override
    public void addCard(final Card aCard) {
        if (aCard.isFaceUp()) {
            aCard.flip();
        }
        super.addCard(aCard);
    }

    @Override
    public void select(final int tx, final int ty) {
        if (empty()) {
            Solitaire.discardPile.rebank();
            return;
        }
        Solitaire.discardPile.addCard(pop());
    }

    @Override
    public int includesToChoose(final int tx, final int ty) {
        return includes(tx, ty) ? 1 : 0;
    }

    @Override
    public void chooseList() {
        if (Solitaire.allPiles[Solitaire.choosenDeck].empty()) {
            Solitaire.tmpList.add(null);
        }
        super.chooseList();
    }

}
