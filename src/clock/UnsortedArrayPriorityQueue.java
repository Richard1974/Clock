/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.util.Calendar;

/**
 *
 * @author coldw
 */
public class UnsortedArrayPriorityQueue<T>implements PriorityQueue<T> {
    
    /**
     * Where the data is actually stored.
     */
    private final Object[] storage;

    /**
     * The size of the storage array.
     */
    private final int capacity;

    /**
     * The index of the last item stored.
     *
     * This is equal to the item count minus one.
     */
    private int tailIndex;

    /**
     * Create a new empty queue of the given size.
     *
     * @param size
     */
    public UnsortedArrayPriorityQueue(int size) 
    {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
    
    
    @Override
    public T head() throws QueueUnderflowException 
    {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            // Finds the item in the array with the highest priority value
            Calendar highestPriority = (Calendar) ((PriorityItem<T>) storage[0]).getItem();
            int highestPriorityIndex = 0;
            for (int i = 0; i <= tailIndex; i++) {
                if (highestPriority.before((Calendar)((PriorityItem<T>) storage[i]).getItem()))
                {
                    highestPriority = (Calendar) ((PriorityItem<T>) storage[i]).getItem();
                    highestPriorityIndex = i;
                }
            }
            return ((PriorityItem<T>) storage[highestPriorityIndex]).getItem();
        }
    }

    @Override
    public void add(T item) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            storage[tailIndex] = new PriorityItem<>(item);
        }
    }
    
    @Override
    public void remove() throws QueueUnderflowException {
        
      /*  if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            // Finds the item in the array with the highest priority value
            int highestPriority = ((PriorityItem<T>) storage[0]).getPriority();
            int highestPriorityIndex = 0;
            for (int i = 0; i <= tailIndex; i++) {
                if (((PriorityItem<T>) storage[i]).getPriority() > highestPriority)
                {
                    highestPriority = ((PriorityItem<T>) storage[i]).getPriority();
                    highestPriorityIndex = i;
                }
            }
            // starting at the point that the item was removed from it now shifts all items 
            // after this by 1 space to fill in the gap
            int i = highestPriorityIndex;
            while (i<tailIndex){
            
                storage[i] = storage[i + 1];
                i = i + 1;
            }
            tailIndex = tailIndex - 1;
        }*/
    }
    
    @Override
    public boolean isEmpty() {
        return tailIndex < 0;
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "]";
        return result;
    }
}
