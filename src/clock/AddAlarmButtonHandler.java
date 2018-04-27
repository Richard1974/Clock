
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
    
    
    PriorityQueue<Alarm> queue;
    //Date newAlarm;
    private SpinnerDateModel newAlarm;
    
    
 
   public AddAlarmButtonHandler(PriorityQueue<Alarm> q, SpinnerDateModel enteredAlarm) 
    {
        queue = q;
        
        newAlarm = enteredAlarm;
        
         
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        System.out.println("Add Alarm Button Pressed"); 
        System.out.println("new Alarm = " + newAlarm.getDate());
        Alarm alarm = new Alarm(Calendar.getInstance());
        alarm.setDate(newAlarm.getDate());
        System.out.println("new alarm object before saving = " + alarm);
        try {
            queue.add(alarm);
            } catch (QueueOverflowException ex) 
            {
                System.out.println("Add operation failed: " + ex);
            }
          
    }
}
