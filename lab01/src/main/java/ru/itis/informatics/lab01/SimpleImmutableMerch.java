package ru.itis.informatics.lab01;

public final class SimpleImmutableMerch {
	private final int article;
	private final int count;
	private final int price;
	private final Store store;

	private Integer a;

	public SimpleImmutableMerch(final int article, final int count, final int price, final Store store) {
		this.article = article;
		this.count = count;
		this.price = price;
		this.store = store;
	}

	public int getArticle() {
		return article;
	}

	public int getCount() {
		return count;
	}

	public int getPrice() {
		return price;
	}

	public Store getStore() {
		// Now it's immutable!
		return new Store(store.getSquare(), store.getAddress());
	}

	@Override
	public String toString() {
		return "SimpleImmutableMerch{" +
						"article=" + article +
						", count=" + count +
						", price=" + price +
						", store=" + store.getAddress() +
						'}';
	}
}
