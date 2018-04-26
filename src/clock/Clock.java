package clock;

import java.util.Calendar;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        PriorityQueue<Alarm> q;
        q = new UnsortedArrayPriorityQueue<>(8);
        Alarm alarm = new Alarm(Calendar.getInstance());
        q.add(alarm);
        System.out.println("Alarm " + alarm);
        System.out.println("q.toString() " + q.toString());
    }
}
