package pl.promity.patterns.filter;

import com.google.common.base.Predicate;
import pl.promity.patterns.common.UserData;

/**
 * Predicate example with guava
 */
public class IsOlderThanGuavaPredicate implements Predicate<UserData> {

    private final int ageThreshold;

    public IsOlderThanGuavaPredicate(int ageTreshold) {
        this.ageThreshold = ageTreshold;
    }

    @Override
    public boolean apply(UserData userData) {
        return userData.getAge() > ageThreshold;
    }
}
