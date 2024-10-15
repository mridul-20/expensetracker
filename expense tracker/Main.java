import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ExpenseTracker tracker = new ExpenseTracker();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Expense Tracker");

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Summary");
            System.out.println("3. Exit");

            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (option) {
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    tracker.generateSummary();
                    break;
                case 3:
                    tracker.saveData();
                    System.out.println("Exiting... Data saved.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addTransaction(Scanner scanner) {
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter category: ");
        String category = scanner.nextLine();

        System.out.print("Enter type (income/expense): ");
        String type = scanner.nextLine();

        tracker.addTransaction(amount, new Date(), category, type);
    }
}
