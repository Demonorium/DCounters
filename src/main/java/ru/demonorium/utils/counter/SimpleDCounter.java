package ru.demonorium.utils.counter;

import java.io.Serializable;

public class SimpleDCounter implements DCounter, Serializable {
    private long value;
    private long maxValue;

    public SimpleDCounter(long maxValue) {
        assert (maxValue >= 0);
        this.maxValue = maxValue;
        reset();
    }

    protected SimpleDCounter() {}

    @Override
    public long getMaxValue() {
        return maxValue;
    }

    @Override
    public Long get() {
        return value;
    }

    @Override
    public long inc() {
        return ++value;
    }

    public void reset() {
        setValue(0);
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }
}
