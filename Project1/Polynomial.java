public class Polynomial{
    //member variable
    private double[] coeff;
    private int deg;

    //constructors
    public Polynomial(double[] c){
        if((c.length -1) < 0)
            throw new IllegalArgumentException("Array is empty, please enter an array with values");
        else deg = c.length-1;
        coeff = c;
    }

    //override print function
    @Override
    public String toString() {
        String result = String.valueOf(this.coeff[0]);
        for(int i = 1; i <= this.deg; i++){
            result += " + " + this.coeff[i] + "x^" + i;
        }
        return result;
    }

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
            double[] temp = new double[other.deg + 1];
            for(int i = other.deg; i >= 0; i--){
                if(i > (this.deg)) temp[i] = other.coeff[i];
                else temp[i] = this.coeff[i] + other.coeff[i];
            }
            //replaces p with values of temp
            this.coeff = temp;
            this.deg = other.deg;
        }
    }
    //subtract function, p = p-q
    public void subtract(Polynomial other){
        other.scale(-1);
        this.add(other);
        other.scale(-1);
    }

    //scale function, p = c*p
    public void scale(double x){
        for(int i = 0; i <= this.deg; i++)
            this.coeff[i] *= x;
    }

    public void multiply(Polynomial other){
        double[] temp = new double[this.deg + other.deg + 1];

        for(int i = 0; i < this.coeff.length; i++){
            for(int j = 0; j < other.coeff.length; j++){
                temp[j+i] += this.coeff[i] * other.coeff[j];
            }
        }
        this.coeff = temp;
        this.deg = temp.length-1;
    }

    // Polynomial methods

    public static Polynomial sum(Polynomial p, Polynomial q){
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        result.add(p);
        result.add(q);
        return result;
    }

    public static Polynomial diff(Polynomial p, Polynomial q){
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        result.add(p);
        result.subtract(q);
        return result;
    }

    public static Polynomial product(Polynomial p, Polynomial q){
        double[] temp = new double[p.deg+1];
        Polynomial result = new Polynomial(temp);
        result.add(p);
        result.multiply(q);
        return result;
    }

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

    private double power(double x, int p){
        double result = 1;
        for(int i = 0; i < p; i++)
            result *= x;
        return result;
    }
}

