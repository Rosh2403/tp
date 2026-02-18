package seedu.RLAD;

import java.util.ArrayList;

public class TransactionManager {
    private final ArrayList<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction t) {
        // TODO: Implement a loop to regenerate ID if idExists(t.getHashId()) is true
        transactions.add(t);
    }

    /**
     * Checks if a Transaction HashID is already in use.
     * TODO: Replace O(N) list search with a HashSet for O(1) lookups to improve scaling.
     */

    private boolean idExists(String hashId) {
        return false;
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
