package ru.dolya.solve.it;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> map;
    int capacity;
    LinkedList<Integer> queue = new LinkedList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public void get(int key) {
        Integer val = map.get(key);
        if (val != null) {
            queue.removeFirstOccurrence(key);
            queue.addLast(key);
        }
    }

    public void put(int key, int value) {
        Integer val = map.get(key);
        if (val == null && map.size() == capacity) {
            Integer integer = queue.removeFirst();
            map.remove(integer);
        } else {
            queue.removeFirstOccurrence(key);
        }
        map.put(key, value);
        queue.addLast(key);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 1);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.put(3, 1);
        lruCache.get(1);

        lruCache.put(4, 1);

        System.out.println();
    }
}
