package DSAStackVaQueue.bai_tap.QueueDSLienKet;

public class Main {
    public static void main(String[] args) {
        MyQueue.Queue queue= new MyQueue.Queue();
        queue.front = queue.rear = null;

        MyQueue.enQueue(queue, 5);
        MyQueue.enQueue(queue, 10);
        MyQueue.enQueue(queue, 15);

        MyQueue.displayQueue(queue);

        System.out.printf("\n Deleted element = %d", MyQueue.deQueue(queue));
        System.out.printf("\n Deleted element = %d", MyQueue.deQueue(queue));

       MyQueue.displayQueue(queue);


        MyQueue.enQueue(queue, 20);
        MyQueue.enQueue(queue, 25);

        MyQueue.displayQueue(queue);
    }
}
