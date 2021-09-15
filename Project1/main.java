public class main {
    public static void main(String[] args) {
        double[] arr = {1, 2, 3, 4, 5};
        double[] arr2 = {6, 5, 8, 3, 5, 8, 7};
        Polynomial p = new Polynomial(arr);
        Polynomial q = new Polynomial(arr2);
        p.add(q);
    }
}