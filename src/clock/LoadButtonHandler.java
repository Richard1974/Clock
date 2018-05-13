package clock;

import java.awt.event.*;
import java.io.File;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

//********************************************************
//**  Load Button Handler                               **
//**  used to handle interactions with LOAD button      **
//**  @author Richard Coldwell                          **
//**  18th April 2018                                   **
//********************************************************

public class LoadButtonHandler implements ActionListener
{
    
    private JFrame parent;
     PriorityQueue<Date> queue;
     ICalendarLoader iCalendarLoader;
    
    public LoadButtonHandler(JFrame j, PriorityQueue<Date> q) 
    {
        
        parent = j;
        queue = q;
    }
    
    
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Load Button Pressed");
        
         JFileChooser fileChooser = new JFileChooser();
        
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(parent);
        
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            iCalendarLoader = new ICalendarLoader(queue, selectedFile.getAbsolutePath());
        }
    }
}

