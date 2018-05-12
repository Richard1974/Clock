package clock;

import java.util.Calendar;
import java.util.Date;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        PriorityQueue<Date> q;
        q = new SortedArrayPriorityQueue<>(8);
        Model model = new Model();
        View view = new View(model, q);
        model.addObserver(view);
        Controller controller = new Controller(model, view, q);
    }
}
