public class StudentQueueArray {
    private Student[] data;
    private int front;
    private int rear;
    private int count;

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < count; i++){
            result += data[(front+i)% data.length] + " ";
        }
        return result;
    }

    public StudentQueueArray(int size){
        data = new Student[size];
        front = 0; rear = -1;
        count = 0;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void enQue(Student x){
        if(count == data.length) throw new IllegalArgumentException("Queue is full");
        data[(++rear) % data.length] = x;
        count++;
    }

    public Object deQue(){
        if(this.isEmpty()) throw new IllegalArgumentException("Queue is empty");
        Object oldFront = data[front];
        front = ((++front) % data.length);
        count--;
        return oldFront;
    }
}
