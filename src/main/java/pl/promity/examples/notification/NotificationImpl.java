package pl.promity.examples.notification;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotificationImpl implements Notification {

    private final String delimiter;
    private final List<String> errors;

    public NotificationImpl(String delimiter) {
        this.delimiter = delimiter;
        this.errors = new ArrayList<>();
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.stream().collect(Collectors.joining(delimiter));
    }

    public void addError(String errorMessage) {
        Preconditions.checkNotNull(errorMessage, "passed null error message to notification");
        Preconditions.checkArgument(!errorMessage.isEmpty(), "passed empty error message to notification");
        errors.add(errorMessage);
    }

}
