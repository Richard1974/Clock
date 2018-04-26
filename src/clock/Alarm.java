package clock;

import java.util.Calendar;
import java.util.Date;
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
        return getAlarm().getTime().toString();
    }
    public void setDate(Date date)
    {
            alarm.setTime(date);
    }
    
    public void setTime(int hour, int minute)
    {
        alarm.set(Calendar.HOUR_OF_DAY, hour);
        alarm.set(Calendar.MINUTE, minute);
    }
}
