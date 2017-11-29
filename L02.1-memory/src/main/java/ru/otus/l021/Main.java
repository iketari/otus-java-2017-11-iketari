package ru.otus.l021;

import java.util.concurrent.Callable;


/**
 * Created by Artsiom Mezin
 *
 * HW2 Otus 11 2017
 * Memory Measurements
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {

    static Callable[] srcArray = {
            () -> new String("abc"),
            () -> new String(""),
            () -> new Integer(0),
            () -> new Long(0),
            () -> new Object(),
            () -> {
                int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                return arr;
            },
            () -> {
                int[] arr = {1, 2, 3, 4, 5, 6, 7};
                return arr;
            },
            () -> {
                int[] arr = {1};
                return arr;
            },
            () -> {
                int[] arr = {};
                return arr;
            },

    };

    public static void main(String... args) throws InterruptedException {

        for (short i = 0; i < srcArray.length; i++) {
            MemoryMeter stringMeter = new MemoryMeter(srcArray[i]);

            System.out.printf("%s size is %d%n", stringMeter.getLabel(), stringMeter.meter());
        }
    }
}
