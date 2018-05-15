package clock;

import java.util.Calendar;
import java.util.Observable;
//import java.util.GregorianCalendar;

/**
 *
 * @author coldw
 */
public class Model extends Observable 
{    
    int hour = 0;
    int minute = 0;
    int second = 0;
    int oldSecond = 0;
    
    /**
     * model used to provide data for the updating of the clock panel
     * @author Richard Coldwell
     */
    public Model() 
    {
        update();
    }
    
    /**
     * Update method that does the updating
     */
    public void update() {
        Calendar date = Calendar.getInstance();
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);
        if (oldSecond != second) 
        {
            setChanged();
            notifyObservers();
        }
    }
}