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
    public void setDate(int day, int month, int year)
    {
        alarm.set(Calendar.DAY_OF_MONTH, day);
        alarm.set(Calendar.MONTH, month);
        alarm.set(Calendar.YEAR, year);
    }
    
    public void setTime(int hour, int minute)
    {
        int second = 0;
        alarm.set(Calendar.HOUR_OF_DAY, hour);
        alarm.set(Calendar.MINUTE, minute);
        alarm.set(Calendar.SECOND, second);
        
        
        /*
        hour = date.get(Calendar.HOUR);
        minute = date.get(Calendar.MINUTE);
        oldSecond = second;
        second = date.get(Calendar.SECOND);
        */
    }
}
