package clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;


 //**********************************************************
//**  Delete Alarm Button Handler                          **
//**  used to handle interactions with DELETE ALARM button **
//**  @author Richard Coldwell                             **
//**  12th May 2018                                        **
//***********************************************************

public class DeleteButtonHandler implements ActionListener{
    
    PriorityQueue<Date> queue;
    AlarmPanel alarmPanel;
    int alarmNumber;

    public DeleteButtonHandler(PriorityQueue<Date> q, AlarmPanel panel, int number) {
        queue = q;
        alarmPanel = panel;
        alarmNumber = number;
    }
    
     public void actionPerformed(ActionEvent event)
     {
         //System.out.println("DELETE Button Pressed" + alarmNumber);
         queue.removeSelected(alarmNumber);
         alarmPanel.update(queue);
    }
     
     
     
}