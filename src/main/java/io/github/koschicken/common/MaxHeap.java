package io.github.koschicken.common;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> {

    private final ArrayList<E> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        heap = new ArrayList<>(capacity);
    }

    public MaxHeap(List<E> list) {
        heap = new ArrayList<>(list);
        for (int i = parent(heap.size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void add(E e) {
        heap.add(e);
        siftUp(heap.size() - 1);
    }

    /**
     * 如果k位置的值比父节点大，就交换位置
     */
    private void siftUp(int k) {
        while (k > 0 && heap.get(parent(k)).compareTo(heap.get(k)) < 0) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    public E find(int k) {
        return heap.get(k);
    }

    public E remove() {
        E e = find(0);
        swap(0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        siftDown(0);
        return e;
    }

    /**
     * 判断当前节点的左右节点是否存在，找出其中最大的，和当前节点交换
     */
    private void siftDown(int k) {
        while (left(k) < heap.size()) {
            int i = left(k);
            if (i + 1 < heap.size() && heap.get(i).compareTo(heap.get(i + 1)) < 0) {
                i = right(k);
            }
            if (heap.get(k).compareTo(heap.get(i)) >= 0) {
                break;
            }
            swap(k, i);
            k = i;
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return i * 2 + 1;
    }

    private int right(int i) {
        return i * 2 + 2;
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
