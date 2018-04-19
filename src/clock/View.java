package clock;

import java.awt.*;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class View implements Observer {
    
    ClockPanel panel;
    
    
    public View(Model model) {
        JFrame frame = new JFrame();
        panel = new ClockPanel(model);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Start of border layout code
        Container pane = frame.getContentPane();
        
        panel.setPreferredSize(new Dimension(200, 200));
        pane.add(panel, BorderLayout.PAGE_START);
        
        JButton alarmButton = new JButton("ADD ALARM");
        alarmButton.addActionListener(new AlarmButtonHandler(new AddAlarmDialog(frame), frame));
        pane.add(alarmButton, BorderLayout.LINE_START);
                 
        JButton loadButton = new JButton("LOAD");
        loadButton.addActionListener(new LoadButtonHandler());
        pane.add(loadButton, BorderLayout.CENTER);
                 
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new SaveButtonHandler());
        pane.add(saveButton, BorderLayout.LINE_END);
        
        JButton tbaButton = new JButton("TBA");
        pane.add(tbaButton, BorderLayout.PAGE_END);
        
        
        
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void update(Observable o, Object arg) 
    {
        panel.repaint();
    }
}
