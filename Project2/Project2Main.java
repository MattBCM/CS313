import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Project2Main {

    private static myBST<Customer> CustomerBST = new myBST<>();

    public static void main(String[] args) throws FileNotFoundException{
        Load(CustomerBST);
    }

    public static void Start() throws FileNotFoundException{
        Scanner input = new Scanner(System.in);
        int numCase = input.nextInt();
        System.out.println("Welcome to NYC Bank, please enter the number that corresponds to what you want to do");
        mainMenuPrompt();
        switch (numCase){
            case 1: Deposit();
            case 2: Withdraw();
            case 3: checkBalance();
            case 4: newAccount();
            case 5: closeAccount();
            case 6: Close(CustomerBST);
        }
    }

    public static void mainMenuPrompt(){
        System.out.print(
                "[1] Make a Deposit\n" +
                "[2] Make a Withdraw\n" +
                "[3] Check your Balance\n" +
                "[4] Make a new account\n" +
                "[5] Close a bank account\n" +
                "[6] Exit the program");
    }


    public static void Load(myBST<Customer> customerBST) throws FileNotFoundException{
        File inputFile = new File("Project2/source.txt");
        Scanner input = new Scanner(inputFile);
        while(input.hasNextLine()){
            String first = input.next();
            String last = input.next();
            String acnt = String.valueOf(input.nextInt());
            double bal = input.nextDouble();
            Customer newCustomer = new Customer(first, last, acnt, bal);
            customerBST.insert(newCustomer);
        }
        input.close();
    }

    public static void Close(myBST<Customer> customerBST) throws FileNotFoundException{
        PrintWriter output = new PrintWriter("output.txt");
        while(!customerBST.isEmpty()){
            Customer temp = customerBST.findMin();
            output.println(temp.getFirst() + " " + temp.getLast() + " " + temp.getAcntNmbr() + " " + temp.getBalance());
            customerBST.delete(temp);
        }
        output.close();
        System.exit(0);
    }

}