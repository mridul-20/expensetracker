import java.util.Date;

public class Transaction {
    private final double amount;
    private final Date date;
    private final String category;
    private final String type;

    public Transaction(double amount, Date date, String category, String type) {
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", category='" + category + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
