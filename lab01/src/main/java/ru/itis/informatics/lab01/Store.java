package ru.itis.informatics.lab01;

public class Store {
	private float square;
	private String address;

	public Store(float square, String address) {
		this.square = square;
		this.address = address;
	}

	public float getSquare() {
		return square;
	}

	public void setSquare(float square) {
		this.square = square;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
