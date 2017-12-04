package ru.otus.l031;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;

@DisplayName("ArrayList")
class MyArrayListTest {
    MyArrayList<Integer> myList;

    @Test
    @DisplayName("is instantiated with new MyArrayList()")
    void isInstantiatedWithNew() {
        new MyArrayList<>();
    }


    @Test
    void size() throws Exception {
       myList = new MyArrayList<>(10);
       assertEquals(0, myList.size());

       myList.add(1);
       assertEquals(1, myList.size());
    }

    @Test
    void isEmpty() throws Exception {
        myList = new MyArrayList<>(10);
        assertEquals(true, myList.isEmpty());

        myList.add(1);
        assertEquals(false, myList.isEmpty());
    }

    @Nested
    @DisplayName("contains()")
    class Contains {
        @BeforeEach
        void createNewList () {
            myList = new MyArrayList<>(10);

            myList.add(1);
            myList.add(2);
            myList.add(3);
        }

        @Test
        @DisplayName("contains")
        void containsTrue() {
            assertTrue(myList.contains(3));
        }

        @Test
        @DisplayName("not contains")
        void containsFalse() {
            assertFalse(myList.contains(4));
        }

    }

    @Test
    void add() throws Exception {
        myList = new MyArrayList<>(10);
        myList.add(1);
        myList.add(2);
        myList.add(3);

        int first = myList.get(0);
        int second = myList.get(1);

        assertEquals(1, first);
        assertEquals(2, second);
    }

    @Test
    void remove() throws Exception {
    }

    @Test
    void addAll() throws Exception {
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