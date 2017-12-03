package ru.otus.l031;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MyArrayListTest {
    MyArrayList<Integer> myList;

    @org.junit.Test
    public void size() throws Exception {
       myList = new MyArrayList<>(10);
       assertEquals(0, myList.size());

       myList.add(1);
       assertEquals(1, myList.size());
    }

    @org.junit.Test
    public void isEmpty() throws Exception {
        myList = new MyArrayList<>(10);
        assertEquals(true, myList.isEmpty());

        myList.add(1);
        assertEquals(false, myList.isEmpty());
    }

    @org.junit.Test
    public void contains() throws Exception {
        myList = new MyArrayList<>(10);
        myList.add(1);
        myList.add(2);
        myList.add(3);

        myList.contains(3);

        assertEquals(true, myList.contains(3));
        assertEquals(false, myList.contains(4));
    }

    @org.junit.Test
    public void add() throws Exception {
        myList = new MyArrayList<>(10);
        myList.add(1);
        myList.add(2);
        myList.add(3);

        int first = myList.get(0);
        int second = myList.get(1);

        assertEquals(1, first);
        assertEquals(2, second);
    }

    @org.junit.Test
    public void remove() throws Exception {
    }

    @org.junit.Test
    public void addAll() throws Exception {
        myList = new MyArrayList<>(10);
        ArrayList<Integer> listToAdd = new ArrayList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);

        listToAdd.add(4);
        listToAdd.add(5);
        listToAdd.add(6);

        myList.addAll(listToAdd);

        assertEquals(6, myList.size());
    }

}