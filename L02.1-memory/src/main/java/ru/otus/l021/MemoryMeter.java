package ru.otus.l021;

import java.lang.management.ManagementFactory;
import java.util.function.Supplier;

public class MemoryMeter {

    private Supplier supplier;
    private String label;
    private Runtime runtime = Runtime.getRuntime();

    public MemoryMeter(Supplier<Object> supplier, String label) {
        this.label = label;
        this.supplier = supplier;
    };

    public void meter() throws InterruptedException {
        System.out.println("pid: " + ManagementFactory.getRuntimeMXBean().getName());

        int size = 20_000_000;

        System.out.println("Starting the loop");
        while (true) {
            System.gc();
            Thread.sleep(40);

            long initMeasurement = getAllocatedMemory();
            printMeasurement("init", initMeasurement);

            Object[] array = new Object[size];

            long refMeasurement = getAllocatedMemory();
            printMeasurement("reference", (refMeasurement - initMeasurement) / size);


            System.out.println("New array of size: " + array.length + " created");
            for (int i = 0; i < size; i++) {
                array[i] = supplier.get();
            }

            long objMeasurement = getAllocatedMemory();
            printMeasurement(this.label, (objMeasurement - refMeasurement) / size );


            System.out.println("Created " + size + " objects.");
            Thread.sleep(1000); //wait for 1 sec
        }
    }

    private void printMeasurement(String label, long value) {
        System.out.printf("%s %d%n", label, value);
    }

    private long getAllocatedMemory() {
        return runtime.totalMemory() - runtime.freeMemory();
    }
}
