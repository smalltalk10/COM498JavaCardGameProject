import java.util.Arrays;
import java.util.Scanner;

/**
 * This class holds the Board functionality of the card game such as
 * the BOARD listArray and methods to manipulate the Cards in BOARD.
 * It also contains the Replay Queue functionality.
 */

public class Board
{
    protected Deck deck;
    protected final AListArray<Card> BOARD = new AListArray<Card>();
    private final Queue<String> REPLAY = new Queue<String>();
    private static final int BOARDNUMCARDS = 9;

    public Board()
    { //
        deck = new Deck();
        for (int i = 0; i < BOARDNUMCARDS; i++) {
            BOARD.add(deck.deal());
        }
    }

    public void newBoard()
    {
        BOARD.clear();
        REPLAY.clear();
        this.deck = new Deck();
        for (int i = 0; i < BOARDNUMCARDS; i++) {
            BOARD.add(this.deck.deal());
        }
    }

    public int getBoardLength() // returns length of board
    {
        return BOARD.getLength();
    }

    public Card getBoardEntry(int index) // returns specific card entry from board
    {
        return BOARD.getEntry(index);
    }


    protected void displayBoard(AListArray<Card> CHECK)
    {
        System.out.println("\n-----------Board-------------");
        for (int i = CHECK.getLength(); i > 0; i--)
            {
            System.out.println("Slot " + (i) + "  -  " +CHECK.getEntry(i));
            }
        System.out.println("-----------------------------");
        System.out.println(deck.getDeckLength() + " cards left in deck.");
        System.out.println("-----------------------------\n");
    }

    protected void replaceCards(int replace1, int replace2)
    {
        REPLAY.enqueue("Board: " + BOARD.toString());
        int[] replace = {replace1,replace2};
        Arrays.sort(replace);
        for(int i = 1; i >= 0; i--) {
            REPLAY.enqueue("Removed: "+ BOARD.getEntry(replace[i]).toString());
            if (deck.getDeckLength() > 0) {
                BOARD.replace(replace[i], deck.deal());
            }
            else {
                BOARD.remove(replace[i]);
            }
        }

    }

    protected void replaceCards(int replace1, int replace2, int replace3)
    {
        REPLAY.enqueue("Board: " + BOARD.toString());
        int[] replace = {replace1,replace2,replace3};
        Arrays.sort(replace);
        for(int i = 2; i >=0; i--) {
            REPLAY.enqueue("Removed: "+ BOARD.getEntry(replace[i]).toString());
            if (deck.getDeckLength() > 0) {
                BOARD.replace(replace[i], deck.deal());
            }
            else {
                BOARD.remove(replace[i]);
            }
        }
    }

    protected AListArray<Integer> checkPossibleMoves(AListArray<Card> CHECK)
    {
        AListArray<Integer> HINT = new AListArray<Integer>();
        for(int i = 1; i <= CHECK.getLength(); i++) {
            for (int j = i + 1; j <= CHECK.getLength(); j++) {
                if (CHECK.getEntry(i).equalEleven(CHECK.getEntry(j)) == 1) {
                    HINT.add(i);
                    HINT.add(j);
                    return HINT;
                }
            }
        }
        int jack = 0, queen = 0, king = 0;
        for(int i = 1; i <= CHECK.getLength(); i++) {
            if(CHECK.getEntry(i).getRankValue() == 11) {
                jack = i;
            }
            if(CHECK.getEntry(i).getRankValue() == 12) {
                queen = i;
            }
            if(CHECK.getEntry(i).getRankValue() == 13) {
                king = i;
            }
        }
        if(jack > 0 && queen > 0 && king > 0) {
            HINT.add(jack);
            HINT.add(queen);
            HINT.add(king);
            return HINT;
        }
        return HINT;
    }

    protected void replaySteps() // Reads user input and increments through replay steps where possible
    {
        Scanner scan = new Scanner(System.in);
        String enterkey = "Press 'Enter' key to increment through replay moves.";
        while(!REPLAY.isEmpty()) { // While the replay queue is not empty
            System.out.print(enterkey);
            enterkey = scan.nextLine();
            System.out.print(enterkey);
            if(enterkey.equals("")) {
                System.out.println(REPLAY.dequeue());
            }
            if(REPLAY.getFront().charAt(0) == 'B') {
                System.out.println(REPLAY.dequeue());
            }
            while(!REPLAY.isEmpty() && REPLAY.getFront().charAt(0) == 'R') {
                System.out.println(REPLAY.dequeue());
            }
        }
        System.out.println("\nNo moves left to replay.");
    }
}
