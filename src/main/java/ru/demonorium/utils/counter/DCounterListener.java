package ru.demonorium.utils.counter;

import ru.demonorium.concepts.function.procv.ProcedureA1V;

import java.io.Serializable;
import java.util.function.Consumer;

public class DCounterListener implements DCounter, Serializable {
    private DCounter counter;
    private ProcedureA1V<DCounter> onEnd;
    private ProcedureA1V<DCounter> onInc;

    public <T extends Serializable & ProcedureA1V<DCounter>> DCounterListener(DCounter counter, T onEnd) {
        this.counter = counter;
        this.onEnd = onEnd;
    }

    public <T1 extends Serializable & ProcedureA1V<DCounter>, T2 extends Serializable & ProcedureA1V<DCounter>> DCounterListener(DCounter counter, T1 onEnd, T2 onInc) {
        this.counter = counter;
        this.onEnd = onEnd;
        this.onInc = onInc;
    }

    @Override
    public long inc() {
        long value = counter.inc();

        if (value >= getMaxValue()) {
            onEnd.call(counter);
        } else {
            onInc.call(counter);
        }

        return value;
    }

    public ProcedureA1V<DCounter> getOnEnd() {
        return onEnd;
    }

    public void setOnEnd(ProcedureA1V<DCounter> onEnd) {
        this.onEnd = onEnd;
    }

    public ProcedureA1V<DCounter> getOnInc() {
        return onInc;
    }

    public void setOnInc(ProcedureA1V<DCounter> onInc) {
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
    public Long get() {
        return counter.get();
    }
}
