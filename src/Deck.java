import java.util.Random;

/**
 * This class holds the Deck functionality of the card game such as
 * the DECK listArray and methods to manipulate the Cards in DECK
 * such as dealing cards in a shuffled order.
 */

public class Deck
{
    private final AListArray<Card> DECK = new AListArray<Card>();
    Random rand = new Random();

    public Deck()
    {
        int NUMCARDS = 52;
        for(int i = 0; i < NUMCARDS; i++) {
            this.DECK.add(new Card(i%13, i/13));
        }
    }

    public Card deal()
    {
        int x = rand.nextInt(1, getDeckLength()+1);
        Card cardToDeal = this.DECK.getEntry(x);
        this.DECK.remove(x);
        return cardToDeal;
    }

    public int getDeckLength() // returns length of deck
    {
        return DECK.getLength();
    }

    public Card getDeckEntry(int index) // returns specific card entry from deck
    {
        return DECK.getEntry(index);
    }
}
