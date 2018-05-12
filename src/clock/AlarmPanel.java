package clock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Date;
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
    PriorityQueue<Date> q;
    public AlarmPanel(PriorityQueue<Date> q)
    {
        update(q);
    }
       
    
    public void fireTableDataChanged()
    {
        setLayout(new GridLayout(0, 3));
    
                
   
                }
    
    
    
    
    public void update(PriorityQueue<Date> q) 
    {
        if (q.isEmpty())
        {
            System.out.println("queue Is Empty !!!!");
             
            this.removeAll();
            setLayout(new GridBagLayout());
        
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridy = 0;
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 0;
            
            add(new JLabel ("NO ALARMS SET YET!"), gc);  
        }
        else
        {
            System.out.println("Not Empty Now !!!!");
            
            this.removeAll();
            setLayout(new GridBagLayout());
        
            GridBagConstraints gc = new GridBagConstraints();
            gc.gridy = 0;
            gc.weightx = 1;
            gc.weighty = 1;
            gc.fill = GridBagConstraints.NONE;

            gc.gridx = 0;
            
            add(new JLabel ("Alarm"+ q.toString()), gc);
        }
        
        this.revalidate();
        this.repaint();
    }   
}
    
    

