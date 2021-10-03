public class PolynomialB {
    private node head;
    private int degree;

    public PolynomialB(){
        head = new node();
        degree = -1;
    }

    public void insert(Term t){
        node temp = new node(t);
        node curr = head.next;
        node prev = head;
        while(curr != null && t.power < curr.data.power){
               prev = curr;
               curr = curr.next;
        }
        if(curr == null){
            prev.next = temp;
        }
        else if(t.power == curr.data.power) curr.data.coeff += t.coeff;
        else{
            temp.next = curr;
            prev.next = temp;
        }
        degree = head.next.data.power;
    }

    @Override
    public String toString() {
        node curr = head.next;
        String result = curr.data.coeff + "x^" + curr.data.power;
        curr = curr.next;
        while(curr != null){
            result += (" + " + curr.data.coeff+"x^"+curr.data.power);
            curr = curr.next;
        }
        result += (" Degree: " + this.degree);
        return result;
    }
}
