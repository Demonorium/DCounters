package ru.demonorium.utils.counter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class DCounterTest {
    void testCounterDirect(DCounter counter, long step) {
        long acc = counter.get();
        while (!counter.incAndTest()) {
            acc += step;
        }

        Assertions.assertEquals(counter.getMaxValue(), acc + step);
        Assertions.assertTrue(counter.isEnd());
    }

    void testWithListener(DCounter counter, long step) {
        AtomicLong acc = new AtomicLong();
        AtomicBoolean endCounter = new AtomicBoolean(false);
        DCounterListener listener = new DCounterListener(counter,
                (cnt) -> {
                    Assertions.assertFalse(endCounter.get());
                    endCounter.set(true);
                },
                (cnt) -> {
                    acc.addAndGet(step);
                });

        testCounterDirect(listener, step);

        Assertions.assertEquals(listener.getMaxValue(), acc.get() + step);
        Assertions.assertTrue(listener.isEnd());
    }

    @Test
    void testSimpleCounter() {
        testCounterDirect(new SimpleDCounter(10), 1);
        testWithListener(new SimpleDCounter(10), 1);
    }

    @Test
    void testLoopedCounter() {
        testCounterDirect(new LoopedDCounter(10), 1);
        testWithListener(new LoopedDCounter(10), 1);
    }

    @Test
    void testSimpleStepCounter() {
        testCounterDirect(new SimpleStepDCounter(10, 5), 5);
        testWithListener(new SimpleStepDCounter(10, 5), 5);
    }

    @Test
    void testLoopedStepCounter() {
        testCounterDirect(new LoopedStepDCounter(10, 5), 5);
        testWithListener(new LoopedStepDCounter(10, 5), 5);
    }
}
