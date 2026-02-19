package seedu.RLAD.command;

import seedu.RLAD.Transaction;
import seedu.RLAD.TransactionManager;
import seedu.RLAD.TransactionSorter;
import seedu.RLAD.Ui;

import java.util.ArrayList;

public class ListCommand extends Command {
    private String sortBy;

    public ListCommand(String rawArgs) {
        super(rawArgs);
        this.sortBy = parseSortField(rawArgs);
    }

    /**
     * Extracts the --sort value from raw arguments.
     *
     * @param rawArgs the raw argument string from user input
     * @return the sort field if provided, or empty string if not
     */
    private String parseSortField(String rawArgs) {
        if (rawArgs == null || rawArgs.isEmpty()) {
            return "";
        }
        String[] tokens = rawArgs.split("\\s+");
        for (int i = 0; i < tokens.length - 1; i++) {
            if (tokens[i].equals("--sort")) {
                return tokens[i + 1].toLowerCase();
            }
        }
        return "";
    }

    @Override
    public void execute(TransactionManager transactions, Ui ui) {
        ArrayList<Transaction> results = transactions.getTransactions();

        if (results.isEmpty()) {
            ui.showResult("Your wallet is empty! Use 'add' to record a transaction.");
            return;
        }

        if (!sortBy.isEmpty()) {
            results = TransactionSorter.sort(results, sortBy);
        }

        for (Transaction transaction : results) {
            ui.showResult(transaction.toString());
        }
    }

    @Override
    public boolean hasValidArgs() {
        if (sortBy.isEmpty()) {
            return true;
        }
        return TransactionSorter.isValidSortField(sortBy);
    }
}
