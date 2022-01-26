public class linkNode<T>
{
    private T data;
    private linkNode<T> next;

    public linkNode(T dataValue)
    {
        data = dataValue;
        next = null;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T dataValue)
    {
        data = dataValue;
    }

    public void setNext(linkNode<T> nextNode)
    {
        next = nextNode;
    }

    public linkNode<T> getNext()
    {
        return next;
    }

    public static void main(String[] args)
    {
        linkNode<Integer> node1 = new linkNode<Integer>(1);
        linkNode<Integer> node2 = new linkNode<Integer>(2);
        linkNode<Integer> node3 = new linkNode<Integer>(3);

        node1.setNext(node2);
        node2.setNext(node3);

        System.out.println("Value of node1 is " + node1.getData());
        System.out.println("Value of node2 is " + node1.getNext().getData());
        System.out.println("Value of node3 is " + node1.getNext().getNext().getData());
    }
}