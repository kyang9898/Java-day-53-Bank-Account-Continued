public class BankAccount {
    private double bankAccountBalance;
    private String accountHolderName;
    private int accountNumber;

    public BankAccount(double bankAccountBalance, String accountHolderName, int accountNumber) {

        this.bankAccountBalance = bankAccountBalance;

        this.accountHolderName = accountHolderName;

        this.accountNumber = accountNumber;
    }

    public double deposit(double money) {
        return (bankAccountBalance += money);

    }

    public double withdrawal(double money) {
        return (bankAccountBalance -= money);

    }

    public double getBankAccountBalance() {
        return bankAccountBalance;

    }

    public String getAccountHolderName() {
        return accountHolderName;

    }

    public int getAccountNumber() {
        return accountNumber;

    }

    public BankAccount() {
        this.bankAccountBalance = 0;

        this.accountHolderName = "";

    }

    public void setName(String name) {
        accountHolderName = name;

    }

    public void setBalance(double money) {
        bankAccountBalance = money;

    }

    public void setAccountNumber(int number) {
        accountNumber = number;

    }

    public void transferMoney(BankAccount money, double moneyTotal) {
        bankAccountBalance -= moneyTotal;

        money.bankAccountBalance += moneyTotal;

    }

}