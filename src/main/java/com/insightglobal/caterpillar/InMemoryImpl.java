package com.insightglobal.caterpillar;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryImpl implements Service {
	private ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();

	@Override
	public Object get(String key) {

		if (!map.containsKey(key)) {
			return "key is not present";
		} else {
			return map.get(key);
		}
	}

	@Override
	public void put(String key, Object value) {
		map.put(key, value);

	}

}
