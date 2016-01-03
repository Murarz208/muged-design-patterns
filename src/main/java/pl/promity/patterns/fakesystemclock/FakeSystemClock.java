package pl.promity.patterns.fakesystemclock;

/**
 * Fake system clock for test purposes.
 */
public class FakeSystemClock implements SystemClock{

    private final long time;

    public FakeSystemClock(long time) {
        this.time = time;
    }

    @Override
    public long getCurrentTimeMillis() {
        return time;
    }
}
