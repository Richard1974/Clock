
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SpinnerDateModel;



//********************************************************


//**  Add Alarm Button Handler                          **
//**  used to handle interactions with ADD ALARM button **
//**  @author Richard Coldwell                          **
//**  27th April 2018                                   **
//********************************************************

public class AddAlarmButtonHandler implements ActionListener{
    
    
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
        
        
        
    }
}
