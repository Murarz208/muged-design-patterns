package pl.promity.patterns.dynamicfactory.interfaces;

import pl.promity.patterns.common.Command;

/**
 * Mini factory for creating products
 */
public interface CommandMaker {

    /**
     * Creates proper command
     */
    Command createCommand();

}
