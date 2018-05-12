package clock;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JButton;
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
       
    
//    public void fireTableDataChanged()
//    {
//        setLayout(new GridLayout(0, 3));
//    
//                }
    
    
    
    
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
            //Get allthe alarms from the priority queue and store in array
            String alarmList = q.toString();
            String[] alarms = alarmList.split(",");
            JButton[] buttons  = new JButton[alarms.length];
            
            this.removeAll();
            this.setBackground(Color.GRAY);
            GridBagLayout layout = new GridBagLayout();
            setLayout(layout); 
           
            GridBagConstraints gbc = new GridBagConstraints();

            for (int i = 0; i < alarms.length; i++)
            {
                gbc.gridy = i;
                gbc.gridx = 0;
                add(new JLabel (alarms[i]), gbc);
                
                //gbc.gridy = i;
                //gbc.gridx = 1;
                //add(new JButton("Delete Alarm " + i),gbc);
                
                JButton btn = new JButton("Delete " + i);
                buttons[i]  = btn;
                
                btn.addActionListener(new DeleteButtonHandler(q, this, i ));
                
                // add button to panel
                gbc.gridy = i;
                gbc.gridx = 1;
                add(btn, gbc);
                //System.out.println(buttons[i]);
                
                
                
            }                
        }
        
        this.revalidate();
        this.repaint();
        
        
        
        
    }   
    
    
    
}
    
    

