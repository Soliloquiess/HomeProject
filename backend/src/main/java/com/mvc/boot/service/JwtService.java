package com.mvc.boot.service;

import java.util.Map;

public interface JwtService {
	<T> String create(String key, T data, String subject);
	public boolean isUsable(String jwt);
	public Map<String, Object> get(String key);
}
