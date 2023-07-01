import java.util.Arrays;

public class WaitingListQueue {
        private final Object[] elements;
        private int front;
        private int rear;
        private int size;

        public WaitingListQueue(int capacity) {
            elements = new Object[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(Object element) {
            if (isFull()) {
                System.out.println("Waiting list queue is full. Element cannot be added.");
                return;
            }
            rear = (rear + 1) % elements.length;
            elements[rear] = element;
            size++;
        }

        public Object dequeue() {
            if (isEmpty()) {
                System.out.println("Waiting list queue is empty. No element to dequeue.");
                return null;
            }
            Object element = elements[front];
            elements[front] = null;
            front = (front + 1) % elements.length;
            size--;
            return element;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == elements.length;
        }
        public void printWaiting(){
            System.out.println(Arrays.toString(elements));
        }
}