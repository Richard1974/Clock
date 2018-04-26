/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

/**
 *
 * @author coldw
 */



public interface PriorityQueue<T> {

    /**
     * Add the given item to the queue with the given priority. Throw an
     * exception if it's already full to capacity.
     *
     * @param item
     * @throws QueueOverflowException
     */
    public void add(T item) throws QueueOverflowException;

    /**
     * The highest priority item stored. Throw an exception if it's empty.
     *
     * @return The item with the highest priority
     * @throws QueueUnderflowException
     */
    public T head() throws QueueUnderflowException;

    /**
     * Remove the highest priority item from the queue. Throw an exception if
     * it's empty.
     *
     * @throws QueueUnderflowException
     */
    public void remove() throws QueueUnderflowException;

    /**
     * Is the queue empty?
     *
     * @return True if there are no items stored, otherwise False
     */
    public boolean isEmpty();

    @Override
    /**
     * A string representation of the entire queue.
     *
     * This should be formatted as a list, in square brackets.
     *
     * Each item should be shown as an ordered pair in parentheses together with
     * its priority.
     *
     * The items may be listed in any order. In particular there is no
     * requirement that the item returned by head() should be listed first.
     *
     * For example: [(Fred, 10), (Mabel, 15), (Jane, 5)]
     */
    public String toString();

    
}

