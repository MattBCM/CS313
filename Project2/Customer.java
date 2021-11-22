//Project 1 Part B
public class Customer implements Comparable<Customer>{
    //*** Member Variable ***
    private String First, Last;
    private String acntNmbr;
    private double balance;

    //Constructors
    public Customer(String f, String l, String a, double b){
        First = f; Last = l; acntNmbr = a; balance = b;
    }
    public Customer(String f, String l, String a){
        First = f; Last = l; acntNmbr = a; balance = 0;
    }

    //*** Member Functions ***

    //Deposit function, b = b + a;
    public void Deposit(double amount){
        if(amount <= 0) throw new IllegalArgumentException("money deposited must be greater than 0");
        this.balance += amount;
    }

    //Withdraw function, b = b - a;
    public void Withdraw(double amount){
        if(amount <= 0) throw new IllegalArgumentException("money withdrawn must be greater than 0");
        this.balance -= amount;
    }

    //equals function, if account numbers equal to each other
    public boolean equals(Customer other){
        return this.acntNmbr.equals(other.acntNmbr);
    }

    @Override
    //toString function to print out Customers
    public String toString() {
        return  "Name: " + First + " " + Last + "\n" +
                "Account Number: " + acntNmbr + "\n" +
                "Balance: $" + balance;
    }

    @Override
    //compareTo function to compare last name first, then first if necessary
    public int compareTo(Customer o) {
            if (Last.compareTo(o.Last) == 0) {
                return First.compareTo(o.First);
            } else return Last.compareTo(o.Last);
        }

    //*** Getters and Setters ***

    public double getBalance() {
        return balance;
    }

    public String getAcntNmbr() {
        return acntNmbr;
    }

    public String getFirst() {
        return First;
    }

    public String getLast() {
        return Last;
    }

    public void setAcntNmbr(String acntNmbr) {
        this.acntNmbr = acntNmbr;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setFirst(String first) {
        First = first;
    }

    public void setLast(String last) {
        Last = last;
    }
}
