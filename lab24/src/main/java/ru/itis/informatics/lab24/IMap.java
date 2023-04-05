package ru.itis.informatics.lab24;

import java.util.List;

public interface IMap {
	/**
	 * Значение ключа уникально, при попытке положить пару с
	 * уже существующим ключем, меням значение value на новое
	 * @param key unique not null
	 * @param value not null
	 */
	void put(String key, Integer value);

	/**
	 * @param key
	 * @return null или найденное значение
	 */
	Integer getValueByKey(String key);

	/**
	 * @param value
	 * @return null или массив ключей, соответствующих значению
	 */
	List<String> getKeysByValue(Integer value);

	void removeByKey(String key);

	/**
	 * удалить все пары, соответствующие значению
	 * @param value
	 */
	void removeByValue(Integer value);

	List<String> getAllKeys();


}