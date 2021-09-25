public class main {
    public static void main(String[] args) {
        double[] arr = {2, 5, 3};
        double[] arr2 = {1, 9, 4};
        Polynomial p = new Polynomial(arr);
        Polynomial q = new Polynomial(arr2);
        System.out.println(Polynomial.product(p,q));
    }
}