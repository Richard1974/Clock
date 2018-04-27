package clock;

import java.awt.event.*;
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
    
    
    public AlarmButtonHandler(AddAlarmDialog d, JFrame j, PriorityQueue<Alarm> q) 
    {
        dialog = d;
        dialog.setVisible(false);
        parent = j;
    }

   
    
     public void actionPerformed(ActionEvent event){
         System.out.println("Alarm Button Pressed");
         dialog.setLocationRelativeTo(parent);
         dialog.setVisible(true);
    }
}
