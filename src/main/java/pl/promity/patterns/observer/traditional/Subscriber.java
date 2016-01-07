package pl.promity.patterns.observer.traditional;

import java.util.Observable;
import java.util.Observer;

/**
 * The one who is notified about changes
 */
public class Subscriber implements Observer {

    private Object updateData;

    public Subscriber() {
        updateData = null;
    }

    @Override
    public void update(Observable observable, Object updateObject) {
        System.out.println("Hi! I was traditionally updated with following data : " + updateObject);
        this.updateData = updateObject;
    }

    public Object getUpdateData(){
        return updateData;
    }
}
