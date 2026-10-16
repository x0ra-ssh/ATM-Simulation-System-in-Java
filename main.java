import java.util.Scanner;
import java.util.ArrayList;

class Account {
    String name;
    String password;
    double balance;

    Account(String name, String password, double balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }
}

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== ATM SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                System.out.print("Set your password: ");
                String password = sc.nextLine();

                accounts.add(new Account(name, password, 0));

                System.out.println("Account created successfully!");
            }

            else if (choice == 2) {
                System.out.print("Enter your name: ");
                String name = sc.nextLine();

                System.out.print("Enter your password: ");
                String password = sc.nextLine();

                Account current = null;

                for (Account a : accounts) {
                    if (a.name.equals(name) &&
                        a.password.equals(password)) {
                        current = a;
                        break;
                    }
                }

                if (current == null) {
                    System.out.println("Invalid name or password.");
                }

                else {
                    System.out.println("Welcome, " + current.name + "!");

                    int option;

                    do {
                        System.out.println("\n--- ATM MENU ---");
                        System.out.println("1. Check Balance");
                        System.out.println("2. Deposit Money");
                        System.out.println("3. Withdraw Money");
                        System.out.println("4. Logout");
                        System.out.print("Enter choice: ");
                        option = sc.nextInt();

                        if (option == 1) {
                            System.out.println(
                                "Balance: Rs. " + current.balance
                            );
                        }

                        else if (option == 2) {
                            System.out.print("Enter amount: Rs. ");
                            double amount = sc.nextDouble();

                            if (amount > 0) {
                                current.balance += amount;
                                System.out.println("Deposit successful!");
                            } else {
                                System.out.println("Invalid amount.");
                            }
                        }

                        else if (option == 3) {
                            System.out.print("Enter amount: Rs. ");
                            double amount = sc.nextDouble();

                            if (amount <= 0) {
                                System.out.println("Invalid amount.");
                            } else if (amount > current.balance) {
                                System.out.println("Insufficient balance.");
                            } else {
                                current.balance -= amount;
                                System.out.println("Withdrawal successful!");
                            }
                        }

                        else if (option == 4) {
                            System.out.println("Logged out successfully.");
                        }

                        else {
                            System.out.println("Invalid choice.");
                        }

                    } while (option != 4);

                    sc.nextLine();
                }
            }

            else if (choice == 3) {
                System.out.println("Thank you for using the ATM!");
            }

            else {
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}
