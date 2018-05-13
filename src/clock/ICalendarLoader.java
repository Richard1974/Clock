/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

//***********************************************************
//**  ICalendar Loader                                     **
//**  used to load the ICalendar file                      **
//**                                                       **
//**  @author Richard Coldwell                             **
//**  13th May 2018                                        **
//***********************************************************
public class ICalendarLoader {
    
    
    
    PriorityQueue<Date> queue;
    List<String> alarmList = new ArrayList<String>();
    
    
    public ICalendarLoader(PriorityQueue<Date> q, String loadFilePath)
    {
        queue = q;
        File file =new File(loadFilePath);
        System.out.println("loadFilePath = " + loadFilePath);
        Scanner in = null;
        // looks through the file that is being loaded for lines that begin with TRIGGER 
        // as this is the line that the alarm details are stored on and loads these lines only 
        try 
        {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("TRIGGER"))//only need the lines that begin with TRIGGER to get the alarms
                {  
                    // removes the standard text from these lines leaving a string with alarm details only
                    alarmList.add(line.replace("TRIGGER;VALUE=DATE-TIME:", ""));
                }   
            }
        } 
        catch (FileNotFoundException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] alarms = alarmList.toArray(new String[0]);
        Date[] alarmsAsDate = CreateDateFromString(alarms);
        
        
        try {
            for (int i = 0; i < alarmsAsDate.length; i++)
        {
            queue.add(alarmsAsDate[i]);
        }
        } catch (QueueOverflowException ex) {
            Logger.getLogger(ICalendarLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // method called to create date objects from the date information stored in th eloaded strings
     public Date[] CreateDateFromString (String[] alarms)
     {
         //iCalendar date format File
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
         Date[] alarmsAsDate = new Date[alarms.length];
        for (int i = 0; i < alarms.length; i++)
        {
            Date dateFormatted = null;
            String stringDate = alarms[i].toString();
            
            try 
            {
                dateFormatted = dateFormat.parse(stringDate);
                System.out.println(dateFormatted);
                alarmsAsDate[i] = dateFormatted;
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }
         }
        return alarmsAsDate;
     }

}
