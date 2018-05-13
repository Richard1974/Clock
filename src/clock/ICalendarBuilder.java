package clock;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//***********************************************************
//**  ICalendar builder                                    **
//**  used to build the ICalendar save file                **
//**  gets passed the queue and the path to save file to   **
//**  @author Richard Coldwell                             **
//**  13th May 2018                                        **
//***********************************************************
public class ICalendarBuilder {
    
    PriorityQueue<Date> queue;
    
    static final String NL = "\r\n";
    String beginVCal = "BEGIN:VCALENDAR";
    String version = "VERSION:2.0";
    String prodId = "PRODID:-//RichardColdwell//MyAlarmClock//EN";
    String beginVEvent = "BEGIN:VEVENT";
    String uid = "UID:uid1@example.com";
    String dtStamp = "DTSTAMP:19970714T170000Z";
    String dtStart = "DTSTART:19970714T170000Z";
    String beginVAlarm = "BEGIN:VALARM";
    String endVEvent = "END:VEVENT";
    String endVCal = "END:VCALENDAR";
     
    public ICalendarBuilder(PriorityQueue<Date> q, String saveFilePath)
    {
        queue = q;
        //date format for saving in iCalendar File
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
       
        //this creates a list of all the alarms in the list
        String alarmList = queue.toString();
        String[] alarms = alarmList.split(",");
       
        // creates the filename to save file as
        StringBuilder builder = new StringBuilder();
        builder.append(saveFilePath);
        builder.append(".ics");
        
        // builds the file
        try 
        {
            File file = new File(builder.toString());
            // if file doesnt exists, then create it
            if (!file.exists()) 
            {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(beginVCal+NL);
            bw.write(version+NL);
            bw.write(prodId+NL);
            bw.write(beginVEvent+NL);
            bw.write(uid+NL);
            bw.write(dtStamp+NL);
            bw.write(dtStart+NL);
            // loops through alarms nd adds them to file 
            for (int i = 0; i < alarms.length; i++)
            {
                bw.write(beginVAlarm+NL);
                String date = dateFormat.format(queue.DateConvert(alarms[i].trim()));
                bw.write("TRIGGER;VALUE=DATE-TIME:" + date + NL);
                bw.write("ACTION:DISPLAY"+NL);
                bw.write("DESCRIPTION:Alarm"+NL);
                bw.write("END:VALARM"+NL); 
            }
            bw.write(endVEvent+NL);
            bw.write(endVCal);

            bw.close();
            } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
    }
    
}
