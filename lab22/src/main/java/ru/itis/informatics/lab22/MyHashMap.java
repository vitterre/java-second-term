package ru.itis.informatics.lab22;

public class MyHashMap<K, V> {

	private static final int DEFAULT_CAPACITY = 16;
	private static final double LOAD_FACTOR = 0.75;
	private int size;
	private int capacity;
	private Entry<K, V>[] entries;

	public MyHashMap() {
		this(DEFAULT_CAPACITY);
	}

	public MyHashMap(int capacity) {
		this.capacity = capacity;
		this.entries = new Entry[capacity];
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> entry = new Entry<>(key, value);
		if (entries[index] == null) {
			entries[index] = entry;
			size++;
		} else {
			Entry<K, V> curr = entries[index];
			while (curr != null) {
				if (curr.getKey().equals(key)) {
					curr.setValue(value);
					return;
				}
				curr = curr.getNext();
			}
			entry.setNext(entries[index]);
			entries[index] = entry;
			size++;
		}
		if ((double) size / capacity >= LOAD_FACTOR) {
			resize();
		}
	}

	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> curr = entries[index];
		while (curr != null) {
			if (curr.getKey().equals(key)) {
				return curr.getValue();
			}
			curr = curr.getNext();
		}
		return null;
	}

	public void remove(K key) {
		int index = getIndex(key);
		Entry<K, V> curr = entries[index];
		Entry<K, V> prev = null;
		while (curr != null) {
			if (curr.getKey().equals(key)) {
				if (prev == null) {
					entries[index] = curr.getNext();
				} else {
					prev.setNext(curr.getNext());
				}
				size--;
				return;
			}
			prev = curr;
			curr = curr.getNext();
		}
	}

	public int size() {
		return size;
	}

	private int getIndex(K key) {
		int hashCode = key.hashCode();
		return Math.abs(hashCode) % capacity;
	}

	private void resize() {
		capacity *= 2;
		Entry<K, V>[] newEntries = new Entry[capacity];
		for (Entry<K, V> entry : entries) {
			while (entry != null) {
				Entry<K, V> next = entry.getNext();
				int index = getIndex(entry.getKey());
				entry.setNext(newEntries[index]);
				newEntries[index] = entry;
				entry = next;
			}
		}
		entries = newEntries;
	}

	private static class Entry<K, V> {
		private final K key;
		private V value;
		private Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}
	}
}
