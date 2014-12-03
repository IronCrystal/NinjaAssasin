package cs2114.ninjaassassin.queue;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Elliott
 * @version Dec 3, 2014
 */

public class Queue<E>
{
    // -------------------------------------------------------------------------
    /**
     * Write a one-sentence summary of your class here. Follow it with
     * additional details about its purpose, what abstraction it represents, and
     * how to use it.
     *
     * @author Elliott
     * @version Dec 3, 2014
     */

    private static class Node<E>
    {
        private E       data;
        private Node<E> next;


        // ----------------------------------------------------------
        /**
         * Create a new Node object.
         *
         * @param data
         *            The data stored by the node
         */
        public Node(E data)
        {
            this.data = data;
            next = null;
        }

    }

    private Node<E> front;
    private Node<E> rear;
    private int     size;


    // ----------------------------------------------------------
    /**
     * Create a new Queue object.
     */
    public Queue()
    {
        size = 0;
    }


    // ----------------------------------------------------------
    /**
     * Insert an item at the rear of the queue. post: item is added to the rear
     * of the queue.
     *
     * @param item
     *            The element to add
     * @return true (always successful)
     */
    public boolean offer(E item)
    {
        if (front == null)
        {
            rear = new Node<E>(item);
            front = rear;
        }
        else
        {
            rear.next = new Node<E>(item);
            rear = rear.next;
        }
        size++;
        return true;
    }


    // ----------------------------------------------------------
    /**
     * Remove the entry at the front of the queue and return it if the queue is
     * not empty. post: front references item that was second in the queue.
     *
     * @return The item removed if successful, or null if not
     */
    public E poll()
    {
        E item = peek();
        if (item == null)
        {
            return null;
        }
        front = front.next;
        size--;
        return item;
    }


    // ----------------------------------------------------------
    /**
     * Return the item at the front of the queue without removing it.
     *
     * @return The item at the front of the queue if successful; return null if
     *         the queue is empty
     */
    public E peek()
    {
        if (size == 0)
        {
            return null;
        }
        else
        {
            return front.data;
        }
    }


    // ----------------------------------------------------------
    /**
     * Determines whether or not the queue is empty.
     *
     * @return true If the queue is empty
     */
    public boolean isEmpty()
    {
        return front == null;
    }
}
