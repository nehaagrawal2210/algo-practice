package practice;

import java.util.HashMap;
import java.util.Map;

public class CustomHashMap<K, V> {

    private Entry<K, V>[] table;
    private int size;
    public static final int CAPACITY = 100;

    public CustomHashMap() {
        this.table = new Entry[CAPACITY];
    }

    public V put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Key and Value cannot be null");
        }
        V result = null;
        int hashLocation = hash(key.hashCode());
        if (hashLocation > CAPACITY) {
            throw new UnsupportedOperationException("Incorrect Hashing");
        }
        Entry<K, V> entry = table[hashLocation];
        if (entry != null && entry.getKey().equals(key)) {
            result = entry.getValue();
            entry.setValue(value);
        } else {
            table[hashLocation] = new Entry<>(key, value);
            size++;
        }
        return result;
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("Null Key not allowed");
        }
        int hashLocation = hash(key.hashCode());
        if (hashLocation > CAPACITY) {
            throw new UnsupportedOperationException("Rehashing required");
        }
        Entry<K, V> entry = table[hashLocation];
        V result = null;
        if (entry != null && entry.getKey().equals(key)) {
            result = entry.getValue();
        }
        return result;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new NullPointerException("Null Key not Supported");
        }
        int location = hash(key.hashCode());
        Entry<K, V> entry = table[location];
        if (entry != null && entry.getKey().equals(key)) {
            return true;
        }
        return false;
    }

    public boolean containsValue(V val) {
        for (int i = 0; i < size; i++) {
            Entry<K, V> entry = table[i];
            if (entry != null && entry.getValue().equals(val)) {
                return true;
            }
        }
        return false;
    }

    public V remove(K key) {
        int location = hash(key.hashCode());
        V result = null;
        Entry<K, V> entry = table[location];
        if (entry != null && entry.getKey().equals(key)) {
            result = entry.getValue();
            for (int i = location; i < size && i < CAPACITY - 1; i++) {
                table[i] = table[i + 1];
            }
        }
        return result;
    }

    private int hash(int hashCode) {
        int location = hashCode % CAPACITY;
        return location;
    }

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(null, "NUllTest");
    }
}


class Entry<K, V> {
    K key;
    V value;

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }
}



