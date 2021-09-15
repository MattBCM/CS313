public class Polynomial{
    private double[] coeff;
    private int deg;

    public Polynomial(double[] c){
        deg = c.length;
        coeff = c;
    }
    public Polynomial(double[] c, int d){
        if(d < 0) throw new IllegalArgumentException("Degree must be positive");
        deg = d;
        coeff = c;
    }
/*
    public evaluate(){

    }
*/
    public void add(Polynomial other){
        if(this.deg >= other.deg) {
            for (int i = other.deg; i > 0; i--) {
                this.coeff[i - 1] += other.coeff[i - 1];
            }
        }
        else {
            double[] temp = new double[other.deg];
            for(int i = other.deg; i > 0; i--){
                if(i > (this.deg)) temp[i-1] = other.coeff[i-1];
                else temp[i-1] = this.coeff[i-1] + other.coeff[i-1];
            }
            this.coeff = temp;
            this.deg = other.deg;
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
}
/*
public Polynomial sum(Polynomial p, Polynomialq){
    if
    return result
}
*/