package clock;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {
    
    ClockPanel panel;
    PriorityQueue<Date> q;
    AlarmPanel alarmPanel;
    
    public View(Model model, PriorityQueue<Date> q) {
        JFrame frame = new JFrame();
        panel = new ClockPanel(model);
        alarmPanel = new AlarmPanel(q);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Start of border layout code
        Container pane = frame.getContentPane();
        
        panel.setPreferredSize(new Dimension(300, 200));
        pane.add(panel, BorderLayout.PAGE_START);
        
        JButton alarmButton = new JButton("ADD ALARM");
        alarmButton.addActionListener(new AlarmButtonHandler(new AddAlarmDialog(frame, q, alarmPanel), frame, q));
        pane.add(alarmButton, BorderLayout.LINE_START);
                 
        JButton loadButton = new JButton("LOAD");
        loadButton.addActionListener(new LoadButtonHandler());
        pane.add(loadButton, BorderLayout.CENTER);
                 
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new SaveButtonHandler());
        pane.add(saveButton, BorderLayout.LINE_END);
                
        alarmPanel.setPreferredSize(new Dimension(200, 200));
        pane.add(alarmPanel, BorderLayout.PAGE_END);
        
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void update(Observable o, Object arg) 
    {
        panel.repaint();
    }
}
