package pl.promity.patterns.observer.guava;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * Dead end listener for guava event bus, listens when some message was not delivered
 */
public class DeadEndListener {

    private Object deadEventSource;

    @Subscribe
    public void messageNotDelivered(DeadEvent deadEvent){
        System.out.println("Hi! I was ear that no one received this following message : " + deadEvent.getEvent());
        this.deadEventSource = deadEvent.getEvent();
    }

    public Object getDeadEventSource() {
        return deadEventSource;
    }

}
