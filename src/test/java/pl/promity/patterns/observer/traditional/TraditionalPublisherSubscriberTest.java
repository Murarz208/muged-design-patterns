package pl.promity.patterns.observer.traditional;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * Learning test for traditional publisher/subscriber
 */
public class TraditionalPublisherSubscriberTest {

    private Subscriber subscriber;
    private Publisher publisher;


    @Before
    public void setUp() throws Exception {
        this.subscriber = new Subscriber();
        this.publisher = new Publisher();
        this.publisher.addObserver(subscriber);
    }

    @Test
    public void testNotification() throws Exception {
        //given

        //when
        publisher.markAsChanged();
        publisher.notifyObservers();

        //then
        Object receivedData = this.subscriber.getUpdateData();
        assertThat(receivedData).isNull();
    }

    @Test
    public void testNotificationWithoutMarkingAsChanged() throws Exception {
        //given

        //when
        publisher.notifyObservers();

        //then
        Object receivedData = this.subscriber.getUpdateData();
        assertThat(receivedData).isNull();
    }

    @Test
    public void testNotificationWithData() throws Exception {
        //given
        String updateData = "secret";

        //when
        publisher.markAsChanged();
        publisher.notifyObservers(updateData);

        //then
        Object receivedData = this.subscriber.getUpdateData();
        assertThat(receivedData).isNotNull().isEqualTo(updateData);
    }
}