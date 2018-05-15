package clock;

/**
 * Queue is empty.
 *
 * Cannot access or remove an item from an empty queue.
 * @author Richard Coldwell
 */

public class QueueUnderflowException extends Exception {

    /**
     * underflow exception
     */
    public QueueUnderflowException() {
        super("Queue is empty");
    }
}
