package clock;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
//********************************************************
//**  AddAlarmDialog                                    **
//**  A Dialog for entering alarm details               **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************
public class AddAlarmDialog extends JDialog{   
    
    private JButton addButton;
   // private JButton cancelButton;
    private JSpinner alarmEntrySpinner;
    private SpinnerDateModel alarmEntryModel;
    PriorityQueue<Date> q;
    AlarmPanel alarmPanel;
    
    
    
    public AddAlarmDialog(JFrame parent, PriorityQueue<Date> q)
    {
        super(parent, "Add Alarm", true);
         //q = new SortedArrayPriorityQueue<>(8);
        addButton = new JButton("Add");
       // cancelButton = new JButton("Cancel");
        alarmEntryModel = new SpinnerDateModel();
        alarmEntrySpinner = new JSpinner(alarmEntryModel);
        
        
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        
        gc.gridx = 0;
        add(new JLabel ("Enter Alarm"), gc);
               
        gc.gridy ++;
        gc.gridx = 0;
        add(alarmEntrySpinner, gc );
        
        gc.gridy ++;
        addButton.addActionListener(new AddAlarmButtonHandler(q,  alarmEntryModel));
        add(addButton, gc);
        
        
        
        
        setSize(200,200);
        
              
    }

   

    
}