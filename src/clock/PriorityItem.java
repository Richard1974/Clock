
package clock;

import java.util.Date;


/**
 * A wrapper for bundling up an item 
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private Date alarm;
    
    public PriorityItem(Date alarm) 
    {
        this.alarm = alarm;
    }
  
    public Date getAlarm() 
    {
        return alarm;
    }
    
    @Override
    public String toString() 
    {
        return "(" + getAlarm() + ")";
    }
}
