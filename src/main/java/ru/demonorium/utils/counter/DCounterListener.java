package ru.demonorium.utils.counter;

import java.io.Serializable;
import java.util.function.Consumer;

public class DCounterListener implements DCounter, Serializable {
    private DCounter counter;
    private Consumer<DCounter> onEnd;
    private Consumer<DCounter> onInc;

    public <T extends Serializable & Consumer<DCounter>> DCounterListener(DCounter counter, T onEnd) {
        this.counter = counter;
        this.onEnd = onEnd;
    }

    public <T1 extends Serializable & Consumer<DCounter>, T2 extends Serializable & Consumer<DCounter>> DCounterListener(DCounter counter, T1 onEnd, T2 onInc) {
        this.counter = counter;
        this.onEnd = onEnd;
        this.onInc = onInc;
    }

    @Override
    public long inc() {
        long value = counter.inc();

        if (value >= getMaxValue()) {
            onEnd.accept(counter);
        } else {
            onInc.accept(counter);
        }

        return value;
    }

    public Consumer<DCounter> getOnEnd() {
        return onEnd;
    }

    public void setOnEnd(Consumer<DCounter> onEnd) {
        this.onEnd = onEnd;
    }

    public Consumer<DCounter> getOnInc() {
        return onInc;
    }

    public void setOnInc(Consumer<DCounter> onInc) {
        this.onInc = onInc;
    }

    public DCounter getCounter() {
        return counter;
    }

    public void setCounter(DCounter counter) {
        this.counter = counter;
    }

    @Override
    public long getMaxValue() {
        return counter.getMaxValue();
    }

    @Override
    public long getValue() {
        return counter.getValue();
    }
}
