
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SpinnerDateModel;



//********************************************************


//**  Add Alarm Button Handler                          **
//**  used to handle interactions with ADD ALARM button **
//**  @author Richard Coldwell                          **
//**  27th April 2018                                   **
//********************************************************

public class AddAlarmButtonHandler implements ActionListener {
    
    
    PriorityQueue<Date> queue;
    
    private SpinnerDateModel newAlarm;
    
    
   public AddAlarmButtonHandler(PriorityQueue<Date> q, SpinnerDateModel enteredAlarm) 
    {
        queue = q;
        
        newAlarm = enteredAlarm;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Date date = (Date) newAlarm.getValue(); 
         
        try{
            queue.add(date);
            System.out.println("alarm list is now = " + queue.toString());
            
            } catch (QueueOverflowException ex) 
            {
                System.out.println("Add operation failed: " + ex);
            }
          
    }
}
