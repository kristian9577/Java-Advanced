package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<Integer, BankAccount> bankAccounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] lineArguments = scanner.nextLine().split(" ");
        String command = lineArguments[0];

        while (!command.equals("End")) {

            switch (command) {
                case "Create":
                    createBankAccount();
                    break;
                case "Deposit":
                    depositSum(Integer.parseInt(lineArguments[1]), Double.parseDouble(lineArguments[2]));
                    break;
                case "SetInterest":
                    setInterest(Double.parseDouble(lineArguments[1]));
                    break;
                case "GetInterest":
                    getInterest(Integer.parseInt(lineArguments[1]), Integer.parseInt(lineArguments[2]));
                    break;
            }

            lineArguments = scanner.nextLine().split(" ");
            command = lineArguments[0];
        }
    }

    private static void getInterest(int id, int years) {
        BankAccount account = bankAccounts.get(id);

        if (account != null) {
            System.out.printf("%.2f%n", account.getInterestRate(years));
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositSum(int id, double amount) {
        BankAccount account = bankAccounts.get(id);

        if (account == null) {
            System.out.println("Account does not exist");
            return;
        }

        account.deposit(amount);
        System.out.printf("Deposited %.0f to ID%d%n", amount, id);

    }

    private static void createBankAccount() {
        BankAccount account = new BankAccount();
        bankAccounts.put(account.getId(), account);

        System.out.println("Account ID" + account.getId() + " created");
    }

    private static void setInterest(double interest) {
        BankAccount.setInterestRate(interest);
    }
}