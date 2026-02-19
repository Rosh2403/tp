package seedu.RLAD;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Provides sorting utilities for transaction lists.
 * Supports sorting by amount or date in ascending order.
 */
public class TransactionSorter {
    public static final String SORT_BY_AMOUNT = "amount";
    public static final String SORT_BY_DATE = "date";

    /**
     * Sorts the given list of transactions by the specified field.
     *
     * @param transactions the list of transactions to sort
     * @param sortBy the field to sort by ("amount" or "date")
     * @return a new sorted ArrayList of transactions
     */
    public static ArrayList<Transaction> sort(ArrayList<Transaction> transactions, String sortBy) {
        ArrayList<Transaction> sorted = new ArrayList<>(transactions);
        switch (sortBy) {
        case SORT_BY_AMOUNT:
            sorted.sort(Comparator.comparingDouble(Transaction::getAmount));
            break;
        case SORT_BY_DATE:
            sorted.sort(Comparator.comparing(Transaction::getDate));
            break;
        default:
            break;
        }
        return sorted;
    }

    /**
     * Checks if the given sort field is valid.
     *
     * @param sortBy the field name to validate
     * @return true if sortBy is "amount" or "date"
     */
    public static boolean isValidSortField(String sortBy) {
        return sortBy.equals(SORT_BY_AMOUNT) || sortBy.equals(SORT_BY_DATE);
    }
}
