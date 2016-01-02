package pl.promity.patterns.flyweight;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

public class DrawableCharacterFactory {

    private final ConcurrentMap<Character, DrawableCharacter> characterCache;

    public DrawableCharacterFactory() {
        characterCache = new ConcurrentHashMap<>();
    }

    public DrawableCharacter lookupCharacter(char character){
        return characterCache.computeIfAbsent(character, new Function<Character, DrawableCharacter>() {
            @Override
            public DrawableCharacter apply(Character character) {
                return new DrawableCharacter(character);
            }
        });
    }

}
