package ru.otus.l031;

import java.util.*;

public class MyArrayList<T> implements List<T> {

    private Object[] arr;
    private int size;
    private int capacity;

    private static int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        initializeWithCapacity(capacity);
    }

    public MyArrayList() {
        initializeWithCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {
        for (int i = 0; i < this.size; i++) {
            if (o.equals(this.arr[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean add(T t) {
        if (size + 1 >= arr.length) {
            allocateSize();
        }

        arr[size++] = t;

        return true;
    }

    public T get(int index) {
        return (T) arr[index];
    }

    private void initializeWithCapacity(int capacity) {
        this.arr = new Object[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    private void allocateSize() {
        Object[] currentArray = arr;
        size = size + size >> 2;
        arr = new Object[size];

        for (int i = 0; i < currentArray.length; i++) {
            arr[i] = currentArray[i];
        }
    }

    public boolean addAll(Collection<? extends T> c) {
        Object[] a = c.toArray();

        for (int i = 0; i < a.length; i++) {
            add((T) a[i]);
        }

        return true;
    }

    public T remove(int index) {
        return null;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public boolean equals(Object o) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {

    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
