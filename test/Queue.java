public class Queue {
    private Object[] data;
    private int front;
    private int rear;
    private int count;

    public Queue(int size){
        data = new Object[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void enQue(Object x){
        if(count == data.length) throw new IllegalArgumentException("Queue is full");
        data[(++rear) % data.length] = x;
        count++;
    }

    public Object deQue(){
        if(isEmpty()) throw new IllegalArgumentException("Queue is empty");
        Object oldFront = data[front];
        front = ((++front) % data.length);
        count--;
        return oldFront;
    }
}
