package ru.demonorium.utils.counter;

import java.io.Serializable;

public class SimpleStepDCounter implements DCounter, Serializable {
    private long value;
    private long maxValue;
    private long step;

    public SimpleStepDCounter(long maxValue, long step) {
        this.maxValue = maxValue;
        this.step = step;
        reset();
    }

    protected SimpleStepDCounter() {}


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
        return value += step;
    }

    public void reset() {
        setValue(0);
    }

    public long getStep() {
        return step;
    }

    public void setStep(long step) {
        this.step = step;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void setMaxValue(long maxValue) {
        this.maxValue = maxValue;
    }
}
