public class Producer implements Runnable{

    public void run() {
        int value = 0;
        while(true){
            synchronized (ProducerConsumer.buffer){
                while(ProducerConsumer.buffer.size() == ProducerConsumer.Buffer_size){
                    try{
                        ProducerConsumer.buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Producer produced: " +value);
                ProducerConsumer.buffer.add(value++);

                ProducerConsumer.buffer.notify();

                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
