package pl.promity.examples.notification;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class NotificationImplTest {

    private static final String DELIMITER = ".";

    private NotificationImpl objectUnderTest;

    @Before
    public void setUp() throws Exception {
        objectUnderTest = new NotificationImpl(DELIMITER);
    }

    @Test
    public void testHasErrorFlagWhenErrorsArePresent() throws Exception {
        //given
        objectUnderTest.addError("newError");

        //when
        boolean hasErrors = objectUnderTest.hasErrors();

        //then
        assertThat(hasErrors).isTrue();
    }

    @Test
    public void testHasErrorFlagWhenErrorsAreAbsent() throws Exception {
        //given

        //when
        boolean hasErrors = objectUnderTest.hasErrors();

        //then
        assertThat(hasErrors).isFalse();
    }

    @Test
    public void testThrowingNPEWhenAddingNullError() throws Exception {
        //given
        String message = null;

        //when
        try {
            objectUnderTest.addError(message);
            fail("NullPointerException not thrown");
        }catch (NullPointerException exception){
            //then
            assertThat(exception).isNotNull();
        }
    }

    @Test
    public void testThrowingIAEWhenAddingNullError() throws Exception {
        //given
        String message = "";

        //when
        try {
            objectUnderTest.addError(message);
            fail("IllegalArgumentException not thrown");
        }catch (IllegalArgumentException exception){
            //then
            assertThat(exception).isNotNull();
        }
    }

    @Test
    public void testAddingSingleErrorMessage() throws Exception {
        //given
        String message = "message";
        objectUnderTest.addError(message);

        //when
        String resultMessage = objectUnderTest.errorMessage();

        //then
        assertThat(message).isEqualTo(resultMessage);
    }

    @Test
    public void testAddingMultipleErrorMessages() throws Exception {
        //given
        String messageOne = "messageOne";
        String messageTwo = "messageTwo";
        objectUnderTest.addError(messageOne);
        objectUnderTest.addError(messageTwo);
        objectUnderTest.addError(messageTwo);
        String expectedMessage = messageOne + DELIMITER + messageTwo + DELIMITER + messageTwo;

        //when
        String resultMessage = objectUnderTest.errorMessage();

        //then
        assertThat(expectedMessage).isEqualTo(resultMessage);
    }

}