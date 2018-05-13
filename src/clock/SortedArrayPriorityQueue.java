package clock;

import static clock.Controller.infoBox;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//********************************************************
//**  Sorted Array Priority Queue                       **
//**  used to store the Date Objects in a sorte darray  **
//**  @author Richard Coldwell                          **
//**  18th April 2018                                   **
//********************************************************
public class SortedArrayPriorityQueue<T>implements PriorityQueue<Date> 
{
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
        if (isEmpty()) 
        {
            throw new QueueUnderflowException();
        } else 
        {
            return ((PriorityItem<T>) storage[0]).getAlarm();
        }
    }

    @Override
    public void add(Date alarm) throws QueueOverflowException 
    {
        tailIndex = tailIndex + 1;
        if (tailIndex >= capacity) 
        {
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
            // check if date of entered alarm is in the future, if so delete it and display dialog
            if(!CheckDateIsInFuture(DateConvert(storage[i])))
            {
                removeSelected(i);
                infoBox("The Alarm you entered was in the past so has not been added", "Add Alarm Warning");
            }
        } 
    }
    
    @Override
    public void remove() throws QueueUnderflowException 
    {
        if (isEmpty()) 
        {
            throw new QueueUnderflowException();
        } else 
        {
            for (int i = 0; i < tailIndex; i++) 
            {
                storage[i] = storage[i + 1];
            }
            tailIndex = tailIndex - 1;
        }
    }
    
    @Override
    public void removeSelected(int position)  
    {
        // starting at the point that the alarm is removed from it now shifts all alarms 
        // after this by 1 space to fill in the gap
        int i = position;
        while (i<tailIndex){

            storage[i] = storage[i + 1];
            i = i + 1;
        }
        tailIndex = tailIndex - 1;
    }
    
    @Override
    public boolean isEmpty() 
    {
        return tailIndex < 0;
    }

    @Override
    public String toString() 
    {
        String result = "";
        for (int i = 0; i <= tailIndex; i++) {
            if (i > 0) {
                result = result + ", ";
            }
            result = result + storage[i];
        }
        result = result + "";
        return result;
    }
    
    
    @Override
    //converts the Object Date into a Date that can be used for comparison
    public Date DateConvert(Object date)
    {
        Date dateFormatted = null;
        String stringDate = date.toString();
        System.out.println("stringDate= " + stringDate);

        SimpleDateFormat formatter = new SimpleDateFormat("(EEE MMM dd HH:mm:ss zzz yyyy)");
        try 
        {
            dateFormatted = formatter.parse(stringDate);
            System.out.println(dateFormatted);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return dateFormatted;
    }
    
    //check if the stored Date(oldDate) is after the newDate 
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
    
    public boolean CheckDateIsInFuture(Date alarm)
    {
        Date date = new Date();
        if (alarm.after(date))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
