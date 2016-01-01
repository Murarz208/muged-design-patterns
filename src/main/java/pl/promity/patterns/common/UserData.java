package pl.promity.patterns.common;

public class UserData {

    private final String login;
    private final String displayName;
    private final String address;

    public UserData(String login, String displayName, String address) {
        this.login = login;
        this.displayName = displayName;
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "login='" + login + '\'' +
                ", displayName='" + displayName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (login != null ? !login.equals(userData.login) : userData.login != null) return false;
        if (displayName != null ? !displayName.equals(userData.displayName) : userData.displayName != null)
            return false;
        return address != null ? address.equals(userData.address) : userData.address == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
