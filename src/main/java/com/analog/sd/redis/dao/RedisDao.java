package com.analog.sd.redis.dao;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisDao {

	String get(String key);

	List<String> lrange(final String key, long start, long end);

	boolean exists(final String key);

	long rpush(final String key, String value);

	Map<String, String> hgetAll(String key);

	void set(String key, String value);
	
	Boolean setIfAbsent(String key, String value);

	Set<String> keys(String key);

	void delete(String key);

	void hset(final String key, final String field, final String value);

	String hget(String key, String field);
	
	void set(String key, Object object);
	
	void set(String key, Object object, long millisecond_timeout);

	Object getObject(String key);

	void lremove(String key, long count, Object vaue);

	void expire(String key, long millisecond_timeout);

	void setStr(String key, String value, long millisecond_timeout);

	boolean zadd(String key, Object value, long millisecond_timeout);

	Long zremove(String key, Object value);

	Set<ZSetOperations.TypedTuple<Object>> zrangewithscore(String key, long start, long end);

	
}
