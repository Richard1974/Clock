package clock;


import javax.swing.JDialog;
import javax.swing.JFrame;
//********************************************************
//**  AddAlarmDialog                                    **
//**  A Dialog for entering alarm details               **
//**  @author Richard Coldwell                          **
//**  19th April 2018                                   **
//********************************************************
public class AddAlarmDialog extends JDialog{    
    public AddAlarmDialog(JFrame parent)
    {
        super(parent, "Add Alarm", false);
        
        
        setSize(200,200);
    }

    
}
