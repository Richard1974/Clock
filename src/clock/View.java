package clock;

import java.awt.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

/**
 * Creates the view that shows the clock, buttons and alarm panel
 * @author Richard Coldwell
 */
public class View implements Observer {
    
    ClockPanel panel;
    PriorityQueue<Date> q;
    AlarmPanel alarmPanel;
   
    /**
     *
     * @param model
     * @param q
     */
    public View(Model model, PriorityQueue<Date> q) {
        final JFrame frame = new JFrame();
        panel = new ClockPanel(model);
        alarmPanel = new AlarmPanel(q);
        frame.setTitle("Java Clock");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // checks that user is sure they want to save before exiting application
        frame.addWindowListener(new java.awt.event.WindowAdapter() 
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) 
            {
                if (JOptionPane.showConfirmDialog(frame, 
                    "Do You wish to close window or go back and save alarms first", "Close Check", 
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
                {
                    System.exit(0);
                }
            }
        });
        
        // Start of border layout code
        Container pane = frame.getContentPane();
        
        panel.setPreferredSize(new Dimension(300, 200));
        pane.add(panel, BorderLayout.PAGE_START);
        
        JButton alarmButton = new JButton("ADD ALARM");
        alarmButton.addActionListener(new AlarmButtonHandler(new AddAlarmDialog(frame, q, alarmPanel), frame, q));
        pane.add(alarmButton, BorderLayout.LINE_START);
                 
        JButton loadButton = new JButton("LOAD");
        loadButton.addActionListener(new LoadButtonHandler(frame, q, alarmPanel));
        pane.add(loadButton, BorderLayout.CENTER);
                 
        JButton saveButton = new JButton("SAVE");
        saveButton.addActionListener(new SaveButtonHandler(frame, q));
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
