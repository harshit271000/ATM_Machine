package Projects;

import java.util.Scanner;

class ATM{
    float balance;
    int pin = 1234;

    public void checkPin(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your pin = ");
        int enteredPin = sc.nextInt();

        if(enteredPin == pin){                         // Checking Pin
            menu();
        }
        else {
            System.out.println("Enter a Valid Pin.");
            checkPin();                            // going to checkPin again if the pin is incorrect
        }
    }

    public void menu(){                            // Menu method which contains all choices
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice = ");
        System.out.println("1. Check A/C Balance ");
        System.out.println("2. Withdraw Money ");
        System.out.println("3. Deposit Money ");
        System.out.println("4. Exit ");

        int opt = sc.nextInt();

        if(opt == 1){
            checkBalance();
        }
        else if (opt == 2) {
            withdrawMoney();
        }
        else if (opt == 3) {
            depositMoney();
        }
        else if (opt == 4) {
            return;
        }
        else{
            System.out.println("Enter a Valid Choice");
        }

    }

    public void checkBalance(){
        System.out.println("Balance = " + balance);
        menu();                                        // going back to menu again;
    }
    public void withdrawMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Amount to Withdraw = ");     // getting amount to withdraw from the user
        float amount = sc.nextFloat();

        if(amount > balance){
            System.out.println("Insufficient Balance!");
        }
        else {
            balance = balance - amount;
            System.out.println("Money Withdrawn Successfully and Remaining balance = " + balance);
            menu();                                // going back to menu
        }
    }

    public void depositMoney(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount to Deposit = ");
        float amount = sc.nextFloat();
        balance = balance + amount;
        System.out.println("Money Deposited Successfully and New Balance = " +balance);
        menu();
    }

}

public class ATMMachine {
    public static void main(String[] args) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}
