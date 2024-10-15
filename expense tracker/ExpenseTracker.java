import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseTracker {
    private final List<Transaction> transactions;

    public ExpenseTracker() {
        transactions = new ArrayList<>();
        FileManager.loadTransactions(transactions);  // Load transactions from file
    }

    public void addTransaction(double amount, Date date, String category, String type) {
        Transaction transaction = new Transaction(amount, date, category, type);
        transactions.add(transaction);
        System.out.println("Transaction added: " + transaction);
    }

    public void generateSummary() {
        double totalIncome = 0;
        double totalExpense = 0;

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("income")) {
                totalIncome += t.getAmount();
            } else {
                totalExpense += t.getAmount();
            }
        }

        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Net Savings: " + (totalIncome - totalExpense));
    }

    public void saveData() {
        FileManager.saveTransactions(transactions);  // Save transactions to file
    }
}
