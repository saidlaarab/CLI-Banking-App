
import java.util.Scanner;

public class BankingApp{
    public static void main(String[] args){
        BankAccount myAccount = new BankAccount("Said", "");
        myAccount.showMenu();
    }
}

class BankAccount{
    private String fname;
    private String lname;
    private double balance;
    private double previousTransaction;

    public BankAccount(String fn, String ln){
        this.fname = fn;
        this.lname = ln;
    }

    public void showMenu(){
        System.out.println("                                                ");
        System.out.println("==============================================");
        System.out.println(" Welcome "+this.fname+" "+this.lname+".\n");
        
        System.out.println(" Please choose an option from the list below: \n");

        System.out.println(" A. Show my balance.");
        System.out.println(" B. Deposit an amount.");
        System.out.println(" C. Withdraw an amount.");
        System.out.println(" D. Show previous transaction.");
        System.out.println(" E. Exit.");
        System.out.println("----------------------------------------------");         
        
        // Process the user's request based on ths chosen option:
        Scanner scanner = new Scanner(System.in);
        char option = '\0';
        do{
            System.out.println("----------------------------------------------");
            System.out.print(  " Your option : ");
            scanner = new Scanner(System.in);
            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch(option){
                case 'A': this.showBalance(); 
                        break;
                case 'B': this.deposit(scanner); 
                        break;
                case 'C': this.withdraw(scanner);                      
                        break;
                case 'D': this.showPT(); 
                        break;
                case 'E': this.exit();
                        break;
                default : System.out.println(" Invalid option! Please try again.");
            }

        }
        while(option != 'E');

    }

    public void showBalance(){
        System.out.println(" Your balance is: "+this.balance);
        System.out.println("----------------------------------------------");
    }
    public void deposit(Scanner scanner){
        System.out.print(" Amount to deposit : "); 
        double amount = scanner.nextDouble();
        if(amount > 0){
            this.balance += amount;
            this.previousTransaction = amount;
            System.out.println("----------------------------------------------");
        }
        
    }
    public void withdraw(Scanner scanner){
        System.out.print(" Amount to withdraw : "); 
        double amount = scanner.nextDouble();
        if(amount > 0){
            this.balance -= amount;
            this.previousTransaction = -amount;
            System.out.println("----------------------------------------------");
        }   
    }
    public void exit(){
        System.out.println("   Thank you for using our service.");
        System.out.println("================================================");
    }
    public void showPT(){
        if(this.previousTransaction > 0){
            System.out.println(" deposit of " + this.previousTransaction);
        }else if(this.previousTransaction < 0){
            System.out.println(" withdrawal of "+(-this.previousTransaction));
        }else{
            System.out.println(" No transation was done before !");
        }
    }
}

