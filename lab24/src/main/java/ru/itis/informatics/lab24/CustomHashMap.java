package ru.itis.informatics.lab24;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CustomHashMap implements IMap {

	private List<Entry>[] buckets;
	private int size;

	public CustomHashMap() {
		buckets = new List[16];
		for (int i = 0; i < 16; i++) {
			buckets[i] = new ArrayList<>();
		}
		size = 0;
	}

	@Override
	public void put(String key, Integer value) {
		int hash = Math.abs(key.hashCode()) % buckets.length;
		List<Entry> bucket = buckets[hash];
		for (Entry entry : bucket) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
		bucket.add(new Entry(key, value));
		size++;
	}

	@Override
	public Integer getValueByKey(String key) {
		int hash = Math.abs(key.hashCode()) % buckets.length;
		List<Entry> bucket = buckets[hash];
		for (Entry entry : bucket) {
			if (entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	@Override
	public List<String> getKeysByValue(Integer value) {
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			List<Entry> bucket = buckets[i];
			for (Entry entry : bucket) {
				if (entry.value.equals(value)) {
					keys.add(entry.key);
				}
			}
		}
		return keys;
	}

	@Override
	public void removeByKey(String key) {
		int hash = Math.abs(key.hashCode() % buckets.length);
		List<Entry> bucket = buckets[hash];
		Iterator<Entry> iterator = bucket.iterator();
		while (iterator.hasNext()) {
			Entry entry = iterator.next();
			if (entry.key.equals(key)) {
				iterator.remove();
				size--;
				return;
			}
		}
	}

	@Override
	public void removeByValue(Integer value) {
		for (int i = 0; i < buckets.length; i++) {
			List<Entry> bucket = buckets[i];
			Iterator<Entry> iterator = bucket.iterator();
			while (iterator.hasNext()) {
				Entry entry = iterator.next();
				if (entry.value.equals(value)) {
					iterator.remove();
					size--;
				}
			}
		}
	}

	@Override
	public List<String> getAllKeys() {
		List<String> keys = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			List<Entry> bucket = buckets[i];
			for (Entry entry : bucket) {
				keys.add(entry.key);
			}
		}
		return keys;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < buckets.length; i++) {
			sb.append(i).append(": ");
			for (Entry entry : buckets[i]) {
				sb.append("{").append(entry.key).append(": ").append(entry.value).append("}");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private static class Entry {
		private String key;
		private Integer value;

		private Entry(String key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}
}
