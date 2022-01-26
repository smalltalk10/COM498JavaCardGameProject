/**
 * This class holds the Card functionality of the card game such as
 * allowing Card objects to be created and utilised by other classes.
 * It also contains methods that allow for card objects to be compared.
 */

public final class Card
{
    public int RANK;
    public int SUIT;

    private final String[] RANKS = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"}; // order matters for comparing rank values, takes value and compares
    private final String[] SUITS = {"Hearts", "Clubs", "Spades", "Diamonds"};

    public Card(int rank, int suit) // card constructor for creating card object passing rank and suit
    {
        this.RANK = rank;
        this.SUIT = suit;
    }

    private String getRank() // returns string rank
    {
        return RANKS[RANK];
    }

    private String getSuit() // returns string suit
    {
        return SUITS[SUIT];
    }

    public int getRankValue() // returns rank value as integer
    {
        return RANK+1;
    }

    @Override
    public String toString() // returns rank and string of card
    {
        String result = getRank() + " of " + getSuit();
        return result;
    }

    public int equalEleven(Card otherCard) // checks whether two cards add to eleven
    {
        if ((this.getRankValue()) + (otherCard.getRankValue()) == 11) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public int equalJQK(Card otherCard, Card thirdCard) // checks whether three cards are a jack, queen and king
    {
        if (((this.getRankValue()) + (otherCard.getRankValue()) + (thirdCard.getRankValue()) == 36) //checks if all picture cards = 36
            && this.getRankValue() != otherCard.getRankValue() && this.getRankValue() != thirdCard.getRankValue()
              && otherCard.getRankValue() != thirdCard.getRankValue()) { // and checks if all picture card options are different e.g. don't allow king, king and 10
            return 1;
        }
        else {
            return 0;
        }
    }
}

