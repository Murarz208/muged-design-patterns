package pl.promity.patterns.nullobject;

import com.google.common.collect.Lists;
import pl.promity.patterns.common.UserData;

import java.util.List;

public class UserDataDatabaseProvider implements UserDataProvider {

    @Override
    public List<UserData> getUserData() {
        return getDatabaseUserData();
    }

    /** this method is implemented for simulating d*a*t*a*b*a*s*e magic */
    private List<UserData> getDatabaseUserData(){
        return Lists.newArrayList(
            new UserData("mike.tyson", "Mike Tyson", "7988 Deerfield Drive, Naples, FL 34116"),
            new UserData("steve.jobs", "Steve Jobs", "666 Drive, Hell"),
            new UserData("walt.disney", "Walter Disney", "Fridge")
        );
    }

}
