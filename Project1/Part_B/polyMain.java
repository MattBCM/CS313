

public class polyMain {
    public static void main(String[] args) {
        PolynomialB list = new PolynomialB();
        PolynomialB list2 = new PolynomialB();
        list.insert(1, 0);
        list.insert(-2, 1);
        list.insert(3, 0);
        list2.insert(1, 2);
        list2.insert(4, 1);
        list2.insert(2, 0);
        System.out.println(list.evaluate(12));
        System.out.println(PolynomialB.sum(list, list2));
        System.out.println(PolynomialB.diff(list, list2));
        System.out.println(PolynomialB.product(list, list2));
        System.out.println(grade(70, 70, 90));
    }

    public static double max(double x, double y){
        if(x >= y) return x;
        else return y;
    }

    public static double grade(double x, double y, double z){
        double grade1 = (25 * max((x/100), (y/100)));
        double grade2 = (35 * max((y/100), (z/100)));
        double grade3 = (45 * max((z/100), (((x/5) + (y/3))/100)));
        return grade1 + grade2 + grade3;
    }

}
