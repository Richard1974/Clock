/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clock;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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
        File file =new File(loadFilePath);
        System.out.println("loadFilePath = " + loadFilePath);
        Scanner in = null;
        try {
            in = new Scanner(file);
            while(in.hasNext())
            {
                String line=in.nextLine();
                if(line.contains("TRIGGER"))//only need the lines that begin with TRIGGER to get the alarms
                {  
                    alarmList.add(line.replace("TRIGGER;VALUE=DATE-TIME:", ""));
                }   
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String[] alarms = alarmList.toArray(new String[0]);
        
    }
    
   
    
}
