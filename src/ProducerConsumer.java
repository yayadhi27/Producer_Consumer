import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static final int Buffer_size = 2;
    public static final LinkedList < Integer > buffer = new LinkedList<>();

    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

    }
}
