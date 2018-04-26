package clock;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
//********************************************************
//**  AddAlarmDialog                                    **
//**  A Dialog for entering alarm details               **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************
public class AddAlarmDialog extends JDialog{   
    
    private JButton addButton;
    private JButton cancelButton;
    private JSpinner hourSpinner;
    private SpinnerNumberModel hourModel;
    private JSpinner minuteSpinner;
    private SpinnerNumberModel minuteModel;
    
    
    
    public AddAlarmDialog(JFrame parent)
    {
        super(parent, "Add Alarm", true);
        
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        hourModel = new SpinnerNumberModel(1, 1, 12, 1);
        hourSpinner = new JSpinner(hourModel);
        minuteModel = new SpinnerNumberModel(0, 0, 59, 1);
        minuteSpinner = new JSpinner(minuteModel);
        
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.NONE;
        
        gc.gridx = 0;
        add(new JLabel ("Hours"), gc);
        gc.gridx ++;
        add(new JLabel ("Minutes"), gc);
       
        gc.gridy ++;
        gc.gridx = 0;
        add(hourSpinner, gc );
        gc.gridx ++;
        add(minuteSpinner, gc );
        
        setSize(200,200);
        
       
        
    }

    
}