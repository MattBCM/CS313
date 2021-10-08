public class polyMain {
    public static void main(String[] args) {
        PolynomialB list = new PolynomialB();
        PolynomialB list2 = new PolynomialB();
        list.insert(3.2, 3);
        list.insert(4.5, 6);
        list2.insert(5.2, 4);
        list2.insert(82, 7);
        System.out.println(PolynomialB.diff(list, list2));
    }
}
