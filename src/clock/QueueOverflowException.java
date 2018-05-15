package clock;

/**
 * Queue is full.
 *
 * Cannot accept a new item.
 * @author Richard Coldwell
 */
public class QueueOverflowException extends Exception {

    /**
     * overflow exception
     */
    public QueueOverflowException() {
        super("Queue is full");
    }
}