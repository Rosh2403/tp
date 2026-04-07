package seedu.RLAD.command;

import seedu.RLAD.exception.RLADException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 * Shared utility methods used by multiple Command classes.
 * Eliminates duplication of parsing and formatting logic.
 */
public class CommandUtils {

    private static final DateTimeFormatter DOT_FORMAT =
            DateTimeFormatter.ofPattern("uuuu.MM.dd")
                    .withResolverStyle(ResolverStyle.STRICT);

    private CommandUtils() {
        // Prevent instantiation
    }

    /**
     * Parses and validates an amount string.
     * Amount must be a positive number.
     *
     * @param amountStr the amount as a string
     * @return the parsed amount as a double
     * @throws RLADException if the format is invalid or amount is not positive
     */
    public static double parseAmount(String amountStr) throws RLADException {
        try {
            double value = Double.parseDouble(amountStr.trim());
            if (value <= 0) {
                throw new RLADException(
                        "Amount must be greater than 0, got: " + amountStr);
            }
            return value;
        } catch (NumberFormatException e) {
            throw new RLADException(
                    "Invalid amount: '" + amountStr
                            + "'. Must be a positive number (e.g. 15.50)");
        }
    }

    /**
     * Parses a date string supporting both yyyy-MM-dd and yyyy.MM.dd formats.
     *
     * @param dateStr the date as a string
     * @return the parsed LocalDate
     * @throws RLADException if the date format is invalid
     */
    public static LocalDate parseDate(String dateStr) throws RLADException {
        try {
            String trimmed = dateStr.trim();
            if (trimmed.contains(".")) {
                return LocalDate.parse(trimmed, DOT_FORMAT);
            }
            return LocalDate.parse(trimmed);
        } catch (Exception e) {
            throw new RLADException(
                    "Invalid date: '" + dateStr
                            + "'. Use yyyy-MM-dd or yyyy.MM.dd");
        }
    }

    /**
     * Formats a category for display.
     * Returns "(none)" if the category is null or blank.
     *
     * @param category the raw category string
     * @return the display-ready category string
     */
    public static String formatCategory(String category) {
        return (category == null || category.isBlank())
                ? "(none)" : category;
    }

    /**
     * Formats a description for display.
     * Returns "(none)" if the description is null or blank.
     *
     * @param description the raw description string
     * @return the display-ready description string
     */
    public static String formatDescription(String description) {
        return (description == null || description.isBlank())
                ? "(none)" : description;
    }
}
