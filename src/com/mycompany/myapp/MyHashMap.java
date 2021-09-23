package com.mycompany.myapp;

import java.util.HashSet;
import java.util.Set;

public class MyHashMap<K, V> {
        private Entry<K, V>[] buckets = new Entry[16];

        static class Entry<K, V> {
            K key;
            V value;
            Entry<K, V> next;

            public Entry(K key, V value, Entry<K, V> next) {
                this.key = key;
                this.value = value;
                this.next = next;
            }
        }

    private int getIndex(K key) {
        return key.hashCode() % buckets.length;
    }

        public void put(K key, V value) {
            if (key == null)
                return;
            int hash = getIndex(key);
            Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
            if (buckets[hash] == null) {
                buckets[hash] = newEntry;
            } else {
                Entry<K, V> previous = null;
                Entry<K, V> current = buckets[hash];

                while (current != null) {
                    if (current.key.equals(key)) {
                        if (previous == null) {
                            newEntry.next = current.next;
                            buckets[hash] = newEntry;
                            return;
                        } else {
                            newEntry.next = current.next;
                            previous.next = newEntry;
                            return;
                        }
                    }
                    previous = current;
                    current = current.next;
                }
                previous.next = newEntry;
            }
        }

        public V get(K key) {
            int hash = getIndex(key);
            if (buckets[hash] == null) {
                return null;
            } else {
                Entry<K, V> temp = buckets[hash];
                while (temp != null) {
                    if (temp.key.equals(key))
                        return temp.value;
                    temp = temp.next;
                }
                return null;
            }
        }

        public boolean containsKey(K key) {
            int hash = getIndex(key);
            if (buckets[hash] == null) {
                return false;
            } else {
                Entry<K, V> temp = buckets[hash];
                while (temp != null) {
                    if (temp.key.equals(key))
                        return true;
                    temp = temp.next;
                }
            }
            return false;
        }

        public Set<K> keySet() {
            Set<K> temp = new HashSet<>();
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    Entry<K, V> entry = buckets[i];
                    while (entry != null) {
                        temp.add(entry.key);
                        entry = entry.next;
                    }
                }
            }
            return temp;
        }
    }
