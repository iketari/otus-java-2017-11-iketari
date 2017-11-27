package ru.otus.l021;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.BitSet;

/**
 * VM options -Xmx512m -Xms512m
 * <p>
 * Runtime runtime = Runtime.getRuntime();
 * long mem = runtime.totalMemory() - runtime.freeMemory();
 * <p>
 * System.gc()
 * <p>
 * jconsole, connect to pid
 */
@SuppressWarnings({"RedundantStringConstructorCall", "InfiniteLoopStatement"})
public class Main {
    static Runtime runtime = Runtime.getRuntime();

    public static void main(String... args) throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

        System.out.println("Starting the loop");
        while (true) {
            System.gc();
            Thread.sleep(40);

            long initMeasurment = getAllocatedMemory();
            printMeasurment("init", initMeasurment);

            Object[] array = new Object[size];

            long refMeasurement = getAllocatedMemory();
            printMeasurment("reference", (refMeasurement - initMeasurment) / size);


            System.out.println("New array of size: " + array.length + " created");



            for (int i = 0; i < size; i++) {
                array[i] = new Object();
//                array[i] = new String(""); //String pool
//                array[i] = new String(new char[0]); //without String pool
//                array[i] = new MyClass();
//                array[i] = 0;
//                array[i] =  new BigDecimal("0.01");
                array[i] =  new BitSet(16);
            }

            long objMeasurement = getAllocatedMemory();
            printMeasurment(array[0].getClass().getName(), (objMeasurement - refMeasurement) / size);


            System.out.println("Created " + size + " objects.");
            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static void printMeasurment(String label, long value) {
        System.out.printf("%s %d%n", label, value);
    }

    private static long getAllocatedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static class MyClass {
        private int i = 0;
        private long l = 1;
        private short[] s = {1, 2, 3};
    }
}
