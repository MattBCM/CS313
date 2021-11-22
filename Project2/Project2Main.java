public class Project2Main {
    public static void main(String[] args) {
        myBST<Customer> customerBST = new myBST<>();
        Customer MattJew = new Customer("Matthew", "Murillo", "23432432", 0.00);
        Customer Rifraf = new Customer("Rif-Motha", "Fukin-Raf", "7139180004", 70000000);
        Customer loser = new Customer("Nicole", "Murillo", "5374934", 3745.20);
        customerBST.insert(MattJew);
        customerBST.insert(Rifraf);
        customerBST.insert(loser);
        Customer[] arr = new Customer[3];
        customerBST.sortToArray(arr);
    }
}