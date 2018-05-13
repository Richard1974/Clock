package clock;

import java.awt.event.*;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    AlarmPanel alarmPanel;
    
    public LoadButtonHandler(JFrame j, PriorityQueue<Date> q, AlarmPanel panel) 
    {
        alarmPanel = panel;
        parent = j;
        queue = q;
    }
    
    public void actionPerformed(ActionEvent event)
    {
        // create a new file chooser
        JFileChooser fileChooser = new JFileChooser();
        // set directory that file chooser opens in
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        int result = fileChooser.showOpenDialog(parent);
        
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            //save the selected file
            File selectedFile = fileChooser.getSelectedFile();
            // load the ICalendar loader class passing the queue and path to the file
            iCalendarLoader = new ICalendarLoader(queue, selectedFile.getAbsolutePath());
            //update the alarm panel after completing load operation
            alarmPanel.update(queue);
        }
    }
}

