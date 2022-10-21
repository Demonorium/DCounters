package ru.demonorium.utils.counter;

import java.io.Serializable;

public class LoopedDCounter extends SimpleDCounter implements Serializable {
    public LoopedDCounter(long maxValue) {
        super(maxValue);
    }

    protected LoopedDCounter() {
    }

    @Override
    public long inc() {
        if (isEnd()) {
            reset();
            return getValue();
        } else {
            return super.inc();
        }
    }
}
