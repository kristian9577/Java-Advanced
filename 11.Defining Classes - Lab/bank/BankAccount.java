package bank;

class BankAccount {
    private static double interestRate = 0.02;
    private static int accountsCount = 0;

    private int id;
    private double balance;

    public BankAccount() {
        accountsCount++;
        this.id = accountsCount;
        this.balance = 0;
    }

    public double getInterestRate(int years) {
        return years * this.getBalance() * interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }
}
