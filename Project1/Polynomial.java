public class Polynomial{
    private double coeff[];
    private int deg;

    public Polynomial(double c[]){
        deg = c.length;
        coeff = c;
    }
    public Polynomial(double c[], int d){
        if(d < 0) throw new IllegalArgumentException("Degree must be positive");
        deg = d;
        coeff = c;
    }

    public evaluate(){

    }

    public add(Polynomial other){
        for(int i = this.deg; i >= 0; i++){
            this.coeff[i] = this.coeff[i] + other.coeff[i]
        }
    }


}
/*
public Polynomial sum(Polynomial p, Polynomialq){
    if
    return result
}
*/