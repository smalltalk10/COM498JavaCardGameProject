
public class DeckTest
{
    public static void main(String[] args)
    {
        Deck deck = new Deck(); //  test creating instance of a deck using constructor to fill deck ArrayList

        System.out.println("Number of cards in DECK: " + deck.getDeckLength()); // test how many cards are in deck using getter method
        System.out.println();

        System.out.println("New deck of cards created"); // tests if all 52 cards are created
        for(int i = 1; i <= 52; i++){
            System.out.println(i + " - " + deck.getDeckEntry(i));
        }
        System.out.println();

        boolean duplicateFound = false;
        for(int i = 1; i <= 52; i++) { // nested for loop tests whether any of the cards in deck are duplicates
            for(int j = i + 1; j <= 52; j++) {
                if((deck.getDeckEntry(i).toString()).equals(deck.getDeckEntry(j).toString())){
                    duplicateFound = true;
                }
            }
        }
        System.out.println("Duplicates found after creating all 52 cards: " + duplicateFound);
        System.out.println();

        AListArray<Card> TEST = new AListArray<Card>();
        // tests whether first 9 dealt cards are shuffled and can be stored/retrieved in TEST Card ListArray
        System.out.println("Test if first 9 cards are shuffled and can be stored/retrieved in TEST Card ListArray.");
        for(int i = 1; i <= 9; i++) {
            TEST.add(deck.deal());
            System.out.println(i + " - " + TEST.getEntry(i));
        }


        System.out.println("Number of cards in DECK: " + deck.getDeckLength()); // test how many cards are in deck after dealing 9
        System.out.println("Number of cards in stored in TEST Card ListArray: " + TEST.getLength()); // test if 9 cards were retrieved
        System.out.println();

        System.out.println("Test whether card 7 can be retrieved from TEST ListArray above: " + TEST.getEntry(7));

        System.out.println("\nTest if all 52 cards can be shuffled and dealt out.");
        for(int i = 10; i <= 52; i++) { // deal out rest of cards into TEST ListArray until all 52 have been dealt
            TEST.add(deck.deal());
        }

        boolean duplicateFound2 = false;
        for(int i = 1; i <= 52; i++) { // nested for loop tests whether any of the cards in deck are duplicates
            for(int j = i + 1; j <= 52; j++) {
                if((TEST.getEntry(i).toString()).equals(TEST.getEntry(j).toString())){
                    duplicateFound2 = true;
                }
            }
        }
        System.out.println("\nDuplicates found after shuffling and dealing all 52 cards: " + duplicateFound2);

        System.out.println();
        System.out.println("Number of cards in deck: " + deck.getDeckLength()); // test how many cards are in deck after dealing all 52
        System.out.println("Number of cards in stored in TEST Card ListArray: " + TEST.getLength()); // test if all 52 cards were retrieved

    }
}
