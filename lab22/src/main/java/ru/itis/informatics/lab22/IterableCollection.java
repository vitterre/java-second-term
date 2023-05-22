package ru.itis.informatics.lab22;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableCollection<E> implements Collection<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] data;
	private int size;

	public IterableCollection() {
		this(DEFAULT_CAPACITY);
	}

	public IterableCollection(int capacity) {
		this.data = new Object[capacity];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(obj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<E> {

		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return currentIndex < size;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E element = (E) data[currentIndex];
			currentIndex++;
			return element;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			return (T[]) Arrays.copyOf(data, size, a.getClass());
		}
		System.arraycopy(data, 0, a, 0, size);
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	@Override
	public boolean add(E obj) {
		if (size == data.length) {
			increaseCapacity();
		}
		data[size++] = obj;
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if (data[i].equals(obj)) {
				remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object o : c) {
			if (!contains(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean modified = false;
		for (E e : c) {
			if (add(e)) {
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean modified = false;
		for (Object o : c) {
			modified |= remove(o);
		}
		return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		boolean modified = false;
		Iterator<E> it = iterator();
		while (it.hasNext()) {
			E e = it.next();
			if (!c.contains(e)) {
				it.remove();
				modified = true;
			}
		}
		return modified;
	}

	@Override
	public void clear() {
		data = new Object[DEFAULT_CAPACITY];
		size = 0;
	}

	private void remove(int index) {
		System.arraycopy(data, index + 1, data, index, size - index - 1);
		data[--size] = null;
	}

	private void increaseCapacity() {
		int newCapacity = data.length * 2;
		data = Arrays.copyOf(data, newCapacity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; i++) {
			sb.append(data[i]);
			if (i != size - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
