public class Consumer implements Runnable{
    public void run() {
        synchronized (ProducerConsumer.buffer){
            while(ProducerConsumer.buffer.isEmpty()){
                try{
                    ProducerConsumer.buffer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int value = ProducerConsumer.buffer.poll();
            System.out.println("COnsumer consumed: "+ value);

            ProducerConsumer.buffer.notify();

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
