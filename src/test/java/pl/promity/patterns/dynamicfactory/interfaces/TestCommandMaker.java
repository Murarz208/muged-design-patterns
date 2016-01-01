package pl.promity.patterns.dynamicfactory.interfaces;

import pl.promity.patterns.common.Command;

public class TestCommandMaker implements CommandMaker {

    @Override
    public Command createCommand() {
        return new TestCommand();
    }
}
