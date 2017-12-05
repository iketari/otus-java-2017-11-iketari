package ru.otus.l031;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        myList = new MyArrayList<>(10);
        Integer[] expectedList = {2,3};

        myList.add(1);
        myList.add(2);
        myList.add(3);

        Integer removed = myList.remove(0);

        Assertions.assertArrayEquals(expectedList, myList.toArray());
        assertEquals(1, (int) removed);
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

    @Test
    @DisplayName("Collections.sort(list)")
    void sort() throws Exception {
        myList = new MyArrayList<>();
        Integer[] expectedList = {0,1,2,3,4,5};

        myList.add(2);
        myList.add(0);
        myList.add(3);
        myList.add(5);
        myList.add(1);
        myList.add(4);

        Collections.sort(myList);

        Assertions.assertArrayEquals(expectedList, myList.toArray());
    }

    @Nested
    @DisplayName("Collections.copy(list)")
    class Copy {

        @Test
        @DisplayName("Collections.copy(list)")
        void copy() throws Exception {
            myList = new MyArrayList<>();
            MyArrayList<Integer> destMyList = new MyArrayList<>();
            myList.add(1);
            myList.add(2);
            destMyList.add(0);
            destMyList.add(0);

            Collections.copy(destMyList, myList);

            Assertions.assertArrayEquals(myList.toArray(), destMyList.toArray());
        }

        @Test
        @DisplayName("Collections.copy(list) long")
        void copyLong() throws Exception {
            myList = new MyArrayList<>(110);
            List<Integer> destMyList = new MyArrayList<>(110);

            for (int i = 0; i < 110; i++) {
                myList.add(i);
                destMyList.add(i);
            }
            Collections.copy(destMyList, myList);

            Assertions.assertArrayEquals(myList.toArray(), destMyList.toArray());
        }

    }


}