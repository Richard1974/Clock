package clock;

import java.awt.event.*;

//********************************************************
//**  Alarm Button Handler                              **
//**  used to handle interactions with ALARM button     **
//**  @author Richard Coldwell                          **
//**  17th April 2018                                   **
//********************************************************

public class AlarmButtonHandler implements ActionListener{
    
     private AddAlarmDialog dialog;
    
    
    public AlarmButtonHandler(AddAlarmDialog d) 
    {
        dialog = d;
        dialog.setVisible(false);
    }

   
    
     public void actionPerformed(ActionEvent event){
         System.out.println("Alarm Button Pressed");
         dialog.setVisible(true);
    }
}
