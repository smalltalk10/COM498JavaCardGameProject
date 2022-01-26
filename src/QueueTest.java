public class QueueTest
{
    public static void main(String[] args)
    {
        Queue<String> breakfast = new Queue<String>();

        System.out.println("Enqueueing Milk, Eggs, Bacon and Cheese");
        breakfast.enqueue("Milk");
        breakfast.enqueue("Eggs");
        breakfast.enqueue("Bacon");
        breakfast.enqueue("Cheese");

        System.out.println("\nPrint dequeue");
        System.out.println(breakfast.dequeue());

        System.out.println("\nPrint getFront");
        System.out.println(breakfast.getFront());

        System.out.println("\nDequeue and print getFront");
        breakfast.dequeue();
        System.out.println(breakfast.getFront());

        System.out.println("\nCheck if queue is empty");
        System.out.println(breakfast.isEmpty());

        System.out.println("\nAdd Bread to the queue");
        breakfast.enqueue("Bread");

        System.out.println("\nPrint dequeue of next 3 items");
        System.out.println(breakfast.dequeue());
        System.out.println(breakfast.dequeue());
        System.out.println(breakfast.dequeue());

        System.out.println("\nCheck if queue is empty");
        System.out.println(breakfast.isEmpty());
    }
}
