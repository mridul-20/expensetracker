import java.io.*;
import java.util.List;

public class FileManager {
    private static final String FILE_PATH = "transactions.txt";

    // Save transactions to a file
    public static void saveTransactions(List<Transaction> transactions) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Transaction t : transactions) {
                writer.write(t.getAmount() + "," + t.getDate().getTime() + "," + t.getCategory() + "," + t.getType());
                writer.newLine();
            }
            System.out.println("Transactions saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving transactions: " + e.getMessage());
        }
    }

    // Load transactions from a file
    public static void loadTransactions(List<Transaction> transactions) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                double amount = Double.parseDouble(parts[0]);
                long dateLong = Long.parseLong(parts[1]);
                String category = parts[2];
                String type = parts[3];
                
                transactions.add(new Transaction(amount, new java.util.Date(dateLong), category, type));
            }
            System.out.println("Transactions loaded from file.");
        } catch (FileNotFoundException e) {
            System.out.println("No existing transactions file found. Starting fresh.");
        } catch (IOException e) {
            System.err.println("Error loading transactions: " + e.getMessage());
        }
    }
}
