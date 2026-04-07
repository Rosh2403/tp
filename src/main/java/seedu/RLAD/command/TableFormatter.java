package seedu.RLAD.command;

import seedu.RLAD.Transaction;
import seedu.RLAD.Ui;

/**
 * Shared table formatting for transaction display.
 * Used by ListCommand and SearchCommand to avoid duplicating
 * the same table layout logic.
 */
public class TableFormatter {

    private static final String DIVIDER = "-".repeat(75);

    private TableFormatter() {
        // Prevent instantiation
    }

    /**
     * Prints the table header with column names.
     */
    public static void printHeader(Ui ui) {
        ui.showResult(DIVIDER);
        ui.showResult(String.format("  %-6s %-8s %-12s %10s  %-12s  %s",
                "ID", "TYPE", "DATE", "AMOUNT", "CATEGORY", "DESCRIPTION"));
        ui.showResult(DIVIDER);
    }

    /**
     * Prints a single transaction row in the table format.
     */
    public static void printRow(Ui ui, Transaction t) {
        ui.showResult(String.format("  %-6s %-8s %-12s %10s  %-12s  %s",
                t.getHashId(),
                t.getType().toUpperCase(),
                t.getDate().toString(),
                String.format("$%.2f", t.getAmount()),
                CommandUtils.formatCategory(t.getCategory()),
                CommandUtils.formatDescription(t.getDescription())));
    }

    /**
     * Prints the table footer with a divider and summary message.
     */
    public static void printFooter(Ui ui, String message) {
        ui.showResult(DIVIDER);
        ui.showResult("  " + message);
    }
}
