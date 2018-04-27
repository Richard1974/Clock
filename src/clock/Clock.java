package clock;

import java.util.Calendar;
import java.util.Date;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        PriorityQueue<Alarm> q;
        q = new UnsortedArrayPriorityQueue<>(8);
        Model model = new Model();
        View view = new View(model, q);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        
        
    }
}
