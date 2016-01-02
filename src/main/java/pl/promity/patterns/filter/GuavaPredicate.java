package pl.promity.patterns.filter;

import com.google.common.base.Predicate;
import pl.promity.patterns.common.UserData;

/**
 * Predicate example with guava
 */
public class GuavaPredicate implements Predicate<UserData>{

    private final String startsWithString;

    public GuavaPredicate(String startsWithString) {
        this.startsWithString = startsWithString;
    }

    @Override
    public boolean apply(UserData userData) {
        return userData.getLogin().startsWith( this.startsWithString );
    }
}
