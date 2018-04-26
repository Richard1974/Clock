package clock;

import java.util.Calendar;
import java.util.Date;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        PriorityQueue<Alarm> q;
        q = new UnsortedArrayPriorityQueue<>(8);
        Alarm alarm = new Alarm(Calendar.getInstance());
        alarm.setDate(12, 3, 2001);
        alarm.setTime(11, 49);
        q.add(alarm);
       Alarm alarmTwo = new Alarm(Calendar.getInstance());

        alarmTwo.setDate(4, 10, 2011);
        alarmTwo.setTime(17, 21);
        q.add(alarmTwo);
        
        //System.out.println("Alarm " + alarm);
        System.out.println("q.toString() " + q.toString());
    }
}
