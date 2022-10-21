package ru.demonorium.utils.counter;

import java.io.Serializable;

public class LoopedStepDCounter extends SimpleStepDCounter implements Serializable {
    public LoopedStepDCounter(long maxValue, long step) {
        super(maxValue, step);
    }

    protected LoopedStepDCounter() {
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
