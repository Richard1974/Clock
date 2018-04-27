package clock;

import java.util.Calendar;
import java.util.Date;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        PriorityQueue<Alarm> q;
        q = new UnsortedArrayPriorityQueue<>(8);
        Model model = new Model(q);
        View view = new View(model, q);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        
        /*Alarm alarm = new Alarm(Calendar.getInstance());
        alarm.setDate(12, 3, 2001);
        alarm.setTime(11, 49);
        q.add(alarm);
       Alarm alarmTwo = new Alarm(Calendar.getInstance());

        alarmTwo.setDate(4, 10, 2011);
        alarmTwo.setTime(17, 21);
        q.add(alarmTwo);*/
        
        //System.out.println("Alarm " + alarm);
       // System.out.println("q.toString() " + q.toString());
    }
}
