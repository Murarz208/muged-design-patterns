package pl.promity.patterns.nullobject;

import pl.promity.patterns.common.UserData;

import java.util.Collections;
import java.util.List;

public class NullObjectUserDataProvider implements UserDataProvider {
    @Override
    public List<UserData> getUserData() {
        return Collections.EMPTY_LIST;
    }
}
