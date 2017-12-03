package ru.otus.l031;

import java.util.ArrayList;

public class Main {
    static MyArrayList<Integer> myIntList;
    static ArrayList<Integer> intList;
    public static void main(String[] args) {
        myIntList = new MyArrayList<Integer>(10);
        intList = new ArrayList<Integer>();

        intList.add(10);
        myIntList.add(10);

        System.out.printf("ArrayList size: %d, arr[0]: %d%n", intList.size(), intList.get(0));
        System.out.printf("MyArrayList size: %d, arr[0]: %d%n", myIntList.size(), myIntList.get(0));
    }
}
