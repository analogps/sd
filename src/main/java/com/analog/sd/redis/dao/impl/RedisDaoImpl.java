package com.analog.sd.redis.dao.impl;

import com.analog.sd.redis.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;


@Repository
public class RedisDaoImpl implements RedisDao {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public String get(String key) {
		return stringRedisTemplate.opsForValue().get(key);

	}

	@Override
	public List<String> lrange(String key, long start, long end) {
		return stringRedisTemplate.opsForList().range(key, start, end);
	}

	@Override
	public boolean exists(String key) {
		return stringRedisTemplate.hasKey(key);
	}

	@Override
	public long rpush(String key, String value) {
		return stringRedisTemplate.opsForList().rightPush(key, value);
	}

	@Override
	public void set(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);

	}

	@Override
	public Set<String> keys(String key) {
		return stringRedisTemplate.keys(key);
	}

	@Override
	public void delete(String key) {
		stringRedisTemplate.delete(key);
	}

	@Override
	public void hset(String key, String field, String value) {
		stringRedisTemplate.opsForHash().put(key, field, value);
	}

	@Override
	public String hget(String key, String field) {
		// TODO Auto-generated method stub
		return (String) stringRedisTemplate.opsForHash().get(key, field);
	}

	@Override
	public Map<String, String> hgetAll(String key) {
		Map<Object, Object> entries = stringRedisTemplate.opsForHash().entries(key);
		Set<Entry<Object, Object>> entrySet = entries.entrySet();
		Map<String, String> map = null;
		if (entries != null) {
			map = new HashMap<>();
			for (Entry<Object, Object> objKey : entrySet) {
				map.put(objKey.getKey().toString(), objKey.getValue().toString());
			}
		}
		return map;
	}

	@Override
	public void set(String key, Object object) {
		redisTemplate.opsForValue().set(key, object);
	}

	@Override
	public void set(String key, Object object, long millisecond_timeout) {
		if(millisecond_timeout != -1 && millisecond_timeout > 0) {
			redisTemplate.opsForValue().set(key, object, millisecond_timeout, TimeUnit.MILLISECONDS);//millisecond_timeout不能是0否则会报错
		}else {
			set(key, object);
		}
		
	}
	
	@Override
	public Object getObject(String key) {
		return redisTemplate.boundValueOps(key).get();
	}

	@Override
	public void lremove(String key, long count, Object vaue) {
		stringRedisTemplate.opsForList().remove(key, count, vaue);
	}

	@Override
	public void expire(String key, long millisecond_timeout) {
		stringRedisTemplate.expire(key, millisecond_timeout, TimeUnit.MILLISECONDS);
		
	}

	@Override
	public Boolean setIfAbsent(String key, String value) {
		return redisTemplate.opsForValue().setIfAbsent(key, value);
		
	}
	
	@Override
	public void setStr(String key, String value, long millisecond_timeout) {
		if(millisecond_timeout != -1 && millisecond_timeout > 0) {
			stringRedisTemplate.opsForValue().set(key, value, millisecond_timeout, TimeUnit.MILLISECONDS);//millisecond_timeout不能是0否则会报错
		}else {
			stringRedisTemplate.opsForValue().set(key, value);
		}
		
	}

	@Override
	public boolean zadd(String key, Object value, long millisecond_timeout) {
		return redisTemplate.opsForZSet().add(key, value, millisecond_timeout);
	}

	@Override
	public Long zremove(String key, Object value) {
		return redisTemplate.opsForZSet().remove(key, value);
	}

	@Override
	public Set<ZSetOperations.TypedTuple<Object>> zrangewithscore(String key, long start, long end) {
		return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
	}

}
