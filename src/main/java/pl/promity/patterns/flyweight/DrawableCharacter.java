package pl.promity.patterns.flyweight;

/**
 * Flyweight character for example WYSIWYG editor
 */
public class DrawableCharacter {

    private final char character;

    public DrawableCharacter(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrawableCharacter that = (DrawableCharacter) o;

        return character == that.character;

    }

    public void draw(){
        System.out.println("Drawing character '"+character+"' on canvas");
    }

    @Override
    public int hashCode() {
        return (int) character;
    }
}
