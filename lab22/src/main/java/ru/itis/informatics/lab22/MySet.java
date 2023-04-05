package ru.itis.informatics.lab22;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;


/**
 * 1. Реализовать отмеченные методы
 * 2. Протестировать на классе в котором переопределен метод equals
 */
public class MySet<E> implements Set<E> {

	private int capacity = 1000;
	private int size;
	private E[] array;

	public MySet() {
		array = (E[]) new Object[capacity];
		size = 0;
	}

	// TODO
	@Override
	public int size() {
		return size;
	}

	// TODO
	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		} else {
			return false;
		}
	}

	// TODO
	@Override
	public boolean contains(Object o) {
		for(int i =0;i<size;i++) {
			if(array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	// TODO
	@Override
	public Object[] toArray() {
		return array.clone();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	// TODO - ! проверка на наличие (добавляем только новый объект)
	@Override
	public boolean add(E e) {
		for(int i =0;i<size;i++) {
			if(array[i].equals(e)) {
				return false;
			}
		}
		if (size == capacity) {
			return false;
		}
		array[size++] = e;

		return true;
	}

	// TODO (реализовать поиск объекта и, если нашли удалить его)
	@Override
	public boolean remove(Object o) {
		for(int i =0;i<size;i++) {
			if(array[i].equals(o)) {
				array[i] = null;
				size--;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	// TODO
	@Override
	public void clear() {
		for(int i =0;i<array.length;i++) {
			array[i]=null;
		}
		size=0;
	}
}