package pl.promity.patterns.observer.traditional;

import java.util.Observable;

/**
 * The one who keeps subscribes and notify them about changes
 */
public class Publisher extends Observable {

    /**
     * Before notifying observers we need to change 'changed' flag in upper class
     */
    public void markAsChanged(){
        this.setChanged();
    }

}
