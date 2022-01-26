public class CardTest
{
    public static void main(String[] args)
    {
        // creates new Card objects
        Card one = new Card(0, 0);
        Card two = new Card(3, 2);
        Card three = new Card(9, 3);
        Card four = new Card(10, 1);
        Card five = new Card(11, 3);
        Card six = new Card(12, 0);
        try {
            Card seven = new Card(15, 0);
            System.out.println(seven.toString());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nArrayIndexOutOfBoundsException error caught.");
                System.out.println("Tried to create card with rank index 15 which is out of range.");
        }

        try {
            Card eight = new Card(9, -1);
            System.out.println(eight.toString());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nArrayIndexOutOfBoundsException error caught.");
            System.out.println("Tried to create card with suit index -1 which is out of range.\n");
        }


        // displays all information about each Card objects
        System.out.println("Properties of card one: " + one.toString());
        System.out.println("Point value of card one: " + one.getRankValue());
        System.out.println();

        System.out.println("Properties of card two: " + two.toString());
        System.out.println("Point value of card two: " + two.getRankValue());
        System.out.println();

        System.out.println("Properties of card three: " + three.toString());
        System.out.println("Point value of card three: " + three.getRankValue());
        System.out.println();

        System.out.println("Properties of card four: " + four.toString());
        System.out.println("Point value of card four: " + four.getRankValue());
        System.out.println();

        System.out.println("Properties of card five: " + five.toString());
        System.out.println("Point value of card five: " + five.getRankValue());
        System.out.println();

        System.out.println("Properties of card six: " + six.toString());
        System.out.println("Point value of card six: " + six.getRankValue());
        System.out.println();

        System.out.println("Does " + one.toString() + " and " + two.toString() + " equal eleven: " + one.equalEleven(two));
        System.out.println("Does " + one.toString() + " and " + three.toString() + " equal eleven: " + one.equalEleven(three));
        System.out.println("Does " + four.toString() + " and " + five.toString() + " equal eleven: " + four.equalEleven(five));
        System.out.println();

        System.out.println("Are the " + two.toString() + ", " + four.toString() + " and " + six.toString()
                + " a jack, queen, king combination: " + two.equalJQK(four, six));
        System.out.println("Are the " + three.toString() + ", " + six.toString() + " and " + six.toString()
                + " a jack, queen, king combination: " + three.equalJQK(six, six));
        System.out.println("Are the " + six.toString() + ", " + four.toString() + " and " + five.toString()
                + " a jack, queen, king combination: " + six.equalJQK(four, five));
    }
}