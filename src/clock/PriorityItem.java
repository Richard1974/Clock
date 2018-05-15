
package clock;

import java.util.Date;


/**
 * A wrapper for bundling up an item 
 * 
 * @param <T>
 */
public class PriorityItem<T> {

    private Date alarm;
    
    /**
     * 
     * @param alarm
     */
    public PriorityItem(Date alarm) 
    {
        this.alarm = alarm;
    }
  
    /**
     *
     * @return
     */
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
