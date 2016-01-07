package pl.promity.patterns.flyweight;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DrawableCharacterFactory {

    private final ConcurrentMap<Character, DrawableCharacter> characterCache;

    public DrawableCharacterFactory() {
        characterCache = new ConcurrentHashMap<>();
    }

    public DrawableCharacter lookupCharacter(char character){
        return characterCache.computeIfAbsent(character, newCharacter -> new DrawableCharacter(newCharacter));
    }

}
