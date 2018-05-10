package clock;

import java.util.Date;
import javax.swing.JPanel;

//********************************************************
//**  AlarmPanel Class                                  **
//**  A panel for displaying a list of alarms           **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************

public class AlarmPanel extends JPanel
{
    PriorityQueue<Date> q;
    public AlarmPanel(PriorityQueue<Date> q)
    {
        update(q);
    }
          
    public void update(PriorityQueue<Date> q) 
    {
        if (q.isEmpty())
        {
             System.out.println("queue Is Empty !!!!");
             //TODO display message saying no alarms in queue
        }
        else
        {
         System.out.println("Not Empty Now !!!!");
             //TODO display list of alarms with buttons to delete alarm
        }
    }   
}
    
    

