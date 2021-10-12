public class polyMain {
    public static void main(String[] args) {
        PolynomialB list = new PolynomialB();
        PolynomialB list2 = new PolynomialB();
        list.insert(1, 2);
        list.insert(-2, 1);
        list.insert(3, 0);
        list2.insert(1, 2);
        list2.insert(4, 1);
        list2.insert(2, 0);
        System.out.println(PolynomialB.sum(list, list2));
        System.out.println(PolynomialB.diff(list, list2));
        System.out.println(PolynomialB.product(list, list2));
    }
}
