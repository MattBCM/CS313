public class node {
    protected Term data;
    protected node next;

    public node(Term t, node n){
        data = t;
        next = n;
    }

    public node(Term t){
        data = t;
        next = null;
    }
    public node(){
        data = null;
        next = null;
    }
}
