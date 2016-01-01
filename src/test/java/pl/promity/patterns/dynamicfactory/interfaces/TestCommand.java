package pl.promity.patterns.dynamicfactory.interfaces;

import pl.promity.patterns.common.Command;

public class TestCommand implements Command {

    private int number;

    public TestCommand(){
        number = 0;
    }

    @Override
    public void execute() {
        number = 10;
    }

    @Override
    public void undo() {
        number = 0;
    }
}
