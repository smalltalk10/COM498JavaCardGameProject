import java.util.Scanner;

public interface QueueInterface<T>
{
    public void enqueue(T newEntry);
    /* add new entry to the back of the queue

     */

    public T dequeue();
    /*remove entry from the front of the queue

     */

    public T getFront();
    /*return, but don't remove entry from the front of the queue

     */

    public boolean isEmpty();
    /*return true if queue is empty, otherwise false

     */

    public void clear();
    /* remove all entries from the queue
     */

}