/*
Project 2: Hashing
Name: Matthew Murillo
*/

//necessary dependencies
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class CustomerMain {

    //static BST as it's always needed everywhere
    private static final myBST<Customer> CustomerBST = new myBST<>();
    private static final Customer[] customerArr = new Customer[10000];

    //Start up functions to call
    public static void main(String[] args) throws FileNotFoundException {
        Load(CustomerBST);//loads customer from file to BST
        Start(); //starts menu
    }

    public static void Start() throws FileNotFoundException {
        System.out.println("Welcome to NYC Bank, please enter the number that corresponds to what you want to do");
        while(true) {
        mainMenuPrompt();
        Scanner input = new Scanner(System.in);
        int numCase = input.nextInt();
        //numbered cases for what function to call
            switch (numCase) {
                case 1:
                    Deposit();
                    break;
                case 2:
                    Withdraw();
                    break;
                case 3:
                    Balance();
                    break;
                case 4:
                    newAccount();
                    break;
                case 5:
                    deleteAccount();
                    break;
                case 6:
                    Close(CustomerBST);
                default:
                    //If someone inputted anything else
                    System.out.println("Not an accepted input, please enter from 1 - 6\n");
            }
        }
    }
    //prints out the main menu
    public static void mainMenuPrompt() {
        System.out.print(
                        "[1] Make a Deposit\n" +
                        "[2] Make a Withdraw\n" +
                        "[3] Check your Balance\n" +
                        "[4] Make a new account\n" +
                        "[5] Close a bank account\n" +
                        "[6] Exit the program\n\n");
    }

    //loads the customers from the file by reading each line to the BST
    public static void Load(myBST<Customer> customerBST) throws FileNotFoundException {
        File inputFile = new File("source.txt");
        Scanner input = new Scanner(inputFile);
        //keeps reading each customer and inputting to BST until no more lines in TXT.
        while (input.hasNextLine()) {
            String first = input.next();
            String last = input.next();
            String acnt = input.next();
            double bal = input.nextDouble();
            Customer newCustomer = new Customer(first, last, acnt, bal);
            customerBST.insert(newCustomer);
            customerArr[Integer.parseInt(newCustomer.getAcntNmbr())] = newCustomer;
        }
        input.close();
    }

    //writes in TXT and then closes program.
    public static void Close(myBST<Customer> customerBST) throws FileNotFoundException {
        PrintWriter output = new PrintWriter("output.txt");
        //reads the customers in order and writes it in new TXT until the tree is empty
        while (!customerBST.isEmpty()) {
            Customer temp = customerBST.findMin();
            output.println(temp.getFirst() + " " + temp.getLast() + " " + temp.getAcntNmbr() + " " + temp.getBalance());
            customerBST.delete(temp);
        }
        output.close();
        System.exit(0);
    }

    //finds the customer and allows user to deposit money to account
    public static void Deposit() {
            Scanner input = new Scanner(System.in);
            //attempt to find customer. if no customer is found go to catch, else continue.
            try {
                System.out.println("Do you have an account number? [Y/N]");
                Customer result;
                if(input.nextLine().equals("Y")){
                    System.out.println("Please enter your 4-digit account number: ");
                    String acnt = input.nextLine();
                    result = customerArr[Integer.parseInt(acnt)];
                }
                else {
                    System.out.println("Please enter your first name: ");
                    String first = input.nextLine();
                    System.out.println("Please enter your last name: ");
                    String last = input.nextLine();
                    result = CustomerBST.search(new Customer(first, last, "0000"));
                }
                System.out.println("Please enter a number to deposit, " + result.getFirst() + ". You have " + result.getBalance() + ". ");
                double requestMoney = input.nextDouble();
                //deposit money to associated account
                result.Deposit(requestMoney);
                System.out.println("Your account now have: $" + result.getBalance() + ". \n");
            } catch (NullPointerException exception) {
                //no account was found
                System.out.println("No account was found, please try again\n\n");
            }
    }

    //take out money from the balance of the customer
    public static void Withdraw(){
            Scanner input = new Scanner(System.in);
        try {
            System.out.println("Do you have an account number? [Y/N]");
            Customer result;
            if(input.nextLine().equals("Y")){
                System.out.println("Please enter your 4-digit account number: ");
                String acnt = input.nextLine();
                result = customerArr[Integer.parseInt(acnt)];
            }
            else {
                System.out.println("Please enter your first name: ");
                String first = input.nextLine();
                System.out.println("Please enter your last name: ");
                String last = input.nextLine();
                result = CustomerBST.search(new Customer(first, last, "0000"));
            }
                System.out.println("Please enter a number to withdraw, " + result.getFirst() + ". You have " + result.getBalance() + ". ");
                double requestMoney = input.nextDouble();
                //if the balance would be a negative leave method, else continue
                if (result.getBalance() - requestMoney < 0)
                    System.out.println("You do not have enough money...");
                else {
                    result.Withdraw(requestMoney);
                    System.out.println("Your account now have: $" + result.getBalance() + ". \n");
                }
            } catch (NullPointerException exception) {
                //no account was found
                System.out.println("No account was found, please try again\n\n");
            }

    }
    //print to the user their balance to their account
    public static void Balance(){
            Scanner input = new Scanner(System.in);
        try {
            System.out.println("Do you have an account number? [Y/N]");
            Customer result;
            if(input.nextLine().equals("Y")){
                System.out.println("Please enter your 4-digit account number: ");
                String acnt = input.nextLine();
                result = customerArr[Integer.parseInt(acnt)];
            }
            else {
                System.out.println("Please enter your first name: ");
                String first = input.nextLine();
                System.out.println("Please enter your last name: ");
                String last = input.nextLine();
                result = CustomerBST.search(new Customer(first, last, "0000"));
            }
                System.out.println("Your account has: $" + result.getBalance() + ". \n");
            } catch (NullPointerException exception) {
                //no account was found
                System.out.println("No account was found, please try again\n\n");
            }
    }

    //creates a new customer to be added to the BST then to the output TXT
    public static void newAccount(){
            Scanner input = new Scanner(System.in);
            System.out.println("Please enter your first name: ");
            String first = input.nextLine();
            System.out.println("Please enter your last name: ");
            String last = input.nextLine();
            System.out.println("Please enter a 4-digit account number: ");
            String acnt = input.nextLine();
            Customer temp = new Customer(first, last, acnt);
            CustomerBST.insert(temp);
            customerArr[Integer.parseInt(acnt)] = temp;
            System.out.println("You have an account now at Bank NYC.\n");
    }

    //deletes a customer off the BST so their account is gone
    public static void deleteAccount(){
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Do you have an account number? [Y/N]");
            Customer result;
            if(input.nextLine().equals("Y")){
                System.out.println("Please enter your 4-digit account number: ");
                String acnt = input.nextLine();
                result = customerArr[Integer.parseInt(acnt)];
            }
            else {
                System.out.println("Please enter your first name: ");
                String first = input.nextLine();
                System.out.println("Please enter your last name: ");
                String last = input.nextLine();
                result = CustomerBST.search(new Customer(first, last, "0000"));
            }
            System.out.println("Account found, attempting to delete now...");
            CustomerBST.delete(result);
            customerArr[Integer.parseInt(result.getAcntNmbr())] = null;
            System.out.println("Your account has been deleted, we hope you come back to Bank NYC\n");
        }
        catch(NullPointerException exception){
            //no account was found
            System.out.println("No account was found, please try again\n\n");
        }
    }
}