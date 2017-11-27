package ru.otus.l021;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Constructor;

public class MemoryMeter {

    static Runtime runtime = Runtime.getRuntime();

    public static void meter (Class cls)  throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

        System.out.println("Starting the loop");
        while (true) {
            System.gc();
            Thread.sleep(40);

            long initMeasurment = getAllocatedMemory();
            printMeasurement("init", initMeasurment);

            Object[] array = new Object[size];

            long refMeasurement = getAllocatedMemory();
            printMeasurement("reference", (refMeasurement - initMeasurment) / size);


            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                try {
                    array[i] = cls.newInstance();
                } catch (InstantiationException ex) {
                    System.out.println("Strange java exception:> " + ex);
                } catch (IllegalAccessException ex) {
                    System.out.println("Another one strange java exception:> " + ex);
                }
            }

            long objMeasurement = getAllocatedMemory();
            printMeasurement(cls.getName(), (objMeasurement - refMeasurement) / size );


            System.out.println("Created " + size + " objects.");
            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private static void printMeasurement(String label, long value) {
        System.out.printf("%s %d%n", label, value);
    }

    private static long getAllocatedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
