package pl.promity.patterns.common;

/**
 * Interface for command design pattern
 */
public interface Command {

    /**
     * Executes command
     */
    void execute();

    /**
     * Undo command
     */
    void undo();

}
