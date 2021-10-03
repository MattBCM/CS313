public class polyMain {
    public static void main(String[] args) {
        PolynomialB list = new PolynomialB();
        Term first = new Term(3.2, 3);
        Term second = new Term(4.5, 6);
        Term third = new Term(2, 2);
        Term fourth = new Term(5.7, 3);
        list.insert(first);
        list.insert(second);
        list.insert(third);
        list.insert(fourth);
        System.out.println(list);
    }
}
