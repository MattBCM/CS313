public class main {
    public static void main(String[] args) {
        double[] arr = {};
        double[] arr2 = {9, 0, 27, 0, 0, 13};
        Polynomial p = new Polynomial(arr);
        Polynomial q = new Polynomial(arr2);
        System.out.println(Polynomial.product(p, q));
        System.out.println(Polynomial.sum(p, q));
        System.out.println(Polynomial.diff(p, q));
    }
}