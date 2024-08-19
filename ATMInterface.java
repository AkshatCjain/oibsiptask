import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class ATMInterface {
    private static final ArrayList<String> transactionsHistory = new ArrayList<>();
    private static int balance = 0;
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello, welcome to the ATM.");
        System.out.print("Enter your User ID: ");
        sc.nextLine(); // For a real application, use this input for authentication

        System.out.print("Enter your User PIN: ");
        sc.nextLine(); // For a real application, use this input for authentication

        System.out.println("You are logged in successfully.");
        mainMenu();
        sc.close(); // Close the scanner when done
    }

    private static void mainMenu() {
        int choice = 0;

        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        tranHistory();
                        break;
                    case 2:
                        withdrawExecute();
                        break;
                    case 3:
                        depositExecute();
                        break;
                    case 4:
                        transferExecute();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM! Visit again.");
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.next(); // Clear the invalid input
            }
        } while (choice != 5);
    }

    private static void tranHistory() {
        System.out.println("\nTransaction History:");
        if (transactionsHistory.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactionsHistory) {
                System.out.println(transaction);
            }
        }
    }

    private static void withdrawExecute() {
        System.out.print("Enter amount to withdraw: ");
        try {
            int amount = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionsHistory.add("Withdraw: " + amount);
                System.out.println("Withdrawal successful. Current balance: " + balance);
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Clear the invalid input
        }
    }

    private static void depositExecute() {
        System.out.print("Enter amount to deposit: ");
        try {
            int amount = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (amount > 0) {
                balance += amount;
                transactionsHistory.add("Deposit: " + amount);
                System.out.println("Deposit successful. Current balance: " + balance);
            } else {
                System.out.println("Invalid amount.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Clear the invalid input
        }
    }

    private static void transferExecute() {
        System.out.print("Enter recipient's account number: ");
        String recipientAccount = sc.nextLine();

        System.out.print("Enter amount to transfer: ");
        try {
            int amount = sc.nextInt();
            sc.nextLine(); // Consume newline

            if (amount > 0 && amount <= balance) {
                balance -= amount;
                transactionsHistory.add("Transfer: " + amount + " to " + recipientAccount);
                System.out.println("Transfer successful. Current balance: " + balance);
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            sc.next(); // Clear the invalid input
        }
    }
}

