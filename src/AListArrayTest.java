import java.util.Arrays;

public class AListArrayTest
{
    public static void main(String[] args)
    {
        AListArray<String> breakfast = new AListArray<>();

        System.out.println("Adding Milk, Eggs, Bacon and Cheese to the listArray");
        breakfast.add("Milk");
        breakfast.add("Eggs");
        breakfast.add("Bacon");
        breakfast.add("Cheese");

        System.out.println("\nPrinting list to string: " + breakfast.toString());
        System.out.println("Getting length of the list: " + breakfast.getLength());

        System.out.println("\nReplacing Bacon with Bread in the list");
        breakfast.replace(3, "Bread");
        System.out.println("Printing list to string: " + breakfast.toString());

        System.out.println("\nAdding sausages to the list in front of eggs.");
        breakfast.add(2, "Sausages");
        System.out.println("Printing list to an array: " + Arrays.toString(breakfast.toArray()));
        System.out.println("Getting length of the list: " + breakfast.getLength());
        System.out.println("Get entry 4 from list: " + breakfast.getEntry(4));

        System.out.println("\nRemove entry 2 and 4 from the list: " + breakfast.remove(2)
               + " & " + breakfast.remove(4));
        System.out.println("Printing list to string: " + breakfast.toString());
        System.out.println("Getting length of the list: " + breakfast.getLength());

        System.out.println("\nClearing list.");
        breakfast.clear();
        System.out.println("Check if list is empty: " + breakfast.isEmpty());
    }
}
