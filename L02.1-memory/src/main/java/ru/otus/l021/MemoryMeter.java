package ru.otus.l021;

import jdk.nashorn.internal.objects.annotations.Function;

import java.lang.management.ManagementFactory;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class MemoryMeter {

    private String label;
    private Runtime runtime = Runtime.getRuntime();
    private Callable<Object> fn;

    public MemoryMeter(Callable<Object> fn) {
        try {
            Object obj = fn.call();
            this.label = obj.getClass().getName();
        } catch (Exception e) {
            System.out.println(e);
        }

        this.fn = fn;
    };

    public long meter() throws InterruptedException {
        int size = 20_000_000;
        System.gc();
        Thread.sleep(40);

        Object[] array = new Object[size];

        long refMeasurement = getAllocatedMemory();

        for (int i = 0; i < size; i++) {
            try {
                array[i] = fn.call();
            } catch (Exception e) {
                System.out.println(e);
                return 0;
            }
        }

        return (getAllocatedMemory() - refMeasurement) / size;
    }

    public String getLabel() {
        return label;
    }

    private long getAllocatedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
