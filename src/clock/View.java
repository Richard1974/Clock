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
        
        JButton button = new JButton("LOAD");
        pane.add(button, BorderLayout.CENTER);
                 
        button = new JButton("ALARMS");
        pane.add(button, BorderLayout.LINE_START);
        
         
        button = new JButton("SAVE");
        pane.add(button, BorderLayout.LINE_END);
        
        button = new JButton("TBA");
        pane.add(button, BorderLayout.PAGE_END);
        
        // End of borderlayout code
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void update(Observable o, Object arg) {
        panel.repaint();
    }
}
