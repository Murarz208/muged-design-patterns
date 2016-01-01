package pl.promity.examples.notification;

/**
 * Interface for notification design pattern.
 * http://martinfowler.com/articles/replaceThrowWithNotification.html
 */
public interface Notification {

    /**
     * Returns true when at least one error was added, otherwise returns false
     */
    boolean hasErrors();

    /**
     * Returns all stored error messages as one single string, joined by delimiter.
     * Delimiter is specified by implemented class.
     */
    String errorMessage();

    /**
     * Adds new error message to inner storage.
     * @throws NullPointerException when error message is null
     * @throws IllegalArgumentException when error message is empty
     */
    void addError(String errorMessage);

}
