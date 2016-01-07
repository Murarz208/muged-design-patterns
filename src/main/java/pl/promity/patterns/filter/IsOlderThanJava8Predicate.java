package pl.promity.patterns.filter;

import pl.promity.patterns.common.UserData;

import java.util.function.Predicate;

/**
 * Predicate example with java 8
 */
public class IsOlderThanJava8Predicate implements Predicate<UserData> {

    private final int ageThreshold;

    public IsOlderThanJava8Predicate(int ageTreshold) {
        this.ageThreshold = ageTreshold;
    }

    @Override
    public boolean test(UserData userData) {
        return userData.getAge() > ageThreshold;
    }
}
