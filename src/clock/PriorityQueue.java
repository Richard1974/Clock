package clock;

/**
 * Priority Queue
 * used to store the queue of alarms 
 * @author Richard Coldwell
 * 18th April 2018
 * @param <Date>
 */

public interface PriorityQueue<Date> {

    /**
     * Add the given item to the queue with the given priority. Throw an
     * exception if it's already full to capacity.
     *
     * @param alarm
     * @throws QueueOverflowException
     */
    public void add(Date alarm) throws QueueOverflowException;

    /**
     * The highest priority item stored. Throw an exception if it's empty.
     *
     * @return The item with the highest priority
     * @throws QueueUnderflowException
     */
    public Date head() throws QueueUnderflowException;

    /**
     * Remove the highest priority item from the queue. Throw an exception if
     * it's empty.
     *
     * @throws QueueUnderflowException
     */
    public void remove() throws QueueUnderflowException;

    /**
     * Remove the chosen priority item from the queue. 
     * @param position
     */
    public void removeSelected(int position);
        
       
    /**
     * Is the queue empty?
     *
     * @return True if there are no items stored, otherwise False
     */
    
    
    
    public boolean isEmpty();

    /**
     *
     * @return
     */
    @Override
    /**
     * A string representation of the entire queue.
     *
     * The items may be listed in any order. In particular there is no
     * requirement that the item returned by head() should be listed first.
     *
     */
    public String toString();
    
    

    /**
     * Converts a date into the correct format for comparisons
     * @param date
     * @return
     */

    public Date DateConvert(Object date);
}

