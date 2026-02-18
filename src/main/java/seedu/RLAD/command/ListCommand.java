package seedu.RLAD.command;

import seedu.RLAD.TransactionManager;
import seedu.RLAD.Ui;

public class ListCommand extends Command {
    public ListCommand(String rawArgs) {
        super(rawArgs);
    }

    @Override
    public void execute(TransactionManager transactions, Ui ui) {
        // TODO: Use an ArgumentTokenizer/Parser to extract --type, --category, and --sort
        // TODO: Filter the ArrayList from transactions.getTransactions() based on provided flags
        // TODO: If the resulting list is empty, call ui.showResult("Your wallet is empty")
        // TODO: Otherwise, iterate through filtered results and pass formatted strings to ui.showResult()
        ui.showResult("ListCommand logic will be implemented here.");
    }

    @Override
    public boolean hasValidArgs() {
        // TODO: Verify that flags like --type only contain 'credit' or 'debit'
        // TODO: Verify that --sort is only 'date' or 'amount'
        return true;
    }
}
