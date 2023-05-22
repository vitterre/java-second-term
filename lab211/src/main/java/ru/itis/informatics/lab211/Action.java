package ru.itis.informatics.lab211;

import java.util.Date;

public final class Action {
	private final String ticker;
	private final String per;
	private final String date;
	private final Integer time;
	private final Double close;

	public Action(String ticker, String per, String date, Integer time, Double close) {
		this.ticker = ticker;
		this.per = per;
		this.date = date;
		this.time = time;
		this.close = close;
	}

	public String getTicker() {
		return ticker;
	}

	public String getPer() {
		return per;
	}

	public String getDate() {
		return date;
	}

	public Integer getTime() {
		return time;
	}

	public Double getClose() {
		return close;
	}

	@Override
	public String toString() {
		return "Action{" +
						"ticker='" + ticker + '\'' +
						", per='" + per + '\'' +
						", date=" + date +
						", time=" + time +
						", close=" + close +
						'}';
	}
}
