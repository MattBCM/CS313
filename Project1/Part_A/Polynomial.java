/*
Warm-Up Project A: Polynomial class using arrays
Name: Matthew Murillo
*/
public class Polynomial{

    //***Member variable***

    private double[] coeff;
    private int deg;

    //***constructors***

    public Polynomial(double[] c){
        //throws message and closes program if array is empty, else create the Polynomial class.
        if((c.length -1) < 0)
            throw new IllegalArgumentException("Array is empty, please enter an array with values");
        else deg = c.length-1;
        coeff = c;
    }

    //override print function
    @Override
    public String toString() {
        //reads every polynomial coefficient and prints it with corresponding degree.
        String result = String.valueOf(this.coeff[0]);
        for(int i = 1; i <= this.deg; i++){
            result += " + " + this.coeff[i] + "x^" + i;
        }
        return result;
    }

    //***Member Methods***

    //evaluate polynomial using coeff * input^deg
    public double evaluate(double x){
        double result = 0;
        for(int i = deg; i > 0; i--){
            result += this.coeff[i] * power(x, i);
        }
        return result;
    }

    //add function, p = p+q
    public void add(Polynomial other){
        //if the degree of polynomial p is greater or equal to q
        if(this.deg >= other.deg) {
            for (int i = other.deg; i >= 0; i--) {
                this.coeff[i] += other.coeff[i];
            }
        }
        //if polynomial q's degree is greater
        else {
            //create a temporary array size of q and add q and p to temp.
            double[] temp = new double[other.deg + 1];
            for(int i = other.deg; i >= 0; i--){
                if(i > (this.deg)) temp[i] = other.coeff[i];
                else temp[i] = this.coeff[i] + other.coeff[i];
            }
            //replaces p with values of temp.
            this.coeff = temp;
            this.deg = other.deg;
        }
    }
    //subtract function, p = p-q.
    public void subtract(Polynomial other){
        //reverse sign of q since p - q == p + (-q) then reverse signs back.
        other.scale(-1);
        this.add(other);
        other.scale(-1);
    }

    //scale function, p = c*p
    public void scale(double x){
        //each value in the array is multiplied by x.
        for(int i = 0; i <= this.deg; i++)
            this.coeff[i] *= x;
    }

    //multiply function, p = p*q
    public void multiply(Polynomial other){
        //create a new array that has the size of the sum of the greatest degree to p and q
        double[] temp = new double[this.deg + other.deg + 1];
        for(int i = 0; i < this.coeff.length; i++){
            for(int j = 0; j < other.coeff.length; j++){
                //each number in p is multiplied by q then added to respected array space.
                temp[j+i] += this.coeff[i] * other.coeff[j];
            }
        }
        //replace values of p with temp.
        this.coeff = temp;
        this.deg = temp.length-1;
    }

    //***Polynomial methods***

    //sum method, r = p + q
    public static Polynomial sum(Polynomial p, Polynomial q){
        //create a new polynomial to be returned
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        //use add methods to reenact summing 2 polynomials while not overriding p and q
        result.add(p);
        result.add(q);
        return result;
    }

    //difference method, r = p - q
    public static Polynomial diff(Polynomial p, Polynomial q){
        //create a new polynomial to be returned
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        //use subtract method to reenact subtracting 2 polynomials while not overriding p and q
        result.add(p);
        result.subtract(q);
        return result;
    }

    //product method, r = p * q
    public static Polynomial product(Polynomial p, Polynomial q){
        //create a new polynomial to be returned
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        //use multiply method to reenact multiplying 2 polynomials while not overriding p and q
        result.add(p);
        result.multiply(q);
        return result;
    }

    //***Getters and Setters

    public double[] getCoeff() {
        return coeff;
    }

    public int getDeg() {
        return deg;
    }

    public void setCoeff(double[] coeff) {
        this.coeff = coeff;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    //power function, r = x^p
    private double power(double x, int p){
        double result = 1;
        for(int i = 0; i < p; i++)
            result *= x;
        return result;
    }
}

