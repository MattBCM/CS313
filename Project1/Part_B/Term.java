public class Term {
    //***Member Methods***
    protected double coeff;
    protected int power;

    //***Constructor***
    public Term(double c, int p){
        coeff = c;
        if(p < 0) throw new IllegalArgumentException("term's power is less than 0, which is wrong");
        power = p;
    }
}
