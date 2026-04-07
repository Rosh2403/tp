package seedu.RLAD.command;

import seedu.RLAD.Transaction;
import seedu.RLAD.TransactionManager;
import seedu.RLAD.Ui;
import seedu.RLAD.exception.RLADException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SearchCommand finds transactions by keyword across all fields.
 * Searches description, category, hash ID, and amount.
 * Also available as "find" (alias registered in Parser).
 */
public class SearchCommand extends Command {

    public SearchCommand(String rawArgs) {
        super(rawArgs);
    }

    private String parseKeyword() {
        Map<String, String> flags = FilterCommand.parseFlags(rawArgs);
        String keyword = flags.get("keyword");
        return (keyword != null && !keyword.isEmpty())
                ? keyword : null;
    }

    private boolean matchesKeyword(Transaction t, String keyword) {
        String lower = keyword.toLowerCase();
        if (t.getDescription().toLowerCase().contains(lower)) {
            return true;
        }
        if (t.getCategory() != null
                && t.getCategory().toLowerCase().contains(lower)) {
            return true;
        }
        if (t.getHashId().toLowerCase().contains(lower)) {
            return true;
        }
        if (String.format("%.2f", t.getAmount()).contains(lower)) {
            return true;
        }
        return String.valueOf(t.getAmount()).contains(lower);
    }

    @Override
    public void execute(TransactionManager transactions, Ui ui)
            throws RLADException {
        if (!hasValidArgs()) {
            throw new RLADException(
                    "Missing required field: --keyword");
        }

        String keyword = parseKeyword();
        List<Transaction> results =
                transactions.getTransactions().stream()
                        .filter(t -> matchesKeyword(t, keyword))
                        .collect(Collectors.toList());

        if (results.isEmpty()) {
            ui.showResult("No transactions found matching: \""
                    + keyword + "\"");
            return;
        }

        TableFormatter.printHeader(ui);
        for (Transaction t : results) {
            TableFormatter.printRow(ui, t);
        }
        TableFormatter.printFooter(ui,
                results.size() + " transaction(s) found for: \""
                        + keyword + "\"");
    }

    @Override
    public boolean hasValidArgs() {
        return rawArgs != null
                && rawArgs.contains("--keyword")
                && parseKeyword() != null;
    }
}
