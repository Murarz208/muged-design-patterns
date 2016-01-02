package pl.promity.patterns.filter;

import pl.promity.patterns.common.UserData;

import java.util.function.Predicate;

/**
 * Predicate example with guava
 */
public class Java8Predicate implements Predicate<UserData> {

    private final String startsWithString;

    public Java8Predicate(String startsWithString) {
        this.startsWithString = startsWithString;
    }

    @Override
    public boolean test(UserData userData) {
        return userData.getLogin().startsWith( this.startsWithString );
    }
}
