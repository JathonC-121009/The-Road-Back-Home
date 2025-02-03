package main;

import java.util.Timer;
import java.util.TimerTask;

public class EventManager {

    private static EventManager instance;

    // Private constructor to enforce singleton
    public EventManager() {}

    // Thread-safe singleton implementation
    public static synchronized EventManager getInstance() {
        if (instance == null) {
            instance = new EventManager();
        }
        return instance;
    }

    /**
     * Triggers an event after a specified delay.
     *
     * @param event            The code to run after the delay.
     * @param delayMilliseconds The delay in milliseconds before executing the event.
     */
    public void triggerDelayedEvent(Runnable event, int delayMilliseconds) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    event.run(); // Execute the provided event
                } finally {
                    timer.cancel(); // Ensure the timer is canceled to release resources
                }
            }
        }, delayMilliseconds);
    }
}