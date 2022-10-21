package ru.demonorium.utils.counter;

/**
 * Simple interface for simple counters
 */
public interface DCounter {
    /**
     * Max value of counter
     *
     * @return max value
     */
    long getMaxValue();

    /**
     * Current state of counter
     *
     * @return current value
     */
    long getValue();

    /**
     * Increment and get new value of counter
     *
     * @return new value of counter
     */
    long inc();

    /**
     * Check if counter reaches maxValue
     *
     * @return true if counter reaches maxValue
     */
    default boolean isEnd() {
        return getValue() >= getMaxValue();
    }

    /**
     * Check if counter dont reaches maxValue
     *
     * @return false if counter reaches maxValue
     */
    default boolean isNotEnd() {
        return getValue() < getMaxValue();
    }

    /**
     * increment and return result equals to isEnd()
     *
     * @return result of call isEnd()
     */
    default boolean incAndTest() {
        return inc() >= getMaxValue();
    }
}
