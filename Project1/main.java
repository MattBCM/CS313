public class main {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3, 4, 5};
        double[] arr2 = {6, 5, -8, 3, -5, 8, 7};
        Polynomial p = new Polynomial(arr);
        Polynomial q = new Polynomial(arr2);
        System.out.println(p.evaluate(2.0));
        System.out.println(q.evaluate(2.0));
        p.add(q);
        p.subtract(q);
        p.scale(2.0);
        System.out.println(p);
        System.out.println(Polynomial.diff(p, q));
    }
}