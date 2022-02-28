package dataStructrue;

import java.util.Arrays;

/**
 * @author jesse.hu
 * @date 2022/2/28 08:59
 * 使用数组实现一个简单栈
 */
public class ImplementStack {
    private int[] storage;
    private int capacity;  // 栈的容量
    private int count;    // 栈中元素数量
    private static final int GROW_FACTOR = 2;

    public ImplementStack() {
        this.capacity = 8;
        this.storage = new int[capacity];
        this.count = 0;
    }

    public ImplementStack(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("capacity too small");
        }
        this.capacity = capacity;
        this.storage = new int[capacity];
        this.count = 0;
    }

    public void push(int value) {
        if (count == capacity) {
            ensureCapacity();
        }
        storage[count++] = value;
    }

    private void ensureCapacity() {
        int newCapacity = capacity * GROW_FACTOR;
        storage = Arrays.copyOf(storage, newCapacity);
        capacity = newCapacity;
    }

    private int pop() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        count--;
        return storage[count];
    }

    private int peek() {
        if (count == 0) {
            throw new IllegalArgumentException("Stack is empty.");
        }
        return storage[count - 1];
    }

    private boolean isEmpty() {
        return count == 0;
    }

    private int size() {
        return count;
    }


}
