package clock;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

public class Controller {
    
    ActionListener listener;
    Timer timer;
    
    Model model;
    View view;
    PriorityQueue<Date> queue;
    
    Date firstAlarm;
    Date dateNow;
    
    public Controller(Model m, View v, PriorityQueue<Date> q) {
        model = m;
        view = v;
        queue = q;
        
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.update();
                checkAlarms();
            }
        };
        
        timer = new Timer(100, listener);
        timer.start();
    }
    
    //** Checks if current time is same as alarm time
    public void checkAlarms()
    {
        //if alarms are in the queue then need to check if alarm is going to go off
                if (!queue.isEmpty())
                {
                    //Get The Current date and Time to for comparison
                    DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                    dateNow = new Date();
                    try {
                        dateNow = dateFormat.parse(dateFormat.format(new Date()));
                    } catch (ParseException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String currentDateTimeString = dateFormat.format(dateNow);
                    System.out.println("currentDateTimeString = " + currentDateTimeString);
                    
                    //Get the first alarm in the queue 
                    firstAlarm = new Date();
                    try {
                        firstAlarm = queue.head();
                    } catch (QueueUnderflowException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("first alarm = " + firstAlarm);
                  
                    //compare the alarm with current time
                    if ( dateNow.compareTo(firstAlarm) == 0)
                    {
                       System.out.println("ALARM ALARM ALARM: " + dateNow + firstAlarm);
                       queue.removeSelected(0);
                       view.alarmPanel.update(queue);
                    }
                }
    }
            
}