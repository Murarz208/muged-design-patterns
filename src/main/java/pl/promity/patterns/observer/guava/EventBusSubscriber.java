package pl.promity.patterns.observer.guava;

import com.google.common.eventbus.Subscribe;
import pl.promity.patterns.common.UserData;

/**
 * Example subscriber class for guava event bus
 */
public class EventBusSubscriber {

    private UserData userData;
    private String address;

    public EventBusSubscriber() {
        userData = null;
        address = null;
    }

    @Subscribe
    public void updateUserData(UserData userData){
        System.out.println("Hi! I was notified from event bus with following data : " + userData);
        this.userData = userData;
    }

    @Subscribe
    public void updateAddress(String address){
        System.out.println("Hi! I was notified from event bus with following data : " + address);
        this.address = address;
    }

    public UserData getUserData() {
        return userData;
    }

    public String getAddress() {
        return address;
    }
}
