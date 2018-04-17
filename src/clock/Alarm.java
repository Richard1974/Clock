package clock;

import java.util.Calendar;
//********************************************************
//**  Alarm Class                                       **
//**  alarm object used to store details of the alarm   **
//**  @author Richard Coldwell                          **
//**  17th April 2018                                   **
//********************************************************

public class Alarm 
{
    Calendar alarm;
    
    public Alarm(Calendar alarm)
    {
        this.alarm = alarm;
    }

    public Calendar getAlarm() {
        return alarm;
    }

    @Override
    public String toString() {
        return getAlarm().toString();
    }
}
