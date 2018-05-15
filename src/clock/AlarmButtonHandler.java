package clock;

import java.awt.event.*;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Alarm Button Handler
 * used to handle interactions with ALARM button
 * @author Richard Coldwell
 * 17th April 2018 
 */

public class AlarmButtonHandler implements ActionListener{
    
     private AddAlarmDialog dialog;
     private JFrame parent;
     PriorityQueue<Date> queue;
    
    /**
     *
     * @param d
     * @param j
     * @param q
     */
    public AlarmButtonHandler(AddAlarmDialog d, JFrame j, PriorityQueue<Date> q) 
    {
        dialog = d;
        dialog.setVisible(false);
        parent = j;
        queue = q;
    }

    public void actionPerformed(ActionEvent event)
    {
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
        dialog.q = queue;
        System.out.println("alarm button handler q = " + dialog.q.toString());
    }
}
