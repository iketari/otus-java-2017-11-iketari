package ru.otus.l021;

import java.lang.management.ManagementFactory;
import java.util.function.Supplier;

/**
 * Created by Artsiom Mezin
 *
 * HW2 Otus 11 2017
 * Memory Measurements
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    public static void main(String... args) throws InterruptedException {

        MemoryMeter measurement = new MemoryMeter(
                new Supplier<Object>() {
                    @Override
                    public String get() {
                        return new String("abc");
                    }
                },
                "String"
        );

        measurement.meter();
    }
}
