package datastructure;

import java.util.Arrays;

public class Heap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 16;

    private Object[] heap;
    private int size = 0;

    public Heap() {
        this.heap = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer(T e) {
        if (e == null) throw new IllegalArgumentException();
        if (size >= heap.length) expandHeap();

        int i = size;
        heap[i] = e;

        while (i > 0) {
            int pi = (i - 1) >> 1;
            Object p = heap[pi];

            if (e.compareTo((T) p) < 0) { // elem < parent
                heap[i] = p;
                heap[pi] = e;
            }

            i = pi;
        }

        size++;

        return true;
    }

    private void expandHeap() {
        heap = Arrays.copyOf(heap, heap.length * 2);
    }

    public T poll() {
        T returnValue = (T) heap[0];

        heap[0] = heap[size - 1];

        int i = 0;
        int ri = (i + 1) * 2;
        int li = ri - 1;

        Object left = heap[li];
        Object right = heap[ri];


        size--;

        return null;
    }

    public T peek() {
        return (T) heap[0];
    }
}
