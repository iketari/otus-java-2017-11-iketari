package ru.otus.l031;

import java.util.*;

/**
 * Created by Artsiom Mezin.
 *
 * Home work 3 - Implementation of ArrayList
 *
 */


public class MyArrayList<T> implements List<T>, RandomAccess {

    private Object[] arr;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    MyArrayList(int capacity) {
        initializeWithCapacity(capacity);
    }

    MyArrayList() {
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

    public void add(int index, T element) {
        if (size + 1 >= arr.length) {
            allocateSize();
        }

        System.arraycopy(arr, index, arr, index + 1,
                size - index);

        arr[index] = element;
        size++;
    }

    public T get(int index) {
        return elementData(index);
    }

    private void initializeWithCapacity(int capacity) {
        this.arr = new Object[capacity];
        this.size = 0;
    }

    private void allocateSize() {
        int oldLength = arr.length;
        int newLength = oldLength + (oldLength >> 2);

        arr = Arrays.copyOf(arr, newLength);
    }

    T elementData(int index) {
        return (T) arr[index];
    }

    public boolean addAll(Collection<? extends T> c) {
        c.forEach(elem -> add((elem)));

        return true;
    }

    public T remove(int index) {
        T removedValue = elementData(index);

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(arr, index+1, arr, index,
                    numMoved);

        arr[--size] = null;

        return removedValue;
    }

    public T set(int index, T element) {
        T oldValue = elementData(index);
        arr[index] = element;
        return oldValue;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public T[] toArray() {
        return Arrays.copyOf((T[]) arr, size());
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @SuppressWarnings("unchecked")
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) arr, 0, size, c);
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

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return new ListItr(size);
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }


    private class ListItr implements ListIterator<T> {
        int cursor;
        int lastRet = -1;

        ListItr(int index) {
            cursor = index;
        }

        public boolean hasNext() {
            return cursor != size;
        }

        public boolean hasPrevious() {
            return cursor != 0;
        }

        public int nextIndex() {
            return cursor;
        }

        public int previousIndex() {
            return cursor - 1;
        }


        public void set(T e) {
            if (lastRet < 0)
                throw new IllegalStateException();

            MyArrayList.this.set(lastRet, e);
        }

        @SuppressWarnings("unchecked")
        public T next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.arr;
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        @SuppressWarnings("unchecked")
        public T previous() {
            int i = cursor - 1;
            if (i < 0)
                throw new NoSuchElementException();
            Object[] elementData = MyArrayList.this.arr;

            cursor = i;
            return (T) elementData[lastRet = i];
        }

        public void add(T e) {
            int i = cursor;
            MyArrayList.this.add(i, e);
            cursor = i + 1;
            lastRet = -1;
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();

            MyArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
}

