/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author coldw
 * @param <Date>
 */
public class SortedArrayPriorityQueue<T>implements PriorityQueue<Date> {
    
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
    public SortedArrayPriorityQueue(int size) 
    {
        storage = new Object[size];
        capacity = size;
        tailIndex = -1;
    }
    
    
    @Override
    public Date head() throws QueueUnderflowException 
    {
        if (isEmpty()) {
            throw new QueueUnderflowException();
        } else {
            
            return ((PriorityItem<T>) storage[0]).getAlarm();
            
        }
    }

    @Override
    public void add(Date alarm) throws QueueOverflowException {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) {
            /* No resizing implemented, but that would be a good enhancement. */
            tailIndex = tailIndex - 1;
            throw new QueueOverflowException();
        } else {
            /* Scan backwards looking for insertion point */
            int i = tailIndex;
            
            
           
            while (i > 0 && checkDate(i,  DateConvert (storage[i - 1]), alarm )) 
            {
               
                storage[i] = storage[i - 1];
                i = i - 1;
                
            }
            storage[i] = new PriorityItem<>(alarm);
            System.out.println("storage[0] = " + storage[0]);
           
            }
          
    }
    
   
        public Date DateConvert(Object date)
        {
            
           
            
            
            
            Date dateFormatted = null;
            String stringDate = date.toString();
            System.out.println("stringDate= " + stringDate);
            
            //             EEE MMM dd HH:mm:ss z yyyy
            //stringDate = "Thu May 10 11:30:28 BST 2018";
            SimpleDateFormat formatter = new SimpleDateFormat("(EEE MMM dd HH:mm:ss zzz yyyy)");
        

        try {

            dateFormatted = formatter.parse(stringDate);
            System.out.println(dateFormatted);
            
            } 
        catch (ParseException e)
            {
                e.printStackTrace();
            }
            
            
          
            return dateFormatted;
        }
    
        public boolean checkDate (int i, Date oldDate, Date newDate)
        {

            if (oldDate.after(newDate))
            {
                return true;
            }

            else
            {
                return false;
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
