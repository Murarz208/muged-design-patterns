package pl.promity.patterns.observer.guava;

import com.google.common.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import pl.promity.patterns.common.UserData;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Created by Maciek on 2016-01-03.
 */
public class GuavaEventBusTest {

    private EventBusSubscriber eventBusSubscriber;
    private EventBus eventBus;

    @Before
    public void setUp() throws Exception {
        this.eventBusSubscriber = new EventBusSubscriber();
        this.eventBus = new EventBus();
        this.eventBus.register(this.eventBusSubscriber);
    }

    @Test
    public void testAddressNotification() throws Exception {
        //given
        String address = "1187 Hartford Road Dothan, AL 36301";

        //when
        eventBus.post(address);

        //then
        String updatedAddress = this.eventBusSubscriber.getAddress();
        assertThat(updatedAddress).isNotNull().isEqualTo(address);
    }

    @Test
    public void testUserDataNotification() throws Exception {
        //given
        UserData userData = new UserData(55, "steve.jobs", "Steven Jobs", "666 Hell");

        //when
        eventBus.post(userData);

        //then
        UserData updatedUserData =  this.eventBusSubscriber.getUserData();
        assertThat(updatedUserData).isNotNull().isEqualTo(userData);
    }

    @Test
    public void testNotificationWithNoListeners() throws Exception {
        //given
        DeadEndListener deadEndListener = new DeadEndListener();
        Integer dataForUpdate = 12;
        this.eventBus.register(deadEndListener);

        //when
        eventBus.post(dataForUpdate);

        //then
        Object updatedData = deadEndListener.getDeadEventSource();
        assertThat(updatedData).isNotNull().isEqualTo(dataForUpdate);
    }


}