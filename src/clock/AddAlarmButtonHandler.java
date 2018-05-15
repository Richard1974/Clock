
package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.SpinnerDateModel;

/**
 * Add Alarm Button Handler   
 * used to handle interactions with ADD ALARM button
 * @author Richard Coldwell
 * 27th April 2018
 */

public class AddAlarmButtonHandler implements ActionListener 
{
    PriorityQueue<Date> queue;
    private SpinnerDateModel newAlarm;
    AlarmPanel alarmPanel;
    AddAlarmDialog addAlarmDialog;
    
    /**
     *
     * @param q
     * @param enteredAlarm
     * @param panel
     * @param dialog
     */
    public AddAlarmButtonHandler(PriorityQueue<Date> q, SpinnerDateModel enteredAlarm, AlarmPanel panel, AddAlarmDialog dialog) 
    {
        queue = q;
        newAlarm = enteredAlarm;
        alarmPanel = panel;
        addAlarmDialog = dialog;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // gets the entered alarm and stores it in a Date object
        Date date = (Date) newAlarm.getValue(); 
         
        // adds date to the queue
        try
        {
            queue.add(date); // adds alarm to queue
            alarmPanel.update(queue);// updates panel with new alarm
        } 
        catch (QueueOverflowException ex) 
        {
            System.out.println("Add operation failed: " + ex);
        }
            addAlarmDialog.setVisible(false);
    }
}
