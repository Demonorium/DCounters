package ru.demonorium.utils.counter;

import java.util.function.Supplier;

/**
 * Simple interface for simple counters
 */
public interface DCounter extends Supplier<Long> {
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
    Long get();

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
        return get() >= getMaxValue();
    }

    /**
     * Check if counter dont reaches maxValue
     *
     * @return false if counter reaches maxValue
     */
    default boolean isNotEnd() {
        return get() < getMaxValue();
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
