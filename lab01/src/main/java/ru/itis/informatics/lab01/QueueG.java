package ru.itis.informatics.lab01;

public final class QueueG<T> {

	/*----- Inner types -----*/

	private static final class Node {
		Object data;
		Node next;
	}


	/*----- Fields -----*/

	/**
	 * The first element in the queue.
	 */
	private Node front;

	/**
	 * The last element in the queue.
	 */
	private Node rear;

	/**
	 * The size of the queue.
	 */
	private int queueSize;


	/*----- Constructors -----*/

	public QueueG() {
		front = null;
		rear = null;
		queueSize = 0;
	}


	/*----- Public methods -----*/

	/**
	 * Checks if queue is empty.
	 *
	 * @return is queue empty
	 */
	public boolean isEmpty() {
		return queueSize == 0;
	}

	/**
	 * Removes item from the front of the queue.
	 *
	 * @return removed value
	 */
	public T remove() {
		Object data = front.data;
		front = front.next;

		if (isEmpty()) {
			rear = null;
		}

		queueSize--;

		return (T)data;
	}

	/**
	 * Adds data at the rear of the queue.
	 */
	public void add(final T data) {
		final Node oldRear = rear;
		rear = new Node();
		rear.data = data;
		rear.next = null;

		if (isEmpty()) {
			front = rear;
		} else {
			oldRear.next = rear;
		}

		queueSize++;
	}

	/**
	 * Returnes the end of the queue.
	 * 
	 * @return the end of the queue
	 */
	public T back() {
		return queueSize > 0 ? (T)rear.data : null;
	}

	/**
	 * Returnes the head of the queue.
	 * 
	 * @return the head of the queue
	 */
	public T front() {
		return queueSize > 0 ? (T)front.data : null;
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();

		stringBuilder.append("[");

		Node currentFront = front;
		for (int i = 0; i < queueSize; i++) {
			stringBuilder.append(i > 0 ? ", " : "");
			stringBuilder.append(currentFront.data);
			currentFront = currentFront.next;
		}

		stringBuilder.append("]");

		return stringBuilder.toString();
	}
}
