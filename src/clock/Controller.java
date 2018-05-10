package clock;

import java.awt.event.*;
import java.util.Date;
import javax.swing.Timer;

public class Controller {
    
    ActionListener listener;
    Timer timer;
    
    Model model;
    View view;
    PriorityQueue<Date> queue;
    
    public Controller(Model m, View v, PriorityQueue<Date> q) {
        model = m;
        view = v;
        queue = q;
        
        listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                model.update();
                view.alarmPanel.update(queue);
               }
        };
        
        timer = new Timer(100, listener);
        timer.start();
    }
}