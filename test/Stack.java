public class Stack{
    private node top;

    public Stack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(Object data){
        top = new node(data, top);
    }
    public Object peek(){
        return top.data;
    }
    public Object pop(){
        if(isEmpty()) throw new IllegalArgumentException("Stack is empty");
        Object oldTop = top.data;
        top = top.next;
        return oldTop;
    }

    private void display(node t){
        if(t == null) return;
        else{
            System.out.println(t.data);
            display(t.next);
        }
    }
    public void display(){
        node t = top;
        display(t);
    }

    private void displayReverse(node t){
        if(t == null) return;
            displayReverse(t.next);
            System.out.print(t.data + " ");
    }

    public void displayReverse(){
        node t = top;
        displayReverse(t);
    }

    @Override
    public String toString() {
        node t = top;
        String s = "";
        return toString(t, s);
    }

    private String toString(node t, String s) {
        if(t == null) return "";
        s += (t.data + " " + toString(t.next, s));
        return s;
    }

}

class node{
    Object data;
    node next;

    public node(Object d, node n){
        data = d;
        next = n;
    }
}