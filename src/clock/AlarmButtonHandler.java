package clock;

import java.awt.event.*;
import java.util.Calendar;
import javax.swing.JFrame;

//********************************************************
//**  Alarm Button Handler                              **
//**  used to handle interactions with ALARM button     **
//**  @author Richard Coldwell                          **
//**  17th April 2018                                   **
//********************************************************

public class AlarmButtonHandler implements ActionListener{
    
     private AddAlarmDialog dialog;
     private JFrame parent;
     PriorityQueue<Alarm> queue;
    
    public AlarmButtonHandler(AddAlarmDialog d, JFrame j, PriorityQueue<Alarm> q) 
    {
        dialog = d;
        dialog.setVisible(false);
        parent = j;
        queue = q;
    }

   
    
     public void actionPerformed(ActionEvent event){
         System.out.println("Alarm Button Pressed");
         dialog.setLocationRelativeTo(parent);
         dialog.setVisible(true);
         dialog.q = queue;
         
        
    }
}
