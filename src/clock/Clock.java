package clock;

import java.util.Calendar;
import java.util.Date;

/**
 * The main class that starts the clock
 * @author Richard Coldwell
 */
public class Clock {
    
    /**
     *
     * @param args
     * @throws QueueOverflowException
     */
    public static void main(String[] args) throws QueueOverflowException {
        PriorityQueue<Date> q;
        q = new SortedArrayPriorityQueue<>(8);
        Model model = new Model();
        View view = new View(model, q);
        model.addObserver(view);
        Controller controller = new Controller(model, view, q);
    }
}
