package clock;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JSpinner;
//********************************************************
//**  AddAlarmDialog                                    **
//**  A Dialog for entering alarm details               **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************
public class AddAlarmDialog extends JDialog{   
    
    private JButton addButton;
    private JButton cancelButton;
    private JSpinner hour;
    private JSpinner minute;
    
    
    
    public AddAlarmDialog(JFrame parent)
    {
        super(parent, "Add Alarm", true);
        addButton = new JButton("Add");
        cancelButton = new JButton("Cancel");
        
        
        setSize(200,200);
        
    }

    
}
