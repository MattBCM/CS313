public class PolynomialB {
    private node head;
    private int degree;

    //constructor
    public PolynomialB(){
        head = new node();
        degree = -1;
    }

    //***Override Methods***
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

    //***Member Methods***

    //insert term to polynomial and is sorted
    public void insert(double d, int p){
        Term t = new Term(d, p);
        node temp = new node(t);
        node curr = head.next;
        node prev = head;
        while(curr != null && t.power < curr.data.power){
               prev = curr;
               curr = curr.next;
        }
        //if the polynomial is empty
        if(curr == null){
            prev.next = temp;
        }
        //if there is a term whose power equals to the inputted power
        else if(t.power == curr.data.power) curr.data.coeff += t.coeff;
        else{
            temp.next = curr;
            prev.next = temp;
        }
        degree = head.next.data.power; //degree is highest power
    }

    //evaluate function, p(x) = r
    public double evaluate(double x){
        node curr = this.head.next;
        double result = 0;
        while(curr != null){
            result += (curr.data.coeff * power(x, curr.data.power));
            curr = curr.next;
        }
        return result;
    }

    //add function, p = p + q
    public void add(PolynomialB q){
        node curr = q.head.next;
            while(curr != null){
                this.insert(curr.data.coeff, curr.data.power);
                curr = curr.next;
            }
    }

    public void subtract(PolynomialB q){
        node curr = q.head.next;
        q.scale(-1);
        while(curr != null){
            this.insert(curr.data.coeff, curr.data.power);
            curr = curr.next;
        }
        q.scale(-1);
    }

    public void multiply(PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = this.head.next;
        node QCurr;
        while(PCurr != null){
            QCurr = q.head.next;
            while(QCurr != null){
                //Term temp = new Term((PCurr.data.coeff * QCurr.data.coeff), (PCurr.data.power + QCurr.data.power));
                result.insert((PCurr.data.coeff * QCurr.data.coeff), (PCurr.data.power + QCurr.data.power));
                QCurr = QCurr.next;
            }
            PCurr = PCurr.next;
        }
        this.head.next = result.head.next;
        this.degree = result.degree;
    }

    public void scale(double n){
        node curr = this.head.next;
        while(curr != null){
            curr.data.coeff *= n;
            curr = curr.next;
        }
    }

    public static PolynomialB sum(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        while(PCurr != null){
            result.insert(PCurr.data.coeff, PCurr.data.power);
            PCurr = PCurr.next;
        }
        result.add(q);
        return result;
    }

    public static PolynomialB diff(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        while(PCurr != null){
            result.insert(PCurr.data.coeff, PCurr.data.power);
            PCurr = PCurr.next;
        }
        result.subtract(q);
        return result;
    }

    public static PolynomialB product(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        while(PCurr != null){
            result.insert(PCurr.data.coeff, PCurr.data.power);
            PCurr = PCurr.next;
        }
        result.multiply(q);
        return result;
    }

    //power function, r = x^p
    private double power(double x, int p){
        double result = 1;
        for(int i = 0; i < p; i++)
            result *= x;
        return result;
    }
}
