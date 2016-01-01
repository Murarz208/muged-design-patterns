package pl.promity.patterns.dynamicfactory.interfaces;

import org.junit.Test;
import pl.promity.patterns.common.Command;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandDynamicFactoryTest {

    private CommandDynamicFactory objectUnderTest;

    @Test
    public void testCreateAndRegisterCommand() throws Exception {
        //given
        String key = "key";
        TestCommand expectedCommand = new TestCommand();
        TestCommandMaker makerToRegister = new TestCommandMaker();
        objectUnderTest.registerCommandMaker(key, makerToRegister);

        //when
        Command resultCommand = objectUnderTest.createCommand(key);

        //then
        assertThat(resultCommand).isNotNull().isEqualTo(expectedCommand);

    }
}