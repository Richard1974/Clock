package clock;

import java.awt.event.*;
import javax.swing.JFileChooser;
import java.io.File;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Save Button Handler 
 * used to handle interactions with SAVE button
 * @author Richard Coldwell
 * 18th April 2018 
 */

public class SaveButtonHandler implements ActionListener
{
     
     private JFrame parent;
     PriorityQueue<Date> queue;
     ICalendarBuilder iCalendarBuilder;
    
    /**
     *
     * @param j
     * @param q
     */
    public SaveButtonHandler(JFrame j, PriorityQueue<Date> q) 
    {
        parent = j;
        queue = q;
    }
    
    
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Save Button Pressed");
  
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");    

        int userSelection = fileChooser.showSaveDialog(parent);

        if (userSelection == JFileChooser.APPROVE_OPTION) 
        {
            // opens file chooser for user to choose save location and filename
            File fileToSave = fileChooser.getSelectedFile();
            // calls iCalendar builder and passes queue and the file save path
            iCalendarBuilder = new ICalendarBuilder(queue, fileToSave.getAbsolutePath());
        }
    }
}

