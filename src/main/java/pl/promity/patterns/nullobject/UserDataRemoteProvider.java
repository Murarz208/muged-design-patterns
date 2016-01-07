package pl.promity.patterns.nullobject;

import com.google.common.collect.Lists;
import pl.promity.patterns.common.UserData;

import java.util.List;

public class UserDataRemoteProvider implements UserDataProvider {
    @Override
    public List<UserData> getUserData() {
        return getRemoteUserData();
    }

    /** this method is implemented for simulating r*e*m*o*t*e magic */
    private List<UserData> getRemoteUserData(){
        return Lists.newArrayList(
            new UserData(55, "tiger.woods", "Tiger Woods", "704 Somerset Drive Green Bay, WI 54302"),
            new UserData(43, "larry.page", "Larry Page", "941 Sherwood Drive Deland, FL 32720"),
            new UserData(80, "clint.eastwood", "Clint Eastwood", "342 Hillside Avenue Mechanicsville, VA 23111")
        );
    }
}
