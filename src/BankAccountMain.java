import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountMain {
   
    static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public static void main(String[] args) {

        // BankAccount bankAccount = new BankAccount("Keng", 500);
        
        // bankAccount.deposit(100);

        // System.out.println(bankAccount.getBankAccountBalance());

        // BankAccount bankAccount1 = new BankAccount("Lue", 5000);
       
        // BankAccount bankAccount2 = new BankAccount("LP", 300);
       
        // bankAccount1.withdrawal(100);
       
        // bankAccount2.deposit(100);
      
        // System.out.println(bankAccount1.getBankAccountBalance());
       
        // System.out.println(bankAccount2.getBankAccountBalance());
        
        // }

        String input;

        greetings();

    }

    private static void greetings() {

        Scanner scanner = new Scanner(System.in);
        
        String input;
        
        do {
            System.out.println("Hello fellow banker! Welcome to the Bank of Matt!");

            System.out.println("Are you an existing customer? (-1 to exit)");

            System.out.println("1. Yes");

            System.out.println("2. No");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("1")) {

                System.out.println("Please select the account number of the account you'd like to access");
               
                for (BankAccount bankAccount : bankAccounts) {
                    System.out.println(bankAccount.getAccountHolderName() + ": " + bankAccount.getAccountNumber());
                }
               
                String number = scanner.nextLine();
                
                int accountNumber = Integer.parseInt(number) - 1;
                
                BankAccount currentBankAccount = bankAccounts.get(accountNumber);
                
                mainMenu(currentBankAccount);
            } else if (input.equalsIgnoreCase("2")) {
                System.out.println("Let's make a new account!");
                
                System.out.println("What is the name for the account");
                String name = scanner.nextLine();
                
                System.out.println("What is the beginning balance for the account");
                String accountBalance = scanner.nextLine();
                
                double balanceOfAccount = Double.parseDouble(accountBalance);
                
                bankAccounts.add(new BankAccount());
                
                (bankAccounts.get(bankAccounts.size() - 1)).setAccountNumber(bankAccounts.size());
                
                (bankAccounts.get(bankAccounts.size() - 1)).setName(name);
                
                (bankAccounts.get(bankAccounts.size() - 1)).setBalance(balanceOfAccount);
                
                BankAccount bankAccount = bankAccounts.get(bankAccounts.size() - 1);
               
                mainMenu(bankAccount);
            } else if (input.equalsIgnoreCase("-1")) {

                System.out.println("Thanks for banking with us");
                System.exit(0);

            } else {

                System.out.println("Not a valid response");
            }

        } while (!input.equals("-1"));
    }

    private static void mainMenu(BankAccount bankAccount) {

        String input;
        do {

            Scanner scanner = new Scanner(System.in);
           
            System.out.println("Hello " + bankAccount.getAccountHolderName() + "!");
           
            System.out.println("Welcome to the Main Menu, what would you like to do today?");
            
            System.out.println("1. To check account balance");
            
            System.out.println("2. To make a withdrawal");
            
            System.out.println("3. To make a deposit");
          
            System.out.println("4. To make a transfer to another account");
           
            System.out.println("0. To exit");
           
            input = scanner.nextLine();

            if (input.equals("1")) {

                System.out.println(bankAccount.getBankAccountBalance());

            } else if (input.equals("2")) {

                System.out.println("How much would you like to withdrawal?");

                String withdrawal = scanner.nextLine();

                double withdrawalMoney = Double.parseDouble(withdrawal);

                bankAccount.withdrawal(withdrawalMoney);

            } else if (input.equals("3")) {

                System.out.println("How much would you like to deposit?");

                String inputMoney = scanner.nextLine();

                double depositMoney = Double.parseDouble(inputMoney);

                bankAccount.deposit(depositMoney);

            } else if (input.equals("4")) {

                System.out.println("Please enter the account number to transfer to");

                String accountNumber = scanner.nextLine();

                int accountInformation = Integer.parseInt(accountNumber) - 1;
               
                if (accountInformation > bankAccounts.size()) {

                    System.out.println("Account doesn't exist");

                } else {

                    System.out.println("Please enter the amount to transfer");

                    String amountOfMoney = scanner.nextLine();

                    double amountToTransfer = Double.parseDouble(amountOfMoney);
 
                    bankAccount.transferMoney(bankAccounts.get(accountInformation), amountToTransfer);
                   
                    System.out.println("The name on the account to transfer from is: " + bankAccount.getAccountHolderName() + " and they have a balance of $" + bankAccount.getBankAccountBalance());
                   
                    System.out.println("The name on the account to transfer to is: " + (bankAccounts.get(accountInformation).getAccountHolderName() + " and they have a balance of $" + (bankAccounts.get(accountInformation).getBankAccountBalance())));

                }

            } else if (input.equals("0")) {

                System.out.println("Back to account selection");
               
                greetings();

            }

        } while (!input.equals(0));
    }

}
