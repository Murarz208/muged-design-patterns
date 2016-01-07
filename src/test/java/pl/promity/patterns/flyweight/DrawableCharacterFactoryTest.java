package pl.promity.patterns.flyweight;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Maciek on 2016-01-02.
 */
public class DrawableCharacterFactoryTest {

    private DrawableCharacterFactory objectUnderTest;


    @Before
    public void setUp() throws Exception {
        objectUnderTest = new DrawableCharacterFactory();
    }

    @Test
    public void testLookupCharacterWithSingleCharacter() throws Exception {
        //given
        Character character = 'a';
        DrawableCharacter expectedDrawableCharacter = new DrawableCharacter(character);

        //when
        DrawableCharacter drawableCharacter = objectUnderTest.lookupCharacter(character);

        //then
        assertThat(drawableCharacter).isNotNull().isEqualTo(expectedDrawableCharacter);
    }

    @Test
    public void testLookupCharacterWithSameSingleCharacter() throws Exception {
        //given
        Character character = 'a';
        DrawableCharacter expectedDrawableCharacter = new DrawableCharacter(character);

        //when
        objectUnderTest.lookupCharacter(character);
        objectUnderTest.lookupCharacter(character);
        DrawableCharacter drawableCharacter = objectUnderTest.lookupCharacter(character);

        //then
        assertThat(drawableCharacter).isNotNull().isEqualTo(expectedDrawableCharacter);
    }

}