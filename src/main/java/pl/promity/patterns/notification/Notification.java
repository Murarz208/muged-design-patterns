package pl.promity.patterns.notification;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class for notification design pattern.
 * http://martinfowler.com/articles/replaceThrowWithNotification.html
 */
public class Notification {

    private final String delimiter;
    private final List<Error> errors;

    public Notification(String delimiter) {
        this.delimiter = delimiter;
        this.errors = new ArrayList<>();
    }

    /**
     * Returns true when at least one error was added, otherwise returns false
     */
    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    /**
     * Returns all stored error messages as one single string, joined by delimiter.
     * Delimiter is specified by implemented class.
     */
    public String errorMessage() {
        return errors.stream().map(error -> error.message ).collect(Collectors.joining(delimiter));
    }

    /**
     * Adds new error message to inner storage. Exception parameter can be ignored (can be null)
     * @throws NullPointerException when error message is null
     * @throws IllegalArgumentException when error message is empty
     */
    public void addError(String errorMessage, Exception exception) {
        Preconditions.checkNotNull(errorMessage, "passed null error message to notification");
        Preconditions.checkArgument(!errorMessage.isEmpty(), "passed empty error message to notification");
        errors.add( new Error(errorMessage, exception) );
    }

    /**
     * Adds new error message to inner storage.
     * @throws NullPointerException when error message is null
     * @throws IllegalArgumentException when error message is empty
     */
    public void addError(String errorMessage) {
        addError(errorMessage, null);
    }

    private final class Error{
        /** private */ final String message;
        /** private */ final Exception exception;

        private Error(String message, Exception exception) {
            this.message = message;
            this.exception = exception;
        }
    }

}
