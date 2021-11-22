public class StudentQueueList {
    private StudentNode front;
    private StudentNode rear;

    public StudentQueueList(){
        front = new StudentNode();
        rear = new StudentNode();
    }

    public boolean isEmpty(){
        return front == null;
    }

    public void enQue(Student s){
        if(rear != null){
            rear.next = new StudentNode(s);
            rear = rear.next;
        }
        else{
            rear = new StudentNode(s);
            front = rear;
        }
    }
    public Student deQue(){
        if(front == null) throw new IllegalArgumentException("Queue is empty");
        Student oldStudent = front.data;
        front = front.next;
        if(front == null) rear = null;
        return oldStudent;
    }
}
