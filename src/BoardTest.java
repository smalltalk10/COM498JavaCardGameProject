import java.util.Arrays;

public class BoardTest extends Board
{
    private final AListArray<Card> tstBRD = new AListArray<Card>(); //Test board
    private final AListArray<Card> tstDCK = new AListArray<Card>(); //Test deck
    private final Queue<String> REPLAY = new Queue<String>();
    private int counter;

    private void createWinTestBoard() // Creates 2 - 10 of Hearts in test Board
    {
        tstBRD.add(new Card(0,0));
        tstBRD.add(new Card(1,0));
        tstBRD.add(new Card(2,0));
        tstBRD.add(new Card(3,0));
        tstBRD.add(new Card(4,0));
        tstBRD.add(new Card(5,0));
        tstBRD.add(new Card(6,0));
        tstBRD.add(new Card(7,0));
        tstBRD.add(new Card(8,0));
    }
    private void createWinTestDeck() // Creates Jack - King of Hearts in test Deck
    {
        counter = 4;
        tstDCK.add(new Card(9,0));
        tstDCK.add(new Card(10,0));
        tstDCK.add(new Card(11,0));
        tstDCK.add(new Card(12,0));
    }

    private void createLoseTestBoard() // Creates 2 - 10 of Hearts in test Board
    {
        tstBRD.add(new Card(4,0));
        tstBRD.add(new Card(5,0));
        tstBRD.add(new Card(2,1));
        tstBRD.add(new Card(6,3));
        tstBRD.add(new Card(4,3));
        tstBRD.add(new Card(4,1));
        tstBRD.add(new Card(10,0));
        tstBRD.add(new Card(3,3));
        tstBRD.add(new Card(12,2));
    }

    private void createLoseTestDeck() // Creates 2 - 10 of Hearts in test Board
    {
        counter = 4;
        tstDCK.add(new Card(7,3));
        tstDCK.add(new Card(12,0));
        tstDCK.add(new Card(9,2));
        tstDCK.add(new Card(6,1));
    }

    public Card dealCard()  // deals a card from test deck
    {
        int length = counter;
        Card deal = tstDCK.remove(length);
        counter--;
        return deal;
    }

    private void test()
    {
        System.out.println("\nCreating a testBoard and testDeck with only Cards that have suit 'Hearts' ranging from Ace to King.");
        createWinTestBoard();
        createWinTestDeck();

        System.out.println("\nLength of testBOARD card arrayList: " + tstBRD.getLength());
        System.out.println("Length of testDECK card arrayList: " +tstDCK.getLength());

        System.out.println("\nTest displayBoard method with full testBoard and remaining testDeck length.");
        testDisplayBoard(tstBRD);

        System.out.println("\nTest checkPossibleMoves method for possible moves and test replaceCards method if move is present");
        System.out.println("----Test on cards that should Win.----");
        while(tstBRD.getLength() > 0) {
            if (checkPossibleMoves(BOARD).isEmpty()) {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println("STALEMATE");
                break;
                }
            else if (checkPossibleMoves(tstBRD).getLength() > 2) {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println(tstBRD.toString());
                testReplaceCards(checkPossibleMoves(tstBRD).getEntry(1), checkPossibleMoves(tstBRD).getEntry(2),
                        checkPossibleMoves(tstBRD).getEntry(3));
            }
            else {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println(tstBRD.toString());
                testReplaceCards(checkPossibleMoves(tstBRD).getEntry(1), checkPossibleMoves(tstBRD).getEntry(2));
            }
        }
        System.out.println("\nBoard after test completed: " + tstBRD.toString());

        System.out.println("\nTesting Replay functionality");
        while (!REPLAY.isEmpty()) {
            System.out.println(REPLAY.dequeue());
        }

        System.out.println("\nCreating a testBoard and testDeck with shuffled arrangement of cards that shouldn't be able to win");
        createLoseTestBoard();
        createLoseTestDeck();

        System.out.println("\nTest checkPossibleMoves method for possible moves and test replaceCards method if move is present");
        System.out.println("----Test on cards that should Lose.----");
        while(tstBRD.getLength() > 0) {
            if (checkPossibleMoves(tstBRD).isEmpty()) {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println(tstBRD.toString());
                System.out.println("STALEMATE");
                break;
            }
            else if (checkPossibleMoves(tstBRD).getLength() > 2) {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println(tstBRD.toString());
                testReplaceCards(checkPossibleMoves(tstBRD).getEntry(1), checkPossibleMoves(tstBRD).getEntry(2),
                        checkPossibleMoves(tstBRD).getEntry(3));
            }
            else {
                System.out.println("\nReturns slots that can be removed as integer ArrayList: " + checkPossibleMoves(tstBRD));
                System.out.println(tstBRD.toString());
                testReplaceCards(checkPossibleMoves(tstBRD).getEntry(1), checkPossibleMoves(tstBRD).getEntry(2));
            }
        }

        System.out.println("\nCurrent state of board after test");
        testDisplayBoard(tstBRD);

        try {
            System.out.println("Test to replace slots 7 & 8 in tstBRD ArrayList.");
            testReplaceCards(7, 8);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException error caught.");
            System.out.println("8 is out of range.\n");
        }
        System.out.println("Changes made (if any): " + tstBRD.toString());

        try {
            System.out.println("\nTest to replace slots 0 and 1 in tstBRD ArrayList.");
            testReplaceCards(0, 1);
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("IndexOutOfBoundsException error caught.");
            System.out.println("0 is out of range.\n");
        }
        System.out.println("Changes made (if any): " + tstBRD.toString());
        System.out.println("\nIf changes made, must ensure accidental user selection is limited appropriately to prevent any " +
                "unwanted crashes or replacements.");
    }


    public static void main(String[] args)
    {
        BoardTest boardTest = new BoardTest();
        boardTest.test();
    }

    //-----------------Test Methods adapted from Board Class using test variables--------------------


    private void testReplaceCards(int replace1, int replace2)
    {
        REPLAY.enqueue("Board: " + tstBRD.toString());
        int[] replace = {replace1,replace2};
        Arrays.sort(replace);
        for(int i = 1; i >= 0; i--) {
            REPLAY.enqueue("Removed: "+ tstBRD.getEntry(replace[i]).toString());
            if (tstDCK.getLength() > 0) {
                tstBRD.replace(replace[i], dealCard());
            }
            else {
                tstBRD.remove(replace[i]);
            }
        }
    }

    private void testReplaceCards(int replace1, int replace2, int replace3)
    {
        REPLAY.enqueue("Board: " + tstBRD.toString());
        int[] replace = {replace1,replace2,replace3};
        Arrays.sort(replace);
        for(int i = 2; i >=0; i--) {
            REPLAY.enqueue("Removed: "+ tstBRD.getEntry(replace[i]).toString());
            if (tstDCK.getLength() > 0) {
                tstBRD.replace(replace[i], dealCard());
            }
            else {
                tstBRD.remove(replace[i]);
            }
        }
    }
    private void testDisplayBoard(AListArray<Card> CHECK)
    {
        System.out.println("\n-----------Board-------------");
        for (int i = CHECK.getLength(); i > 0; i--)
        {
            System.out.println("Slot " + (i) + "  -  " + CHECK.getEntry(i));
        }
        System.out.println("-----------------------------");
        System.out.println(tstDCK.getLength() + " cards left in deck.");
        System.out.println("-----------------------------\n");
    }
}

