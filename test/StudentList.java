public class StudentList {
    private StudentNode head;
    private int length;

    public StudentList(){
        head = new StudentNode();
        length = 0;
    }
    public void append(Student SN){
        StudentNode dummy = new StudentNode(SN);
        StudentNode current = head;
        while(current.next != null) current = current.next;
        current.next = dummy;
        length++;
    }
    public void deleteNodeByName(String lastName){
        StudentNode current = head.next;
        StudentNode prev = head;
        while(current.next != null && (!(current.data.getLastName().equals(lastName))) ){
            prev = current;
            current = current.next;
        }
        if (current.next == null) return;
        prev.next = current.next;
    }
    public void sortByGPA(){
        StudentNode current = head.next;
        StudentNode temp;
        while(current.next != null){
            temp = current.next;
            while(temp != null){
                if(temp.data.getGPA() > current.data.getGPA()){
                    Student temp2 = temp.data;
                    temp.data = current.data;
                    current.data = temp2;
                }
                temp = temp.next;
            }
            current = current.next;
        }
    }
}
