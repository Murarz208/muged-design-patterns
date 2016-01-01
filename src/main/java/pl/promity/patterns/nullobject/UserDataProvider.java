package pl.promity.patterns.nullobject;

import pl.promity.patterns.common.UserData;

import java.util.List;

/**
 * Abstraction for retrieving user data
 */
public interface UserDataProvider {

    List<UserData> getUserData();

}
