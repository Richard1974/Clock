package clock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

//********************************************************
//**  AlarmPanel Class                                  **
//**  A panel for displaying a list of alarms           **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************

public class AlarmPanel extends JPanel
{
    PriorityQueue<Alarm> q;
    public AlarmPanel(PriorityQueue<Alarm> q)
    {
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        
        gc.gridx = 0;
        add(new JLabel ("Alarm"+ q.toString()), gc);
               
        

    }
    
}
