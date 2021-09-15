public class StudentNode {
    protected Student data;
    protected StudentNode next;

    public StudentNode() {
        data = null;
        next = null;
    }

    public StudentNode(Student D) {
        data = D;
    }

    public StudentNode(Student D, StudentNode N) {
        data = D;
        next = N;
    }
}
