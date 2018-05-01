package com.yanalysis.oathink.component;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class OAThinkCacheComp {
	private static final Logger logger = LoggerFactory.getLogger(OAThinkCacheComp.class);
	
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void set(String key, String value) {
		ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
		if (!this.stringRedisTemplate.hasKey(key)) {
			ops.set(key, value);
			logger.debug("set key success");
		} else {
			logger.debug("this key = " + ops.get(key));
		}
	}
	
	public void expire(String key, long timeout) {
		this.stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
	}

	public String get(String key) {
		return this.stringRedisTemplate.opsForValue().get(key);
	}

	public void del(String key) {
		this.stringRedisTemplate.delete(key);
	}
}
