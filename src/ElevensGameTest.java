public class ElevensGameTest extends ElevensGame
{
    private static int winCounter = 0;
    private static int lossCounter = 0;

    private void testElevensSimulation(int range) {
        for(int i = 0; i < range; i++){
            while (getBoardLength() > 0) {
                AListArray<Integer> SELECTION = checkPossibleMoves(BOARD);
                if (checkPossibleMoves(BOARD).isEmpty()) {
                    newBoard();
                    lossCounter++;
                    break;
                } else if (checkPossibleMoves(BOARD).getLength() < 3) {
                    if (getBoardEntry(SELECTION.getEntry(1)).equalEleven(getBoardEntry(SELECTION.getEntry(2))) == 1) {
                        replaceCards(SELECTION.getEntry(1), SELECTION.getEntry(2));
                    }
                } else {
                    if (getBoardEntry(SELECTION.getEntry(1)).equalJQK(getBoardEntry(SELECTION.getEntry(2)),
                            getBoardEntry(SELECTION.getEntry(3))) == 1) {
                        replaceCards(SELECTION.getEntry(1), SELECTION.getEntry(2), SELECTION.getEntry(3));
                    }
                }
            }
            if (getBoardLength() == 0)
                {
                winCounter++;
                }
            newBoard();
        }
    }

    public static void main(String[] args)
    {
        long startTime, endTime;
        ElevensGameTest testElevens = new ElevensGameTest();

        System.out.println("Test 10 Elevens games.");
        startTime = System.nanoTime();
        testElevens.testElevensSimulation(10);
        endTime = System.nanoTime();
        System.out.println("Total games played were: " + (winCounter + lossCounter));
        System.out.println("Total wins were: " + winCounter);
        System.out.println("Total losses were: " + lossCounter);
        System.out.println("Time taken to play games: " + (endTime - startTime)+ " nanoseconds");
        winCounter = 0; lossCounter = 0;

        System.out.println("\nTest 100 Elevens games.");
        startTime = System.nanoTime();
        testElevens.testElevensSimulation(100);
        endTime = System.nanoTime();
        System.out.println("Total games played were: " + (winCounter + lossCounter));
        System.out.println("Total wins were: " + winCounter);
        System.out.println("Total losses were: " + lossCounter);
        System.out.println("Time taken to play games: " + (endTime - startTime)+ " nanoseconds");
        winCounter = 0; lossCounter = 0;

        System.out.println("\nTest 1000 Elevens games.");
        startTime = System.nanoTime();
        testElevens.testElevensSimulation(1000);
        endTime = System.nanoTime();
        System.out.println("Total games played were: " + (winCounter + lossCounter));
        System.out.println("Total wins were: " + winCounter);
        System.out.println("Total losses were: " + lossCounter);
        System.out.println("Time taken to play games: " + (endTime - startTime)+ " nanoseconds");
        winCounter = 0; lossCounter = 0;

        System.out.println("\nTest 10000 Elevens games.");
        startTime = System.nanoTime();
        testElevens.testElevensSimulation(10000);
        endTime = System.nanoTime();
        System.out.println("Total games played were: " + (winCounter + lossCounter));
        System.out.println("Total wins were: " + winCounter);
        System.out.println("Total losses were: " + lossCounter);
        System.out.println("Time taken to play games: " + (endTime - startTime)+ " nanoseconds");
        winCounter = 0; lossCounter = 0;

        System.out.println("\nTest 100000 Elevens games.");
        startTime = System.nanoTime();
        testElevens.testElevensSimulation(100000);
        endTime = System.nanoTime();
        System.out.println("Total games played were: " + (winCounter + lossCounter));
        System.out.println("Total wins were: " + winCounter);
        System.out.println("Total losses were: " + lossCounter);
        System.out.println("Time taken to play games: " + (endTime - startTime)+ " nanoseconds");
    }
}
