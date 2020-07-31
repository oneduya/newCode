package org.apache.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName: TestRedis
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/19 14:42
 * @Version: V0.1
 */
public class TestRedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.1.103",6379);
		jedis.set("dog","1");
		jedis.incr("dog");
		jedis.close();
	}
}
