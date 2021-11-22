/*
Warm-Up Project B: Polynomial using Linked Structure
Name: Matthew Murillo
 */

public class PolynomialB {
    //***Member Variable***
    private node head;
    private int degree;

    //***Constructor***
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
        node temp = new node(new Term(d, p));
        node curr = head.next;
        node prev = head;
        while(curr != null && temp.data.power < curr.data.power){
               prev = curr;
               curr = curr.next;
        }
        //if the polynomial is empty
        if(curr == null){
            prev.next = temp;
        }
        //if there is a term whose power equals to the inputted power
        else if(temp.data.power == curr.data.power) curr.data.coeff += temp.data.coeff;
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
            //evaluates polynomial and adds itself to result
            result += (curr.data.coeff * power(x, curr.data.power));
            curr = curr.next;
        }
        return result;
    }

    //add function, p = p + q
    public void add(PolynomialB q){
        node curr = q.head.next;
            while(curr != null){
                //insert method automatically adds if the power is the same
                this.insert(curr.data.coeff, curr.data.power);
                curr = curr.next;
            }
    }
    //subtract function, p = p - q
    public void subtract(PolynomialB q){
        node curr = q.head.next;
        q.scale(-1);
        while(curr != null){
            //it subtracts since p - q = p + (-q)
            this.insert(curr.data.coeff, curr.data.power);
            curr = curr.next;
        }
        //revert q back to normal
        q.scale(-1);
    }

    //multiply function, p = p * q
    public void multiply(PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = this.head.next;
        node QCurr;
        while(PCurr != null){
            //resets QCurr to the beginning of the polynomial
            QCurr = q.head.next;
            while(QCurr != null){
                //inserts new node to result with coefficients multiplying and powers adding
                result.insert((PCurr.data.coeff * QCurr.data.coeff), (PCurr.data.power + QCurr.data.power));
                QCurr = QCurr.next;
            }
            PCurr = PCurr.next;
        }
        //set head.next to the result, removing the previous polynomial and setting degree
        this.head.next = result.head.next;
        this.degree = result.degree;
    }

    // scale function, xp = x * p where x is a constant
    public void scale(double n){
        node curr = this.head.next;
        while(curr != null){
            curr.data.coeff *= n;
            curr = curr.next;
        }
    }

    //***Polynomial Methods***

    // sum method, r = p + q
    public static PolynomialB sum(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        //creates new polynomial with new nodes to not change data from p.
        while(PCurr != null){
            result.insert(PCurr.data.coeff, PCurr.data.power);
            PCurr = PCurr.next;
        }
        result.add(q);
        return result;
    }

    //difference method, r = p - q
    public static PolynomialB diff(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        //creates new polynomial with new nodes to not change data from p.
        while(PCurr != null){
            result.insert(PCurr.data.coeff, PCurr.data.power);
            PCurr = PCurr.next;
        }
        result.subtract(q);
        return result;
    }

    // multiply method, r = p * q
    public static PolynomialB product(PolynomialB p, PolynomialB q){
        PolynomialB result = new PolynomialB();
        node PCurr = p.head.next;
        //creates new polynomial with new nodes to not change data from p.
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
