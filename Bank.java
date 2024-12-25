import java.util.Scanner;

public class BankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Arrays to hold account details
        String[] accountNames = new String[1];
        double[] accountBalances = new double[1];
        int accountCount = 0;  // Keeps track of the number of accounts

        while (true) {
            // Display menu
            System.out.println("\nSimple Banking System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:  // Create Account
                    if (accountCount < 1) {
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter initial deposit amount: ");
                        double deposit = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline

                        accountNames[accountCount] = name;
                        accountBalances[accountCount] = deposit;
                        accountCount++;
                        System.out.println("Account created successfully.");
                    } else {
                        System.out.println("Account already created.");
                    }
                    break;

                case 2:  // Deposit Money
                    if (accountCount == 0) {
                        System.out.println("No account found. Please create an account first.");
                    } else {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline

                        accountBalances[0] += depositAmount;
                        System.out.println("Deposited " + depositAmount + ". New balance: " + accountBalances[0]);
                    }
                    break;

                case 3:  // Withdraw Money
                    if (accountCount == 0) {
                        System.out.println("No account found. Please create an account first.");
                    } else {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline

                        if (withdrawAmount > accountBalances[0]) {
                            System.out.println("Insufficient balance.");
                        } else {
                            accountBalances[0] -= withdrawAmount;
                            System.out.println("Withdrew " + withdrawAmount + ". New balance: " + accountBalances[0]);
                        }
                    }
                    break;

                case 4:  // Check Balance
                    if (accountCount == 0) {
                        System.out.println("No account found. Please create an account first.");
                    } else {
                        System.out.println("Current balance: " + accountBalances[0]);
                    }
                    break;

                case 5:  // Exit
                    System.out.println("Exiting the program...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
