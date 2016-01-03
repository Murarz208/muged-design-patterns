package pl.promity.patterns.fakesystemclock;

/**
 * Default system clock
 */
public class DefaultSystemClock implements SystemClock {
    @Override
    public long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
