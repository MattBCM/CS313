public class Polynomial{
    private double[] coeff;
    private int deg;

    //constructors
    public Polynomial(double[] c){
        deg = c.length-1;
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
            this.coeff = temp;
            this.deg = other.deg;
        }
    }
    //subtract function, p = p-q
    public void subtract(Polynomial other){
        double[] temp = new double[other.deg+1];
        for(int i = 0; i <= other.deg; i++){
            temp[i] = (0 - other.coeff[i]);
        }
        Polynomial revOther = new Polynomial(temp);
        this.add(revOther);
    }

    //scale function, p = c*p
    public void scale(double x){
        for(int i = 0; i <= this.deg; i++){
            this.coeff[i] *= x;
        }
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
        for(int i = 0; i < p; i++){
            result *= x;
        }
        return result;
    }
}
/*
public Polynomial sum(Polynomial p, Polynomial q){
    if
    return result
}
*/
