package org.example.stackqueue;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Integer> keyToValue; // Maps keys to its value
    private final Map<Integer, Integer> keyToFrequency; // Maps keys to its frequency
    private final Map<Integer, LinkedHashSet<Integer>> frequencyToKeys; // Maps frequency to keys with that frequency

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyToValue = new HashMap<>();
        this.keyToFrequency = new HashMap<>();
        this.frequencyToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFrequency(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFrequency(key);
            return;
        }
        if (keyToValue.size() == capacity) {
            evictLFUKey();
        }
        keyToValue.put(key, value);
        keyToFrequency.put(key, 1);
        frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        minFrequency = 1;
    }

    private void increaseFrequency(int key) {
        int freq = keyToFrequency.get(key);
        keyToFrequency.put(key, freq + 1);

        frequencyToKeys.get(freq).remove(key);
        if (frequencyToKeys.get(freq).isEmpty()) {
            frequencyToKeys.remove(freq);
            if (freq == minFrequency) {
                minFrequency++;
            }
        }

        frequencyToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    private void evictLFUKey() {

        LinkedHashSet<Integer> keys = frequencyToKeys.get(minFrequency);
        int keyToRemove = keys.iterator().next();
        keys.remove(keyToRemove);

        if (keys.isEmpty()) {
            frequencyToKeys.remove(minFrequency);
        }

        keyToValue.remove(keyToRemove);
        keyToFrequency.remove(keyToRemove);
    }
}
