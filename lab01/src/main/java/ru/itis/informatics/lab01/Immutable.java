package ru.itis.informatics.lab01;

public final class Immutable {
	private final String immutableField;

	public Immutable(final String field) {
		this.immutableField = field;
	}

	public String getImmutableField() {
		return immutableField;
	}
}
